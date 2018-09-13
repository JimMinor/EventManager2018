package DB;

import Model.Impiegato;

public interface ImpiegatoDAO {

    public boolean inserisciImpiegatoBackOffice(Impiegato i);
    public boolean eliminaImpiegatoBackOffice(Impiegato i);
}
