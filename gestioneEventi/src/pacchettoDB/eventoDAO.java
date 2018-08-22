package pacchettoDB;

import pacchettoEntita.Evento;

public interface eventoDAO {

    public boolean inserisciEvento(Evento e);
    public boolean eliminaEvento(Evento e);
}
