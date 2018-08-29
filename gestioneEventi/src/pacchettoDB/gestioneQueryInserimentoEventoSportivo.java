package pacchettoDB;

import oracle.jdbc.proxy.annotation.Pre;
import pacchettoEntita.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gestioneQueryInserimentoEventoSportivo extends  gestioneQueryInserimentoEvento{

   private eventoSportivo eventoSportivoDaInserire;
   private int idEventoInserito;

   public gestioneQueryInserimentoEventoSportivo(eventoSportivo eventoSportivoDaInserire){
       this.eventoSportivoDaInserire=eventoSportivoDaInserire;
       super.setEventoDaInserire(eventoSportivoDaInserire);

   }

    @Override
    public  void eseguiEPreparaQueryInserimentoEvento() throws SQLException, NullPointerException {
        // Viene inserito l'evento e i suoi attributi comuni a tutti
        super.eseguiEPreparaQueryInserimentoEvento();
        this.idEventoInserito=super.getIdEventoInserito();
        inserisciAttributiEventoSportivo();
        }

    public void inserisciAttributiEventoSportivo() throws SQLException {
        eseguiEpreparaQueryInserimentoAttributiEventoSportivo();
    }

    private void eseguiEpreparaQueryInserimentoAttributiEventoSportivo() throws SQLException {
        PreparedStatement queryEventoSportivo =preparaQueryInserimentoEventoSportivo();
        eseguiUpdate(queryEventoSportivo);// Inserisce ID e SPORT
        eseguiEPreparaQueryInserimentiPartecipantiEventoSportivo();// Inserisce i Partecipanti dell'evento
        utilityDB.closeDB(queryEventoSportivo);

     }


    private void eseguiEPreparaQueryInserimentiPartecipantiEventoSportivo () throws SQLException{

       PreparedStatement queryEventoSportivoPartecipanti=null;
      for(String atleta : eventoSportivoDaInserire.getPartecipanti()){//Per ogni atleta nella lista
          verificaPresenzaAtleta(atleta);
          queryEventoSportivoPartecipanti=preparaQueryDaEseguireInserimentoPartecipantiEventoSportivo(atleta);
          eseguiUpdate(queryEventoSportivoPartecipanti);
       }
        utilityDB.closeDB(queryEventoSportivoPartecipanti);
      }

    private PreparedStatement preparaQueryDaEseguireInserimentoPartecipantiEventoSportivo(String atleta) throws SQLException{
       PreparedStatement queryDaEseguire=preparaQueryDaEseguire("INSERT INTO PARTECIPANTI_EVENTO_SPORTIVO VALUES (?,?)");
       queryDaEseguire.setInt(1,idEventoInserito);
       queryDaEseguire.setString(2,atleta);
       return queryDaEseguire;
    }

    private void verificaPresenzaAtleta(String atleta)throws  SQLException {
       PreparedStatement queryDaEseguire = preparaQueryDaEseguire("SELECT * FROM ATLETA WHERE NOME_ATLETA=?");
       queryDaEseguire.setString(1,atleta);
       ResultSet risultato=eseguiQuery(queryDaEseguire);
       if(!risultato.isBeforeFirst())inserisciAtleta(atleta);//Nessun Risultato
       utilityDB.closeResultSet(risultato);
      }

    private void inserisciAtleta(String atleta) throws SQLException{
       eseguiQuery((preparaQueryDaEseguireInserisciAtleta("INSERT INTO ATLETA VALUES(?)",atleta)));
    }

    private PreparedStatement preparaQueryDaEseguireInserisciAtleta(String query, String atleta) throws SQLException{
       PreparedStatement queryDaEseguire=preparaQueryDaEseguire(query);
       queryDaEseguire.setString(1,atleta);
       return queryDaEseguire;
       }


    private PreparedStatement preparaQueryInserimentoEventoSportivo() throws  SQLException{
        PreparedStatement queryDaEseguire = preparaQueryDaEseguire("INSERT INTO EVENTO_SPORTIVO VALUES(?,?)");
        queryDaEseguire.setInt(1,idEventoInserito);
        queryDaEseguire.setString(2,eventoSportivoDaInserire.getSport().name());
        return queryDaEseguire;
    }


    private ResultSet eseguiQuery(PreparedStatement queryDaEseguire)throws SQLException{ return queryDaEseguire.executeQuery(); }
    private int eseguiUpdate(PreparedStatement queryDaEseguire)throws SQLException{return queryDaEseguire.executeUpdate();}
    public PreparedStatement preparaQueryDaEseguire(String query)throws SQLException{
        Connection connection=utilityDB.getConnessioneDB();
        PreparedStatement queryDaEseguire = connection.prepareCall(query);
        return queryDaEseguire;
    }

}
