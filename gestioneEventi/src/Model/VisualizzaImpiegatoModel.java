package Model;

import javafx.beans.property.ObjectProperty;

import java.util.List;
import java.util.Observable;

public class VisualizzaImpiegatoModel extends Observable {

    private List<Impiegato> listaImpiegato;
    private ObjectProperty<Impiegato> impiegatoSelezionato;

    public void setListaEventiView(List<Impiegato> list)
    {
        listaImpiegato = list;
        setChanged();
        notifyObservers(listaImpiegato);
    }
    public List<Impiegato> getListaImpiegato(){ return listaImpiegato; }


}
