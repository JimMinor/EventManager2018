package DB;

import Model.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteDAOImp implements ClientiDAO {
    private Cliente clienteSelezionato;
    private GestoreQueryCerca gestoreQueryCerca;
    private GestoreQueryModificaElimina gestoreQueryModificaElimina;

    public ClienteDAOImp() {
        gestoreQueryCerca = new GestoreQueryCerca();
        gestoreQueryModificaElimina=new GestoreQueryModificaElimina();
    }
    public ClienteDAOImp(Cliente clienteSelezionato){
        this.clienteSelezionato=clienteSelezionato;
        gestoreQueryCerca=new GestoreQueryCerca();
        gestoreQueryModificaElimina=new GestoreQueryModificaElimina();
    }


    @Override
    public List<Cliente> cercaCliente(String username) throws SQLException {
             return gestoreQueryCerca.eseguiQueryRicercaClienti(username);
    }
    public List<Cliente> cercaCliente() throws SQLException{
        return gestoreQueryCerca.eseguiQueryRicercaClienti();
    }

   @Override public void eliminaCliente(Cliente clienteDaEliminare) throws SQLException {
         gestoreQueryModificaElimina.eseguiQueryEliminaCliente(clienteDaEliminare);
    }
}
