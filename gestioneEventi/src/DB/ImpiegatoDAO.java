package DB;

import Model.Evento;
import Model.Impiegato;
import Model.LuogoEnum;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

public interface ImpiegatoDAO {

    public boolean inserisciImpiegato() throws SQLException;
    public Collection<Impiegato> cercaImpiegato(String nome, String cognome, LocalDate dataNascita) throws Exception;
    public boolean eliminaImpiegato(Impiegato i);
}
