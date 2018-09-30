package Controller;

import ControllerView.CercaEventoControllerView;
import ControllerView.MostraAlert;
import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.VisualizzaEventiModel;
import Model.Evento;
import Model.LuogoEnum;

import java.sql.SQLException;
import java.time.LocalDate;

public class RicercaEventoController {

    private VisualizzaEventiModel visualizzaEventiModel;
    private EventoDAO eventoDAO = new EventoDAOImp();

    public RicercaEventoController(VisualizzaEventiModel cercaEventoModel){
        this.visualizzaEventiModel =cercaEventoModel;
    }

    public void  eliminaEventoSelezionato(Evento eventoSelezionato){

        try {
            if(eventoSelezionato!=null) {
                eventoDAO.eliminaEvento(eventoSelezionato);
                visualizzaEventiModel.setListaEventiView(((EventoDAOImp) eventoDAO).cercaEvento());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void  modificaEventoSelezionato(Evento eventoSelezionato, LocalDate data, LuogoEnum luogo){
        try {
            // Controllo sui dati:
            if ( data == null ) throw new NoValidEventDataException("Inserire Data");
            if ( luogo == null ) throw  new NoValidEventDataException("Selezionare Luogo");

            eventoDAO.modificaEvento(eventoSelezionato.getIdEvento(),data,luogo);
            visualizzaEventiModel.setListaEventiView(((EventoDAOImp) eventoDAO).cercaEvento());

        } catch ( SQLException e ){
            e.printStackTrace();
        }
        catch ( NoValidEventDataException e2) {

            MostraAlert.mostraAlertErroreInserimentoEvento(e2.getMessagge());
        }
    }

    public void cercaEventi (String nomeEvento,LocalDate dataEvento, LuogoEnum luogoEvento) {

        try {
            visualizzaEventiModel.setListaEventiView(((EventoDAOImp) eventoDAO).cercaEvento(nomeEvento, dataEvento, luogoEvento));
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

}
