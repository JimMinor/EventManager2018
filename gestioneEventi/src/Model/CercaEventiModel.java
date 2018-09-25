package Model;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CercaEventiModel {

    private ObservableList<Evento> listaEventi;
    private ObjectProperty<Evento> eventoSelezionato;

    public void setListaEventiView(ObservableList<Evento> list){}
    public ObservableList<Evento> getListaEventi(){ return listaEventi; }


}
