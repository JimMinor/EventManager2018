package DB;
import Model.*;
import ControllerView.MostraAlert;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class EventoDAOImp implements EventoDAO {

    private Evento eventoDaInserire;

    public EventoDAOImp(){}

    public EventoDAOImp(Evento eventoDaInserire) {
        this.eventoDaInserire = eventoDaInserire;
    }

    @Override public void inserisciEvento() throws SQLException {
        new GestoreQueryInserimentoEvento(eventoDaInserire).eseguiEPreparaQueryInserimentoEvento(); }

    @Override public List<Evento> cercaEvento(){
        return null;
    }

    public boolean cercaEvento(LocalDate data,LuogoEnum luogo){
       try{
           return new GestoreQueryInserimentoEvento().cercaEventoDB(data,luogo);
       }
       catch (SQLException e) {
            e.printStackTrace();
       }
       return false;
    }
}
