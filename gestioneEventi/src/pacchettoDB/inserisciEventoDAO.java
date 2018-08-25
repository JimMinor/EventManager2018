package pacchettoDB;

import pacchettoEntita.Evento;
@FunctionalInterface
public interface inserisciEventoDAO {

    public boolean inserisciEvento(Evento e);

}
