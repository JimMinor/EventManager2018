package DB;

public interface Autenticazione {

    public boolean autenticaUtente(String username, String password) throws Exception;
}
