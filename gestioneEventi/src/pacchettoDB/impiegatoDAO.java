package pacchettoDB;

import pacchettoEntita.Impiegato;

public interface impiegatoDAO {

    public boolean inserisciImpiegatoBackOffice(Impiegato i);
    public boolean eliminaImpiegatoBackOffice(Impiegato i);
}
