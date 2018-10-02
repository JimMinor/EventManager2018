package DB;


import Model.Evento;
import Model.LuogoEnum;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

public interface EventoDAO {

    public void inserisciEvento(Evento evento) throws Exception;
    public Collection<Evento> cercaEvento(String nomeEvento, LocalDate dataEvento, LuogoEnum luogoEvento) throws Exception;
    public void eliminaEvento(Evento evento) throws Exception;
    public void modificaEvento(int eventoID, LocalDate data, LuogoEnum luogo) throws SQLException;
}
