package DB;


import Model.Evento;
import Model.LuogoEnum;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

public interface EventoDAO {

    void inserisciEvento(Evento evento) throws Exception;
    Collection<Evento> cercaEvento(String nomeEvento, LocalDate dataEvento, LuogoEnum luogoEvento) throws Exception;
    void eliminaEvento(Evento evento) throws Exception;
    void modificaEvento(int eventoID, LocalDate data, LuogoEnum luogo) throws SQLException;
}
