package Model;

import javafx.beans.property.ObjectProperty;

import java.util.List;
import java.util.Observable;

public class VisualizzaAddettiModel extends Observable {

    private List<Addetto> listaAddetti;



    private Addetto addettoSelezionato;

    public void setListaAddettiView(List<Addetto> list)
    {
        listaAddetti = list;
        System.out.println(listaAddetti);
        setChanged();
        notifyObservers(listaAddetti);

    }
    public List<Addetto> getListaAddetti(){ return listaAddetti; }

    public Addetto getAddettoSelezionato() {
        return addettoSelezionato;
    }

    public void setAddettoSelezionato(Addetto addettoSelezionato) {
        this.addettoSelezionato = addettoSelezionato;
    }
}
