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

    public EventoDAOImp(){}

    public EventoDAOImp(Evento eventoDaInserire) {

        this.eventoDaInserire = eventoDaInserire;
        gestoreQueryInserimentoEvento =  new GestoreQueryInserimentoEvento(eventoDaInserire);
        gestoreQueryCerca = new GestoreQueryCerca();
    }

    @Override public void inserisciEvento() throws SQLException {
       gestoreQueryInserimentoEvento.eseguiEPreparaQueryInserimentoEvento(); }

    @Override public List<Evento> cercaEvento(String nomeEvento,LocalDate dataEvento, LuogoEnum luogoEvento){

       // return gestoreQueryCerca.cercaEvento(nomeEvento,luogoEvento,dataEvento);
        return null;
    }

    public boolean eliminaEvento() throws SQLException{return false;}
}
