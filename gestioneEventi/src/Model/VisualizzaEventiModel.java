package Model;

import javafx.beans.InvalidationListener;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class VisualizzaEventiModel extends Observable {

    private List<Evento> listaEventi;
    private ObjectProperty<Evento> eventoSelezionato;

    public void setListaEventiView(List<Evento> list)
    {
        listaEventi = list;
        setChanged();
        notifyObservers(listaEventi);
    }
    public List<Evento> getListaEventi(){ return listaEventi; }


}
