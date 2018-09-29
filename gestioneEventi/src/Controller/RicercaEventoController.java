package Controller;

import ControllerView.CercaEventoControllerView;
import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.VisualizzaEventiModel;
import Model.Evento;
import Model.LuogoEnum;

import java.sql.SQLException;
import java.time.LocalDate;

public class RicercaEventoController {

    private VisualizzaEventiModel visualizzaEventiModel;
    private CercaEventoControllerView cercaEventoControllerView;
    EventoDAO eventoDAO = new EventoDAOImp();

    public RicercaEventoController(VisualizzaEventiModel cercaEventoModel,
                                   CercaEventoControllerView cercaEventoControllerView){
        this.visualizzaEventiModel =cercaEventoModel;
        this.cercaEventoControllerView=cercaEventoControllerView;

    }

    public void  eliminaEventoSelezionato(Evento eventoSelezionato){
        EventoDAO eventoDAO = new EventoDAOImp(eventoSelezionato);
        try {

            eventoDAO.eliminaEvento(eventoSelezionato);
            visualizzaEventiModel.setListaEventiView(((EventoDAOImp) eventoDAO).cercaEvento());
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean modificaEventoSelezionato(Evento eventoSelezionato, LocalDate data, LuogoEnum luogo){
        return false;
    }

    public void cercaEventi(String nomeEvento,LocalDate dataEvento, LuogoEnum luogoEvento) {

        try {
            visualizzaEventiModel.setListaEventiView(((EventoDAOImp) eventoDAO).cercaEvento(nomeEvento, dataEvento, luogoEvento));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
