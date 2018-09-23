package DB;


import Model.Evento;

import java.util.Collection;

public interface EventoDAO {

    public void inserisciEvento() throws Exception;
    public Collection<Evento> cercaEvento() throws Exception;


}
