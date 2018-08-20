package pacchettoDB;

import javafx.scene.control.Alert;

import javax.swing.plaf.nimbus.State;
import java.sql.SQLException;
import java.sql.*;


public class autenticatore {


    /**
     * @return true e' stato trovato l'utente nel DB
     * @param username String inserita come utente
     * @param password  String inseritica come password
     * @throws SQLException in caso di errore con il DB o dati
     * errati
     *
     */
    public boolean autenticaUtente(String username, String password) throws Exception {
        // Effettua la connessione al DB
        if(username==null || password==null || username.equals("") || password.equals("")) return false;
        Connection connessioneDB = pacchettoDB.connessioneDB.getConnessioneDB();

        if (connessioneDB != null) {
            // Preparazione query
            String query = "SELECT  impiegatoID FROM Impiegato WHERE username=? AND " + "password=?";
            PreparedStatement statement = connessioneDB.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            //Esecuzione query
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                connessioneDB.close();
                statement.close();
                resultSet.close();
                return true;
            }
            else {
                connessioneDB.close();
                statement.close();
                resultSet.close();
                return false;

            }

        }
        else throw new SQLException();
    }

}
