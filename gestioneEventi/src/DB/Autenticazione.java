package DB;

import Model.Impiegato;

public interface Autenticazione {

    Impiegato autenticaUtente(String username, String password) throws Exception;
}
