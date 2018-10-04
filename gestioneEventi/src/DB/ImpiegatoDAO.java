package DB;

import Model.Evento;
import Model.Impiegato;
import Model.LuogoEnum;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

public interface ImpiegatoDAO {

    boolean inserisciImpiegato() throws SQLException;
    Collection<Impiegato> cercaImpiegato(String nome, String cognome, LocalDate dataNascita) throws Exception;
    boolean eliminaImpiegato(Impiegato i);
    Impiegato connettiImpiegato(String username, String password) throws Exception;
}
