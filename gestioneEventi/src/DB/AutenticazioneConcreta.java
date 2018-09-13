package DB;

import java.sql.SQLException;
import java.sql.*;


public class AutenticazioneConcreta implements Autenticazione {

    @Override
    /**
     * @return true e' stato trovato l'utente nel DB
     * @param username String inserita come utente
     * @param password  String inseritica come password
     * @throws SQLException in caso di errore con il DB o dati
     * errati
     *     */
    public  boolean autenticaUtente(String username, String password) throws Exception {
        boolean ris=false;
        // Effettua la connessione al DB se almeno un campo non e' vuoto
        if(username==null || password==null || username.equals("") || password.equals("")) return false;
        Connection connection = UtilityDB.getConnessioneDB();
            // Preparazione query
            PreparedStatement preparedStatement=preparaQuery(username,password,connection);
            //Esecuzione query
             ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())ris=true;
            UtilityDB.closeDB(preparedStatement);
            return ris;
    }
    public PreparedStatement preparaQuery(String username, String password,Connection connection) throws SQLException{

        // Preparazione query
        String query = "SELECT ID FROM Impiegato WHERE username=? AND " + "password=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        return statement;
    }
}
