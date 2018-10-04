package DB;
import Model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class EventoDAOImp implements EventoDAO {


    private GestoreQueryInserimentoEvento gestoreQueryInserimentoEvento;
    private GestoreQueryCerca gestoreQueryCerca;
    private GestoreQueryModificaElimina gestoreQueryModificaElimina;

    public EventoDAOImp(){

        gestoreQueryInserimentoEvento =  new GestoreQueryInserimentoEvento();
        gestoreQueryCerca = new GestoreQueryCerca();
        gestoreQueryModificaElimina = new GestoreQueryModificaElimina();
    }

    @Override public void inserisciEvento (Evento evento) throws SQLException {
        gestoreQueryInserimentoEvento.setEventoDaInserire(evento);
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
