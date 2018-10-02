package DB;


import Model.Cliente;
import Model.Evento;
import Model.LuogoEnum;

import java.time.LocalDate;
import java.util.Collection;

public interface ClientiDAO {


    public Collection<Cliente> cercaCliente(String username) throws Exception;
    public void eliminaCliente(Cliente cù) throws Exception;
}
