package DB;

import Model.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//TODO: Gestire meglio gli errori

/**
 *
 * Questa Classe si occupata di gestire tutti gli aspetti necessari,
 * per creare->preparare->settare la query per l'inserimento
 * di un evento sportivo, per in infine inseririla nel DB
 *
 */
public class GestoreQueryInserimentoEventoSportivo extends GestoreQueryInserimentoEvento<EventoSportivo> {

    public GestoreQueryInserimentoEventoSportivo(EventoSportivo eventoSportivo){
        super(eventoSportivo);
    }

    @Override public  void eseguiEPreparaQueryInserimentoEvento() throws SQLException {
        // Viene inserito l'evento e i suoi attributi comuni a tutti
        super.eseguiEPreparaQueryInserimentoEvento();
        // Vengono inseriti i partecipanti dell'evento sportivo
        inserisciAttributiEventoSpecifico();
        }

    @Override public void eseguiEPreparaQueryInserimentoEventoSpecifico() throws SQLException {
        PreparedStatement queryEventoSportivo =preparaQueryInserimentoEventoSpecifico();
        eseguiUpdate(queryEventoSportivo);// Inserisce ID e SPORT
        inserisciPartecipantiEvento(creaMapQueryEventoSpecifico(),getEventoDaInserire().getPartecipanti());
        UtilityDB.closeDB(queryEventoSportivo);
         }

    @Override public Map<Integer,String> creaMapQueryEventoSpecifico() {
       Map<Integer,String> nuovaMappa= new HashMap<Integer,String>();
       //Query che deve essere eseguita per prima
       nuovaMappa.put(1,"SELECT * FROM ATLETA WHERE NOME_ATLETA=?");
       //Query che deve essere eseguita per seconda
        nuovaMappa.put(2,"INSERT INTO ATLETA VALUES(?)");
        //Query per inserire i partecipanti, per ultima
        nuovaMappa.put(3,"INSERT INTO PARTECIPANTI_EVENTO_SPORTIVO VALUES(?,?)");
        return nuovaMappa;
   }

    @Override public void   inserisciAttributiEventoSpecifico() throws SQLException {
        eseguiEPreparaQueryInserimentoEventoSpecifico();
        }

    @Override public PreparedStatement preparaQueryInserimentoEventoSpecifico() throws  SQLException{
        PreparedStatement queryDaEseguire = preparaQueryDaEseguire("INSERT INTO EVENTO_SPORTIVO VALUES(?,?)");
        queryDaEseguire.setInt(1,getIdEventoInserito());
        queryDaEseguire.setString(2,getEventoDaInserire().getSport().name());
        return queryDaEseguire;
    }
}
