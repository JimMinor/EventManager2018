package Controller;

import ControllerView.CercaEventoControllerView;
import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.VisualizzaEventiModel;
import Model.Evento;
import Model.LuogoEnum;

import java.time.LocalDate;

public class RicercaEventoController {

    private VisualizzaEventiModel visualizzaEventiModel;
    private CercaEventoControllerView cercaEventoControllerView;

    public RicercaEventoController(VisualizzaEventiModel cercaEventoModel,
                                   CercaEventoControllerView cercaEventoControllerView){
        this.visualizzaEventiModel =cercaEventoModel;
        this.cercaEventoControllerView=cercaEventoControllerView;

    }

    public boolean eliminaEventoSelezionato(Evento eventoSelezionato){
        EventoDAO eventoDAO = new EventoDAOImp(eventoSelezionato);
        try {
            return eventoDAO.eliminaEvento();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean modificaEventoSelezionato(Evento eventoSelezionato, LocalDate data, LuogoEnum luogo){
        return false;
    }

    public void cercaEventi(){
        EventoDAO eventoDAO = new EventoDAOImp();
        visualizzaEventiModel.setListaEventiView(((EventoDAOImp) eventoDAO).cercaEvento());
    }


}
