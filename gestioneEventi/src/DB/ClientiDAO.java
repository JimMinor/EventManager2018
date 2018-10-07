package DB;


import Model.Cliente;
import Model.Evento;
import Model.LuogoEnum;

import java.time.LocalDate;
import java.util.Collection;

public interface ClientiDAO {


    Collection<Cliente> cercaCliente(String username) throws Exception;
    void eliminaCliente(Cliente c) throws Exception;
}
