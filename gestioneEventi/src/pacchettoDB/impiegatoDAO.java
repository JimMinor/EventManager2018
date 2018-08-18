package pacchettoDB;

import java.sql.SQLException;

public interface impiegatoDAO {

    public boolean trovaImpiegato(String username,String password) throws Exception;

}
