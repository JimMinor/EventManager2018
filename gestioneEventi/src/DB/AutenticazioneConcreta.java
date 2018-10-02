package DB;

import Model.Impiegato;

import java.sql.SQLException;
import java.sql.*;


public class AutenticazioneConcreta implements Autenticazione {

    private ImpiegatoDAO impiegatoDAO = new ImpiegatoDAOImp();

    @Override
    /**
     * @return true e' stato trovato l'utente nel DB
     * @param username String inserita come utente
     * @param password  String inseritica come password
     * @throws SQLException in caso di errore con il DB o dati
     * errati
     *     */
    public Impiegato autenticaUtente(String username, String password) throws Exception {
        boolean ris=false;
        // Effettua la query al DB se almeno un campo non e' vuoto
        if(username==null || password==null || username.equals("") || password.equals("")) throw new Exception();

        return impiegatoDAO.connettiImpiegato(username,password);
    }

}
