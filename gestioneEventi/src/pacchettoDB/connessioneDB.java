package pacchettoDB;


import java.sql.*;

/**
 * connessioneDB:
 * L'intento di questa classe e' stabile una connessione con il DB.
 *
 */
public class connessioneDB {

    public static void connettiDB(){

        try{
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return;
            }
            Connection connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/TciketDB","Giammarco","troll");

            Statement statement = connessione.createStatement();


        }
        catch(Exception E){System.out.println(E);
        }

    }
}
