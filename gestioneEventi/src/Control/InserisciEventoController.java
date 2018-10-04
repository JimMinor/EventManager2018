package Control;

import View.InserisciEventoView;
import View.MostraAlert;
import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.Evento;
import Model.LuogoEnum;
import Model.TipologiaEnum;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/** Classe che si occupa di controllare
 *  i dati inseriti nella classe InserisciEventoView,
 *  e comunicare con la classe EventoDAO, per inserire
 *  l'evento creato.
 *
 */
public class InserisciEventoController {

    /** Oggetti e metodi MVC */
    private Evento evento;
    private InserisciEventoView inserisciEventoView;

    public InserisciEventoController(Evento evento, InserisciEventoView inserisciEventoView){
        this.evento = evento;
        this.inserisciEventoView = inserisciEventoView;
        setListenerInserisciEventoView();
    }

    /** Settaggio  Listener per il form InserisciEventoView */
    private void setListenerInserisciEventoView(){
          setListenerPrezzoEvento();
          setListenerInserisciEvento();
          setListenerAggiungiPartecipanti();
          setListenerTipologiaSelezionata();
    }

    private void setListenerPrezzoEvento(){
        // La TextField del prezzo dovra' leggere solo float
        TextField prezzoBigliettoTextField = inserisciEventoView.getPrezzoBigliettoTextField();
        prezzoBigliettoTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d\\.\\d")) {
                    prezzoBigliettoTextField.setText(newValue.replaceAll("[^\\d\\.\\d]", ""));
                }
            }
        });
    }

    private void setListenerInserisciEvento(){
        // Listener per Button 'Inserisci'
        Button inserisciButton = inserisciEventoView.getInserisciButton();
        inserisciButton.addEventHandler(javafx.event.ActionEvent.ACTION, event -> Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try{
                    controllaDatiEvento();
                } catch ( NoValidEventDataException e) {
                    MostraAlert.mostraAlertErroreInserimentoEvento(e.getMessage());
                }
            };
        }));

    }

    private void setListenerAggiungiPartecipanti() {
        Button aggiungiButton = inserisciEventoView.getAggiungiButton();
        TextField partecipanteTextField = inserisciEventoView.getPartecipanteEventoTextField();
        aggiungiButton.addEventHandler(ActionEvent.ACTION, event ->  Platform.runLater(new Runnable() {
            @Override
            public void run () {

                String partecipante = partecipanteTextField.getText();
                Set<String> setPartecipanti = evento.getPartecipantiEvento();
                setPartecipanti = new HashSet<>();
                setPartecipanti.add(partecipante);
                evento.setPartecipantiEvento(setPartecipanti);
                partecipanteTextField.clear();

            }
        }));

    }

    private void setListenerTipologiaSelezionata(){
        ComboBox<TipologiaEnum> tipologiaEvento = inserisciEventoView.getTipologiaEventoComboBox();
        tipologiaEvento.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inserisciEventoView.getGenereEventoComboBox().
                        setItems(FXCollections.observableArrayList(tipologiaEvento.getSelectionModel().getSelectedItem().getListaGeneri()));
            }
        });

    }

    private synchronized void controllaDatiEvento() throws NoValidEventDataException {
        // Controllo DATE: Diverso da NULL e data non passata
        LocalDate dataEvento = inserisciEventoView.getDataEventoDatePicker().getValue();
        if (dataEvento == null || dataEvento.isBefore(LocalDate.now()))
            throw new NoValidEventDataException("Data Non Valida");

        // Controllo NOME EVENTO: Diverso da NULL e almeno lenght>=8
        String nomeEvento = inserisciEventoView.getNomeEventoTextField().getText();
        if (nomeEvento == null || nomeEvento.equals("") || nomeEvento.length() < 8 || nomeEvento.matches("\\d+"))
            throw new NoValidEventDataException("Nome inserito non valido:\n\n Controllare:\n - Lunghezza minimo 8 caretteri "+
                    " alfanumerici\n - Sono stati inseriti solo numeri\n ");

        //Controllo Prezzo Biglietto: Diverso da NULL e >0 e che deve essere un Double
        // Aggiungere controllo se non e' stata passta una stirnga
        Float prezzoBiglietto = Float.valueOf(inserisciEventoView.getPrezzoBigliettoTextField().getText());
        if (prezzoBiglietto == null || prezzoBiglietto <= 0.00)
            throw new NoValidEventDataException("Prezzo biglietto non valido");

        // Controllo che TipologiaEvento e LuogoEvento non siano vuoti(non selezionati)
        TipologiaEnum tipologiaEvento = inserisciEventoView.getTipologiaEventoComboBox().getValue();
        if (tipologiaEvento == null || tipologiaEvento.equals(""))
            throw new NoValidEventDataException("Inserire tipologia di evento");

        LuogoEnum luogoEvento = inserisciEventoView.getLuogoEventoComboBox().getValue();
        if (luogoEvento == null) throw new NoValidEventDataException("Inserire luogo dell'evento");

        // Controllo DESCRIZIONE: MAX 200 Caratteri può essere null
        String descrizioneEvento = inserisciEventoView.getDescrizioneEventoTextArea().getText();
        if (descrizioneEvento == null) descrizioneEvento = "";//Puo' essere null
        if (descrizioneEvento.length() > 200) throw new NoValidEventDataException("Descrizione" +
                "supera i limiti concessi");

        // Controllo GENERE
        String genereEvento = inserisciEventoView.getGenereEventoComboBox().getValue();
        if (genereEvento.equals("") || genereEvento == null)
            throw new NoValidEventDataException("Selezionare un genere per " +
                    "l'evento");

        // Controllo Insieme di artisti:
        Set<String> partecipantiEvento = evento.getPartecipantiEvento();
        // SPORTIVO: {NUOTO,CICLISMO,ALTELITCA, GOLF} PUO' AVERE PIU' DI UN PARTECIPANTE
        if (tipologiaEvento == TipologiaEnum.SPORTIVO && (!genereEvento.equals("NUOTO") || !genereEvento.equals("CICLISMO") ||
                !genereEvento.equals("ATLETICA") || !genereEvento.equals("GOLF")) && partecipantiEvento.size() > 2) {
            partecipantiEvento.clear();
            throw new NoValidEventDataException("Inserire esattamente due partecipanti, riprovare");
        }

        // Musicale &&  Teatrale: almeno un artista

        if ((tipologiaEvento == TipologiaEnum.MUSICALE || tipologiaEvento == TipologiaEnum.TEATRO)
                && partecipantiEvento.size() < 1) throw new NoValidEventDataException(" Inserire almeno un artista");


        // Controllo disponibilità luogo:

        // Setto i parametri dell'evento
        evento.setDataEvento(dataEvento);
        evento.setNome(nomeEvento);
        evento.setTipologiaEvento(tipologiaEvento);
        evento.setGenereEvento(genereEvento);
        evento.setPrezzoBiglietto(prezzoBiglietto);
        evento.setLuogoEvento(luogoEvento);
        evento.setCapienzaMassima(luogoEvento.getNumPosti());
        evento.setCitta(luogoEvento.getCittaLuogo());
        evento.setDescrizione(descrizioneEvento);
        evento.setIdEvento(0);


        Task inserisciEventoTask = new Task() {
            @Override
            protected Object call() throws Exception {
                try {
                    eventoDAO.inserisciEvento(evento);
                    MostraAlert.mostraAlertEventoInserito();
                } catch (Exception ee) {
                    ee.printStackTrace();
                    MostraAlert.mostraAlertErroreInserimentoEvento(ee.getMessage());
                }
                return null;
            }
        };
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                inserisciEventoTask.run();
            }
        });

    }

    /** Oggetti e metodi DAO */

    private EventoDAO eventoDAO = new EventoDAOImp();

    public InserisciEventoController(InserisciEventoView inserisciEventoView){
        this.inserisciEventoView = inserisciEventoView;
        setListenerInserisciEventoView();
    }


}
