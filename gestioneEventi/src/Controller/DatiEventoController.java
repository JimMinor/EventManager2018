package Controller;

import ControllerView.InserisciEventoControllerView;
import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.Evento;
import Model.LuogoEnum;
import Model.TipologiaEnum;

import java.time.LocalDate;
import java.util.Set;

public class DatiEventoController {

    private InserisciEventoControllerView datiEvento;
    private EventoDAO eventoDAO = new EventoDAOImp();

    public DatiEventoController (InserisciEventoControllerView datiEvento){
        this.datiEvento = datiEvento;
    }

    public void controllaDatiEvento() throws NoValidEventDataException, Exception {
        // Controllo DATE: Diverso da NULL e data non passata
        LocalDate dataEvento = datiEvento.getDataEventoDatePicker().getValue();
        if (dataEvento == null || dataEvento.isBefore(LocalDate.now()))
            throw new NoValidEventDataException("Data Non Valida");

        // Controllo NOME EVENTO: Diverso da NULL e almeno lenght>=8
        String nomeEvento = datiEvento.getNomeEventoTextField().getText();
        if (nomeEvento == null || nomeEvento.equals("") || nomeEvento.length() < 8)
            throw new NoValidEventDataException("Nome non inserito, oppure" +
                    "numero di caratteri minimo non raggiunto");

        //Controllo Prezzo Biglietto: Diverso da NULL e >0 e che deve essere un Double
        // Aggiungere controllo se non e' stata passta una stirnga
        Float prezzoBiglietto = Float.valueOf(datiEvento.getPrezzoBigliettoTextField().getText());
        if (prezzoBiglietto == null || prezzoBiglietto <= 0.00)
            throw new NoValidEventDataException("Prezzo biglietto non valido");

        // Controllo che TipologiaEvento e LuogoEvento non siano vuoti(non selezionati)
        TipologiaEnum tipologiaEvento = datiEvento.getTipologiaEventoComboBox().getValue();
        if (tipologiaEvento == null || tipologiaEvento.equals("")) throw new NoValidEventDataException("Inserire tipologia di evento");

        LuogoEnum luogoEvento = datiEvento.getLuogoEventoComboBox().getValue();
        if (luogoEvento == null) throw new NoValidEventDataException("Inserire luogo dell'evento");

        // Controllo DESCRIZIONE: MAX 200 Caratteri può essere null
        String descrizioneEvento = datiEvento.getDescrizioneEventoTextArea().getText();
        if (descrizioneEvento == null) descrizioneEvento = "";//Puo' essere null
        if (descrizioneEvento.length() > 200) throw new NoValidEventDataException("Descrizione" +
                "supera i limiti concessi");

        // Controllo GENERE
        String genereEvento = datiEvento.getGenereEventoComboBox().getValue();
        if(genereEvento.equals("")|| genereEvento==null) throw new NoValidEventDataException("Selezionare un genere per " +
                "l'evento");

        // Controllo Insieme di artisti:
        Set<String> partecipantiEvento = datiEvento.getPartecipantiEvento();
        // SPORTIVO: {NUOTO,CICLISMO,ALTELITCA, GOLF} PUO' AVERE PIU' DI UN PARTECIPANTE
        if ( tipologiaEvento==TipologiaEnum.SPORTIVO && ( !genereEvento.equals("NUOTO") || !genereEvento.equals("CICLISMO") ||
                !genereEvento.equals("ATLETICA") || !genereEvento.equals("GOLF")) && partecipantiEvento.size()>2) {
            partecipantiEvento.clear();
            throw new NoValidEventDataException("Inserire esattamente due partecipanti, riprovare");
        }

        // Musicale &&  Teatrale: almeno un artista

        if( (tipologiaEvento == TipologiaEnum.MUSICALE || tipologiaEvento == TipologiaEnum.TEATRO)
        && partecipantiEvento.size()<1) throw new NoValidEventDataException(" Inserire almeno un artista");





        // Controllo disponibilità luogo:

        Evento e = new Evento(luogoEvento,descrizioneEvento,prezzoBiglietto,tipologiaEvento,
                nomeEvento,dataEvento,genereEvento,partecipantiEvento);

       eventoDAO.inserisciEvento(e);

    }
}
