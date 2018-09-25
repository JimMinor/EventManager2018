package ControllerView;

import Controller.*;
import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.Evento;
import Model.LuogoEnum;
import Model.TipologiaEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.*;

public class InserisciEventoController {

    //FXMLView Fields---------------------------
    @FXML private Button annullaButton;
    @FXML private Button inserisciButton;
    @FXML private Button aggiungiButton;
    @FXML private DatePicker dataEventoDatePicker;
    @FXML private TextArea descrizioneEventoTextArea;
    @FXML private ComboBox<LuogoEnum> luogoEventoComboBox;
    @FXML private TextField nomeEventoTextField;
    @FXML private TextField prezzoBigliettoTextField;
    @FXML private TextField partecipanteEventoTextField;
    @FXML private ComboBox<String> genereEventoComboBox;
    @FXML private ComboBox<TipologiaEnum> tipologiaEventoComboBox;
    // Utilies Fields---------------------------------
    private TipologiaEnum tipologiaEvento;
    private ObservableList<LuogoEnum> listaLuoghiEvento;
    private CambiaView creaFormEventoSpecifico;
    private EventoSpecificoForm datiEventoSpecifico;
    private Set<String> partecipantiEvento;
    private EventoDAO eventoDAO;


    /**
     *       Metodi per l'inizializzazione
     */

    public void initialize() {
        luogoEventoComboBox.setItems(FXCollections.observableArrayList(LuogoEnum.values()));
        tipologiaEventoComboBox.setItems(FXCollections.observableArrayList(TipologiaEnum.values()));
    }

    public InserisciEventoController(CambiaView cambiaView) {
        this.creaFormEventoSpecifico = cambiaView;
        partecipantiEvento= new HashSet<>();

    }

    /**GETTER per i campi da Inserire nell'evento*/

    public TextField getPrezzoBigliettoTextField() {
        return prezzoBigliettoTextField;
    }

    public DatePicker getDataEventoDatePicker() {
        return dataEventoDatePicker;
    }

    public TextArea getDescrizioneEventoTextArea() {
        return descrizioneEventoTextArea;
    }

    public ComboBox<LuogoEnum> getLuogoEventoComboBox() {
        return luogoEventoComboBox;
    }

    public TextField getNomeEventoTextField() {
        return nomeEventoTextField;
    }

    public TipologiaEnum getTipologiaEvento() {
        return tipologiaEvento;
    }

    public void setTipologiaEvento(TipologiaEnum tipologiaEvento) {
        this.tipologiaEvento = tipologiaEvento;
    }

    /**
     *  Metodi eventi ControllerView
     */
    @FXML public void inserisciEventoButtonPressed() {
       try {
           controllaDisponibilita();
           controllaDatiEvento();
           MostraAlert.mostraAlertEventoInserito();
           pulisciForm();

       }
       catch (NoValidEventDataException e) {
           MostraAlert.mostraAlertErroreInserimentoEvento(e.getMessagge());
       }
       catch( Exception e){
           e.printStackTrace();
           MostraAlert.mostraAlertErroreInserimentoEvento("Errore Inserimento Evento");
       }

    }

    private void controllaDisponibilita() throws NoValidEventDataException {
        EventoDAO eventoDAO = new EventoDAOImp();
        LocalDate data  = dataEventoDatePicker.getValue();
        LuogoEnum luogo = luogoEventoComboBox.getValue();
        if(((EventoDAOImp) eventoDAO).cercaEvento(data,luogo))
            throw  new NoValidEventDataException("Luogo occupato nella data selezionata, scegliere altra data o luogo ");

    }

    @FXML public void selezioneTipologia()
    {
        genereEventoComboBox.setItems(FXCollections.observableArrayList(tipologiaEventoComboBox.getValue().getListaGeneri()));
    }

    @FXML public void aggiungiButtonPressed(){
        partecipantiEvento.add(partecipanteEventoTextField.getText());
        partecipanteEventoTextField.clear();
    }

    private void pulisciForm() {
        descrizioneEventoTextArea.clear();
        nomeEventoTextField.clear();
        prezzoBigliettoTextField.clear();

    }

    private boolean controllaDatiEvento() throws NoValidEventDataException, Exception {
        // Controllo DATE: Diverso da NULL e data non passata
        LocalDate dataEvento = dataEventoDatePicker.getValue();
        if (dataEvento == null || dataEvento.isBefore(LocalDate.now()))
            throw new NoValidEventDataException("Data Non Valida");

        // Controllo NOME EVENTO: Diverso da NULL e almeno lenght>=8
        String nomeEvento = nomeEventoTextField.getText();
        if (nomeEvento == null || nomeEvento.equals("") || nomeEvento.length() < 8)
            throw new NoValidEventDataException("Nome non inserito, oppure" +
                    "numero di caratteri minimo non raggiunto");

        //Controllo Prezzo Biglietto: Diverso da NULL e >0 e che deve essere un Double
       Float prezzoBiglietto = Float.valueOf(prezzoBigliettoTextField.getText());
        if (prezzoBiglietto == null || prezzoBiglietto <= 0.00)
            throw new NoValidEventDataException("Prezzo biglietto non valido");

        // Controllo che TipologiaEvento e LuogoEvento non siano vuoti(non selezionati)
        TipologiaEnum tipologiaEvento = tipologiaEventoComboBox.getValue();
        if (tipologiaEvento == null || tipologiaEvento.equals("")) throw new NoValidEventDataException("Inserire tipologia di evento");

       LuogoEnum  luogoEvento = luogoEventoComboBox.getValue();
        if (luogoEvento == null) throw new NoValidEventDataException("Inserire luogo dell'evento");

        // Controllo DESCRIZIONE: MAX 200 Caratteri può essere null
       String descrizioneEvento = descrizioneEventoTextArea.getText();
        if (descrizioneEvento == null) descrizioneEvento = "";//Puo' essere null
        if (descrizioneEvento.length() > 200) throw new NoValidEventDataException("Descrizione" +
                "supera i limiti concessi");

        // Controllo GENERE
        String genereEvento = genereEventoComboBox.getValue();
        if(genereEvento.equals("")|| genereEvento==null) throw new NoValidEventDataException("Selezionare un genere per " +
                "l'evento");

        // Controllo Insieme di artisti:
        // SPORTIVO: {NUOTO,CICLISMO,ALTELITCA, GOLF} PUO' AVERE PIU' DI UN PARTECIPANTE
        if ( tipologiaEvento==TipologiaEnum.SPORTIVO && ( !genereEvento.equals("NUOTO") || !genereEvento.equals("CICLISMO") ||
        !genereEvento.equals("ATLETICA") || !genereEvento.equals("GOLF")) && partecipantiEvento.size()>2) {
            partecipantiEvento.clear();
            throw new NoValidEventDataException("Inserire esattamente due partecipanti, riprovare");
        }

        // Musicale



        // Controllo disponibilità luogo:

        Evento e = new Evento(luogoEvento,descrizioneEvento,prezzoBiglietto,tipologiaEvento,
                nomeEvento,dataEvento,genereEvento,partecipantiEvento);
        EventoDAO eventDAO = new EventoDAOImp(e);


        eventDAO.inserisciEvento();
        return true;
    }







}
