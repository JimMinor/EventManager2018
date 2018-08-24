package pacchettoDB;


import pacchettoEntita.Evento;
import pacchettoEntita.eventoMusicale;
import pacchettoEntita.eventoSportivo;
import java.sql.*;
import java.sql.Date;

public class eventoDB implements  eventoDAO {


    public eventoDB(){}
    @Override
    public boolean eliminaEvento(Evento e) {
        return false;
    }
    @Override
    /****************************************
     *  Inserimento Eventi                  *
     ****************************************
     */

    public boolean inserisciEvento(Evento e) {
        if(e==null) return false;
        try{if(!inserisciEventoGenerico(e))throw new SQLException();}catch(SQLException sqlE){
            // mostraAlert.mostraErroreInserimento.
            sqlE.printStackTrace();
            }
         return false;
    }
    public boolean inserisciEventoGenerico(Evento e) throws SQLException{
        if(e==null)return false;
        String query ="INSERT INTO EVENTO VALUES(?,?,?,?,?,?,?)";
        //Inserisco l'evento generico
        Connection connection=utilityDB.getConnessioneDB();
        if(setQueryInserisciEventoGenerico(connection.prepareStatement(query),e,connection)) return inserisciEventoSpecifico(e);
        return false;
        }
    public boolean inserisciEventoSpecifico(Evento e) throws SQLException{
        if(e==null)return false;
        if(e instanceof eventoMusicale) return inserisciEventoMusicale((eventoMusicale)e);
        if(e instanceof  eventoSportivo)return inserisciEventoSportivo((eventoSportivo)e);
        return false;
    }
    public boolean inserisciEventoSportivo(eventoSportivo e) throws SQLException{
        if(e==null) return false;
        String query = "INSERT INTO EVENTO_SPORTIVO VALUES (?,?,?,?)";
        Connection connection=utilityDB.getConnessioneDB();

        return setQueryInserisciEventoSportivo(connection.prepareStatement(query),e,connection);

    }
    public boolean inserisciEventoMusicale(eventoMusicale e) throws SQLException{
        if(e==null) return false;

        String query = "INSERT INTO EVENTO_MUSICALE VALUES(?,?)";
        Connection connection=utilityDB.getConnessioneDB();
        return setQueryInserisciEventoMusicale(connection.prepareStatement(query),e,connection);

    }

    /****************************************
     *  Set PreparedStament per le Query     *
     ****************************************
     */
    public PreparedStatement setPreparedStatementQuery(String query,Connection connection)throws SQLException{
        return connection.prepareStatement(query);
    }


    /*******************************************
     *  Set  valori per le Query di inserimento
     ******************************************
     */

    public boolean setQueryInserisciEventoGenerico(PreparedStatement preparedStatement, Evento e,Connection connection) throws SQLException{
        preparedStatement.setInt(1,0);
        preparedStatement.setDate(4 ,Date.valueOf(e.getDataEvento()));
        preparedStatement.setString(6,e.getDescrizione());
        preparedStatement.setString(3, e.getLuogoEvento().toString());
        preparedStatement.setString(2,e.getNome());
        preparedStatement.setFloat(5,e.getPrezzoBiglietto());
        preparedStatement.setString(7,e.getTipologiaEvento().name());
        if(eseguiQuery(preparedStatement,connection)>0)return true;
        return false;
    }
    public boolean setQueryInserisciEventoSportivo(PreparedStatement preparedStatement, eventoSportivo e,Connection connection) throws SQLException{
        preparedStatement.setInt(1,0);
        preparedStatement.setString(2,e.getPartecipanti().get(0));
        preparedStatement.setString(3,e.getPartecipanti().get(1));
        preparedStatement.setString(4,e.getSport().name());
        if(eseguiQuery(preparedStatement,connection)>0)return true;
        return false;
    }
    public boolean setQueryInserisciEventoMusicale(PreparedStatement preparedStatement, eventoMusicale e,Connection connection)throws  SQLException{
        //SETUP QUERY
        preparedStatement.setInt(1,0);
        preparedStatement.setString(2,e.getArtisti());//TODO: cambiare table Evento_Musicale?
        if(eseguiQuery(preparedStatement,connection)>0)return true;
        return false;
    }

    public int eseguiQuery(PreparedStatement preparedStatement,Connection connection)throws SQLException{
         int ris=preparedStatement.executeUpdate();
         utilityDB.closeDB(preparedStatement,connection);
         return ris;
     }






}
