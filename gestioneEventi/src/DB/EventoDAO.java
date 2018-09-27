package DB;


import Model.Evento;
import Model.LuogoEnum;

import java.time.LocalDate;
import java.util.Collection;

public interface EventoDAO {

    public void inserisciEvento() throws Exception;
    public Collection<Evento> cercaEvento(String nomeEvento, LocalDate dataEvento, LuogoEnum luogoEvento) throws Exception;
    public boolean eliminaEvento() throws Exception;
}
