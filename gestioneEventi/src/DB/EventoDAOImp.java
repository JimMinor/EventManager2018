package DB;
import Model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class EventoDAOImp implements EventoDAO {

    private Evento eventoDaInserire;
    private GestoreQueryInserimentoEvento gestoreQueryInserimentoEvento;
    private GestoreQueryCerca gestoreQueryCerca;
    private GestoreQueryModificaElimina gestoreQueryModificaElimina;

    public void setEventoDaInserire(Evento eventoDaInserire) {
        this.eventoDaInserire = eventoDaInserire;
    }

    public EventoDAOImp(){

        gestoreQueryCerca = new GestoreQueryCerca();
        gestoreQueryModificaElimina = new GestoreQueryModificaElimina();
    }

    public EventoDAOImp(Evento eventoDaInserire) {

        this.eventoDaInserire = eventoDaInserire;
        gestoreQueryInserimentoEvento =  new GestoreQueryInserimentoEvento(eventoDaInserire);
        gestoreQueryCerca = new GestoreQueryCerca();
        gestoreQueryModificaElimina = new GestoreQueryModificaElimina();
    }

    @Override public void inserisciEvento () throws SQLException {
        gestoreQueryInserimentoEvento.eseguiEPreparaQueryInserimentoEvento(); }

    @Override public List<Evento> cercaEvento (String nomeEvento,LocalDate dataEvento, LuogoEnum luogoEvento) throws SQLException {
        return gestoreQueryCerca.eseguiQueryRicercaEventi(nomeEvento,luogoEvento,dataEvento);
    }

     public List<Evento> cercaEvento () throws SQLException {
        return gestoreQueryCerca.eseguiQueryRicercaEventi();
    }

    @Override public void eliminaEvento (Evento eventoDaEliminare) throws SQLException{
        gestoreQueryModificaElimina.eseguiQueryEliminaEvento(eventoDaEliminare);
    }

    @Override public void modificaEvento (int eventoID, LocalDate data, LuogoEnum luogo ) throws SQLException {
        gestoreQueryModificaElimina.eseguiQueryModificaEvento(eventoID,data,luogo);
    }
}
