package Model;


import javafx.beans.InvalidationListener;
import javafx.scene.chart.*;

import java.util.Observable;

import java.util.*;

public class StatisticheModel extends Observable {

    private Map<String, Integer> mapBiglietti;

    private Map<String,Integer> mapEventiCitta;

    private List<Evento> listEventi;

    private List<Map<String,Integer>> listaMap;

    public Map<String, Integer> getMapBiglietti() {
        return mapBiglietti;
    }

    public void setMapBiglietti(Map<String, Integer> mapBiglietti) {
        this.mapBiglietti = mapBiglietti;
        listaMap.add(0,mapBiglietti);

    }

    public StatisticheModel(){
        mapBiglietti = new HashMap<>();
        mapEventiCitta = new HashMap<>();
        listaMap = new ArrayList<>();
    }

    private BarChart<String,Number> initStat() {

        BarChart<String, Number> barChart ;
        NumberAxis Y = new NumberAxis();
        Y.setLabel("Biglietti Venduti");
        CategoryAxis X = new CategoryAxis();
        X.setLabel("Citta'");
        barChart = new BarChart<String,Number>(X,Y);
        XYChart.Series<String,Number>  serie = new XYChart.Series<>();
        serie.setName("Serie");
        Set<String> set = mapBiglietti.keySet();
        for(String luogo : set) {
            serie.getData().add(new XYChart.Data<String, Number>(luogo, 90));
        }
        barChart.getData().add(serie);
        return barChart;
    }

    public List<Evento> getListEventi() {
        return listEventi;
    }

    public void setListEventi(List<Evento> listEventi) {
        this.listEventi = listEventi;
        setChanged();
        notifyObservers(listEventi);
    }

    public Map<String, Integer> getMapEventiCitta() {
        return mapEventiCitta;
    }

    public void setMapEventiCitta(Map<String, Integer> mapEventiCitta) {
        this.mapEventiCitta = mapEventiCitta;
        listaMap.add(1,mapEventiCitta);
    }

    public void notifyView(){
        setChanged();
        notifyObservers(listaMap);
    }
}
