package Model;

import javafx.beans.property.ObjectProperty;

import java.util.List;
import java.util.Observable;

public class VisualizzaclientiModel extends Observable {

    private List<Cliente> listaClienti;
    private ObjectProperty<Cliente> clienteSelezionato;

    public void setListaClientiView (List<Cliente> list)
    {
        listaClienti = list;
        setChanged();
        notifyObservers(listaClienti);
    }
    public List<Cliente> getListaClienti(){ return listaClienti; }


}
