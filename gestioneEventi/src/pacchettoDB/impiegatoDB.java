package pacchettoDB;

import javafx.scene.control.Alert;

import javax.swing.plaf.nimbus.State;
import java.sql.SQLException;
import java.sql.*;


public class impiegatoDB implements  impiegatoDAO{


    @Override
    /**
     * @return true e' stato trovato l'utente nel DB
     * @param username String inserita come utente
     * @param passwordS  String inseritica come password
     * @throw SQLException in caso di errore con il DB o dati
     * errati
     *
     */
    public boolean trovaImpiegato(String username,String password) throws SQLException {
        // Effettua la connessione al DB
        Connection connessioneDB = pacchettoDB.connessioneDB.getConnessioneDB();

        if (connessioneDB != null) {
            // Preparazione query
            String query = "SELECT  impiegatoID FROM Impiegato WHERE username=? AND " + "password=?";
            PreparedStatement statement = connessioneDB.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            //Esecuzione
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) return true;

        }
         throw new SQLException();
    }

}
