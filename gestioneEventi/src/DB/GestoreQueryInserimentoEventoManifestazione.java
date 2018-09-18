package DB;

import Model.EventoManifestazione;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GestoreQueryInserimentoEventoManifestazione extends GestoreQueryInserimentoEvento<EventoManifestazione> {

    public GestoreQueryInserimentoEventoManifestazione(EventoManifestazione eventoManifestazione ){ super(eventoManifestazione);}

    @Override
    public void eseguiEPreparaQueryInserimentoEvento() throws SQLException {
        super.eseguiEPreparaQueryInserimentoEvento();
        inserisciAttributiEventoSpecifico();

    }
    @Override
    public void inserisciAttributiEventoSpecifico() throws SQLException {
        eseguiEPreparaQueryInserimentoEvento();}


    @Override
    public Map<Integer, String> creaMapQueryEventoSpecifico() throws SQLException {
        Map<Integer,String> nuovaMappa= new HashMap<Integer,String>();
        //Query che deve essere eseguita per prima
        nuovaMappa.put(1,"SELECT * FROM ARTISTA WHERE NOME_ARTISTA=?");
        //Query che deve essere eseguita per seconda
        nuovaMappa.put(2,"INSERT INTO ARTISTA VALUES(?)");
        //Query per inserire i partecipanti, per ultima
        nuovaMappa.put(3,"INSERT INTO ARTISTI_EVENTO_MANIFESTAZIONE VALUES(?,?)");
        return nuovaMappa;


    }

    @Override
    public void eseguiEPreparaQueryInserimentoEventoSpecifico() throws SQLException {
        PreparedStatement queryEventoManifestazione = preparaQueryInserimentoEventoSpecifico();
        eseguiUpdate(queryEventoManifestazione);
        inserisciPartecipantiEvento(creaMapQueryEventoSpecifico(),getEventoDaInserire().getSpecialGuest());
        UtilityDB.closeDB(queryEventoManifestazione);

    }

    @Override
    public PreparedStatement preparaQueryInserimentoEventoSpecifico() throws SQLException {
        PreparedStatement queryDaEseguire = preparaQueryDaEseguire("INSERT INTO EVENTO_MANIFESTAZIONE VALUES (?,?)");
        queryDaEseguire.setInt(1,getIdEventoInserito());
        queryDaEseguire.setString(2,getEventoDaInserire().getGenereFestival().name());
        return queryDaEseguire;
    }

}
