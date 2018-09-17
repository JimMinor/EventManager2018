package DB;


import java.sql.*;

/**
 * UtilityDB:
 * L'intento di questa classe e' stabilire una connessione con il DB Relazionale Oracle 11g
 *
 * E fornire metodi per la chiusura della connessiona una volta concluse le operazioni
 *
 */
public class UtilityDB {


    public static Connection getConnessioneDB(){

        Connection connessione = null;
        try{
            try {
                // Ricerca Driver
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException E) {
                E.printStackTrace();
                return connessione;
            }
            // Creazione Connessione
            return connessione = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","admin");
            }
            catch(SQLException E){
            //MostraAlert.mostraAlertErroreDB();
            return connessione;

        }

    }
    public static void closeConnection(Connection c){
        try{
            c.close();

        }catch(SQLException e) {//Ignore
        }
    }
    public static void closePreparedStaement(PreparedStatement preparedStatement) {
        try{
            preparedStatement.close();
        }catch(SQLException e) {//Ignore
        }
    }
    public static void closeCallableStatement(CallableStatement callableStatement){
        try{
            callableStatement.close();
            callableStatement.getConnection().close();
        }catch(SQLException e) {//Ignore
        }
    }

    public static void closeDB(PreparedStatement preparedStatement) {
        try{
            preparedStatement.close();
            preparedStatement.getConnection().close();
        }
        catch(SQLException sqlE){
            //Ignore
        }
    }

    public static void closeResultSet(ResultSet resultSetDaChiudere) {
        try {
            resultSetDaChiudere.close();
            } catch (SQLException sqlE) {//ignore
        }
    }
}
