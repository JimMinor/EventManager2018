package DB;

import Model.EventoTeatrale;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class GestoreQueryInserimentoEventoTeatrale extends GestoreQueryInserimentoEvento<EventoTeatrale> {

    public GestoreQueryInserimentoEventoTeatrale(EventoTeatrale eventoTeatrale)
    {
        super(eventoTeatrale);
    }

    @Override public void eseguiEPreparaQueryInserimentoEvento() throws SQLException {
        super.eseguiEPreparaQueryInserimentoEvento();
        inserisciAttributiEventoSpecifico();

    }

    @Override public void inserisciAttributiEventoSpecifico() throws SQLException {
        eseguiEPreparaQueryInserimentoEvento();
    }

    @Override public Map<Integer, String> creaMapQueryEventoSpecifico() throws SQLException {
        Map<Integer,String> nuovaMappa= new HashMap<Integer,String>();
        //Query che deve essere eseguita per prima
        nuovaMappa.put(1,"SELECT * FROM ARTISTA WHERE NOME_ARTISTA=?");
        //Query che deve essere eseguita per seconda
        nuovaMappa.put(2,"INSERT INTO ARTISTA VALUES(?)");
        //Query per inserire i partecipanti, per ultima
        nuovaMappa.put(3,"INSERT INTO ARTISTI_EVENTO_TEATRALE VALUES(?,?)");
        return nuovaMappa;
    }

    @Override public void eseguiEPreparaQueryInserimentoEventoSpecifico() throws SQLException {
        PreparedStatement queryEventoTeatrale = preparaQueryInserimentoEventoSpecifico();
        eseguiUpdate(queryEventoTeatrale);
        inserisciPartecipantiEvento(creaMapQueryEventoSpecifico(),getEventoDaInserire().getArtisti());
        UtilityDB.closeDB(queryEventoTeatrale);
    }

    @Override public PreparedStatement preparaQueryInserimentoEventoSpecifico() throws SQLException {
        PreparedStatement queryDaEseguire  = preparaQueryDaEseguire("INSERT INTO EVENTO_TEATRALE VALUES(?,?)");
        queryDaEseguire.setInt(1,getIdEventoInserito());
        queryDaEseguire.setString(2,getEventoDaInserire().getGenereSpettacolo().name());
        return queryDaEseguire;
    }
}
