package pacchettoDB;


import pacchettoEntita.Evento;
import pacchettoEntita.eventoMusicale;
import pacchettoEntita.eventoSportivo;
import java.sql.*;
import java.sql.Date;

public class eventoDB implements  eventoDAO {


    Connection connection;
    public eventoDB(){}
    public Connection setConnection(){return  this.connection=utilityDB.getConnessioneDB();}
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
        try{
            setCallInserisciEvento(setConnection(),e );}catch(SQLException sqlE){
            // mostraAlert.mostraErroreInserimento.
            sqlE.printStackTrace();
            }
         return false;
    }

    private void setCallInserisciEvento(Connection connection,Evento e) throws  SQLException{
        CallableStatement callableStatement=connection.prepareCall("{?=CALL ins_evento(?,?,?,?,?,?,?)}");
        setParametriCallInserisciEvento(connection,callableStatement,e);


    }


    public boolean inserisciEventoSpecifico(Evento e,int id) throws SQLException{
        if(e==null)return false;
        if(e instanceof eventoMusicale) return inserisciEventoMusicale((eventoMusicale)e,id);
        if(e instanceof  eventoSportivo)return inserisciEventoSportivo((eventoSportivo)e,id);
        return false;
    }
    public boolean inserisciEventoSportivo(eventoSportivo e,int id) throws SQLException{
        if(e==null) return false;
        return setQueryInserisciEventoSportivo(connection.prepareStatement("INSERT INTO EVENTO_SPORTIVO VALUES (?,?,?,?)"),e,id);

    }
    public boolean inserisciEventoMusicale(eventoMusicale e,int id) throws SQLException{
        if(e==null) return false;
        return setQueryInserisciEventoMusicale(connection.prepareStatement("INSERT INTO EVENTO_MUSICALE VALUES(?,?)"),e,id);

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
     *******************************************
     */

    private void setParametriCallInserisciEvento(Connection connection, CallableStatement callableStatement,Evento e) throws SQLException{

        callableStatement.registerOutParameter(1,Types.INTEGER);
        callableStatement.setInt(2,0);
        callableStatement.setString(3,e.getNome().toUpperCase());
        callableStatement.setString(4,e.getLuogoEvento().name());//Gia' UppCase
        callableStatement.setDate(5,Date.valueOf(e.getDataEvento()));//Converto LocalDate in Date.sql
        callableStatement.setFloat(6,e.getPrezzoBiglietto());
        callableStatement.setString(7,e.getDescrizione().toUpperCase());
        callableStatement.setString(8,e.getTipologiaEvento().name());//Gia' UppCase
        inserisciEventoSpecifico(e,eseguiCallInserisciEventoGenerico(callableStatement));//Esegue e ritorna l'id dell'evento
    }


    public boolean setQueryInserisciEventoSportivo(PreparedStatement preparedStatement, eventoSportivo e,int id) throws SQLException{

        preparedStatement.setInt(1,id);
        preparedStatement.setString(4,e.getSport().name());
        if(eseguiQueryInserimentoEventoSpecifico(preparedStatement)>0)return true;
        return false;
    }
    public boolean setQueryInserisciEventoMusicale(PreparedStatement preparedStatement, eventoMusicale e,int id)throws  SQLException{
        //SETUP QUERY
        preparedStatement.setInt(1,id);

        if(eseguiQueryInserimentoEventoSpecifico(preparedStatement)>0)return true;
        return false;
    }

    /*******************************************
     *  Esecuzione sql Query
     *******************************************
     */
    public int eseguiQueryInserimentoEventoSpecifico(PreparedStatement preparedStatement)throws SQLException{
         int ris=preparedStatement.executeUpdate();
         utilityDB.closePreparedStaement(preparedStatement);
         return ris;
     }
    public int eseguiCallInserisciEventoGenerico(CallableStatement callableStatement)throws SQLException{
         callableStatement.executeUpdate();
         return callableStatement.getInt(1);
        }





}
