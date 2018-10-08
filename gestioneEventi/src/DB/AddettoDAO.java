package DB;

import Model.Evento;
import Model.Addetto;
import Model.LuogoEnum;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface AddettoDAO {

    public boolean inserisciAddetto() throws SQLException;
    public List<Addetto> cercaAddetto(String nome, String cognome, LocalDate dataNascita) throws SQLException;
    public void eliminaAddetto(Addetto addetto) throws SQLException;

}
