package DB;

import Model.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteDAOImp implements ClientiDAO {

    private GestoreQueryCerca gestoreQueryCerca;

    public ClienteDAOImp() {
        gestoreQueryCerca = new GestoreQueryCerca();
    }


    @Override
    public List<Cliente> cercaCliente(String username) {

        List<Cliente> list = null;
        try {
            list = gestoreQueryCerca.eseguiQueryRicercaClienti(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public boolean eliminaCliente() throws SQLException {
        return false;
    }
}
