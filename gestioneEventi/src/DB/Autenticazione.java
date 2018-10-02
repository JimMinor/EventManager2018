package DB;

import Model.Impiegato;

public interface Autenticazione {

    public Impiegato autenticaUtente(String username, String password) throws Exception;
}
