package DB;

import Model.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//TODO: Gestire meglio gli errori
public class CreaQueryInserimentoEventoSportivo extends CreaQueryInserimentoEvento {

   private EventoSportivo eventoSportivoDaInserire;


   public CreaQueryInserimentoEventoSportivo(EventoSportivo eventoSportivoDaInserire){
       this.eventoSportivoDaInserire=eventoSportivoDaInserire;
       setEventoDaInserire(eventoSportivoDaInserire);

   }

    @Override
    public  void eseguiEPreparaQueryInserimentoEvento() throws SQLException, NullPointerException {
        // Viene inserito l'evento e i suoi attributi comuni a tutti
        super.eseguiEPreparaQueryInserimentoEvento();
        // Vengono inseriti i partecipanti dell'evento sportivo
        inserisciAttributiEventoSportivo();
        }

    public void inserisciAttributiEventoSportivo() throws SQLException {
        eseguiEpreparaQueryInserimentoAttributiEventoSportivo();
    }

    private void eseguiEpreparaQueryInserimentoAttributiEventoSportivo() throws SQLException {
        PreparedStatement queryEventoSportivo =preparaQueryInserimentoEventoSportivo();
        eseguiUpdate(queryEventoSportivo);// Inserisce ID e SPORT
        inserisciPartecipantiEvento(creaMapQueryEventoSportivo(),eventoSportivoDaInserire.getPartecipanti());// Inserisce i Partecipanti dell'evento
        UtilityDB.closeDB(queryEventoSportivo);

     }

    private Map<Integer,String> creaMapQueryEventoSportivo() {
       Map<Integer,String> nuovaMappa= new HashMap<Integer,String>();
       //Query che deve essere eseguita per prima
       nuovaMappa.put(1,"SELECT * FROM ATLETA WHERE NOME_ATLETA=?");
       //Query che deve essere eseguita per seconda
        nuovaMappa.put(2,"INSERT INTO ATLETA VALUES(?,?)");
        //Query per inserire i partecipanti, per ultima
        nuovaMappa.put(3,"INSERT INTO PARTECIPANTI_EVENTO_SPORTIVO VALUES(?,?");
        return nuovaMappa;
   }


    private PreparedStatement preparaQueryInserimentoEventoSportivo() throws  SQLException{
        PreparedStatement queryDaEseguire = preparaQueryDaEseguire("INSERT INTO EVENTO_SPORTIVO VALUES(?,?)");
        queryDaEseguire.setInt(1,getIdEventoInserito());
        queryDaEseguire.setString(2,eventoSportivoDaInserire.getSport());
        return queryDaEseguire;
    }



}
