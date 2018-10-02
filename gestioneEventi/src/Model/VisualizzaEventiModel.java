package Model;

import javafx.beans.InvalidationListener;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class VisualizzaEventiModel extends Observable {

    private volatile List<Evento> listaEventi = new ArrayList<>();
    private volatile Evento eventoSelezionato = new Evento();

    public void setListaEventiView(List<Evento> list)
    {
        listaEventi = list;
        setChanged();
        notifyObservers(listaEventi);
    }
    public List<Evento> getListaEventi(){ return listaEventi; }


    public synchronized Evento getEventoSelezionato() {
        return eventoSelezionato;
    }

    public synchronized void setEventoSelezionato(Evento evento) {
        eventoSelezionato = evento;
    }
}
