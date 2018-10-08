package DB;

import Model.Addetto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;


public class AddettoDAOImp implements AddettoDAO {

    private Addetto addettoDaInserire;
    private char mansioneDaInserire;
    private GestoreQueryCerca gestoreQueryCerca;
    private GestoreQueryModificaElimina gestoreQueryModificaElimina;

    public AddettoDAOImp(){
        gestoreQueryCerca = new GestoreQueryCerca();
        gestoreQueryModificaElimina = new GestoreQueryModificaElimina();
    }

    public AddettoDAOImp(Addetto addettoDaInserire) {
        this.addettoDaInserire = addettoDaInserire;
    }

    @Override public boolean inserisciAddetto() throws SQLException {

        Connection connection = UtilityDB.getConnessioneDB();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO ADMIN.PERSONA (CODICE_FISCALE,NOME,COGNOME,DATA_NASCITA)" +
                " VALUES ('" + addettoDaInserire.getCF() + "'," +
                "'" + addettoDaInserire.getNome() + "'," +
                "'" + addettoDaInserire.getCognome() + "'," +
                "TO_DATE('" + addettoDaInserire.getDataNascita() + "','YYYY-MM-DD'))");
        statement.executeUpdate("INSERT INTO ADMIN.ADDETTO (ID,CODICE_FISCALE,DATA_ASSUNZIONE,STIPENDIO,EMAIL,TELEFONO,IBAN)" +
                " VALUES ('" + addettoDaInserire.getId() + "'," +
                "'" + addettoDaInserire.getCF() + "'," +
                "TO_DATE('" + addettoDaInserire.getDataAssunzione() + "','YYYY-MM-DD')," +
                "'" + addettoDaInserire.getStipendio().toString().replace('.',',') + "'," +
                "'" + addettoDaInserire.getEmail() + "'," +
                "'" + addettoDaInserire.getTelefono() + "'," +
                "'" + addettoDaInserire.getIban() + "'" + ")");
        connection.close();
        return true;
    }

    @Override public List<Addetto> cercaAddetto(String nome, String cognome, LocalDate dataNascita) throws SQLException {
        return gestoreQueryCerca.eseguiQueryRicercaAddetto(nome,cognome,dataNascita);
    }

    @Override public void eliminaAddetto(Addetto addettoDaEliminare) throws SQLException{
        gestoreQueryModificaElimina.eseguiQueryEliminaAddetto(addettoDaEliminare);
    }
}
