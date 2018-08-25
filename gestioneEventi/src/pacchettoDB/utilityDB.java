package pacchettoDB;


import pacchettoViste.mostraAlert;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * utilityDB:
 * L'intento di questa classe e' stabilire una connessione con il DB Relazionale Oracle 11g
 *
 */
public class utilityDB {


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
            connessione = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","admin");
            }
            catch(SQLException E){
            mostraAlert.mostraAlertErroreDB();
            return connessione;

        }

     return connessione;
    }
    public static void closeDB(ResultSet rs,PreparedStatement ps,Connection c){
        try { rs.close();ps.close();c.close();} catch(SQLException e){
            //ignora
        }
    }
    public static void closeDB(PreparedStatement ps,Connection c){
        try{ps.close();c.close();}catch(SQLException e) {//ignora
        }
    }

}
