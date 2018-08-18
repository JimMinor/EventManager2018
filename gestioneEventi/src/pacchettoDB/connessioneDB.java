package pacchettoDB;


import java.sql.*;

/**
 * connessioneDB:
 * L'intento di questa classe e' stabilire una connessione con il DB Relazionale Oracle 11g
 *
 */
public class connessioneDB {


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
            connessione = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Giammarco","troll");
            }
            catch(SQLException E){
            E.printStackTrace();
            return connessione;

        }

     return connessione;
    }
}
