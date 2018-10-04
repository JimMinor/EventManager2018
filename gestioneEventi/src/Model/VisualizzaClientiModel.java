package Model;

import javafx.beans.property.ObjectProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class VisualizzaClientiModel extends Observable {

    private volatile List<Cliente> listaClienti = new ArrayList<>();
    private volatile Cliente clienteSelezionato = new Cliente();

    public void setListaClientiView (List<Cliente> list)
    {
        listaClienti = list;
        setChanged();
        notifyObservers(listaClienti);
    }
    public List<Cliente> getListaClienti(){ return listaClienti; }

    public synchronized Cliente getClienteSelezionato() {
        return clienteSelezionato;
    }

    public synchronized  void setClienteSelezionato(Cliente clienteSelezionato) {
        this.clienteSelezionato = clienteSelezionato;
    }
}
