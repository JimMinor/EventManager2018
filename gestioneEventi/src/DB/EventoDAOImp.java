package DB;
import Model.*;
import ControllerView.MostraAlert;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class EventoDAOImp implements EventoDAO {

    private Evento eventoDaInserire;
    private GestoreQueryInserimentoEvento gestoreQueryInserimentoEvento;
    private GestoreQueryCerca gestoreQueryCerca;

    public EventoDAOImp(){
        gestoreQueryCerca = new GestoreQueryCerca();
    }

    public EventoDAOImp(Evento eventoDaInserire) {

        this.eventoDaInserire = eventoDaInserire;
        gestoreQueryInserimentoEvento =  new GestoreQueryInserimentoEvento(eventoDaInserire);
        gestoreQueryCerca = new GestoreQueryCerca();
    }

    @Override public void inserisciEvento() throws SQLException {
       gestoreQueryInserimentoEvento.eseguiEPreparaQueryInserimentoEvento(); }

    @Override public List<Evento> cercaEvento(String nomeEvento,LocalDate dataEvento, LuogoEnum luogoEvento){

        List<Evento> list=null;
        try {
            list = gestoreQueryCerca.cercaEvento(nomeEvento,luogoEvento,dataEvento);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return list;

    }

    public boolean eliminaEvento() throws SQLException{return false;}
}
