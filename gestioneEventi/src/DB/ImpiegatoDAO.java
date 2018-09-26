package DB;

import Model.Impiegato;

public interface ImpiegatoDAO {

    public boolean inserisciImpiegato(Impiegato i);
    public boolean eliminaImpiegato(Impiegato i);
}
