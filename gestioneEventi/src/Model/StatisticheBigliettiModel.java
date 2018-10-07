package Model;


import javafx.beans.InvalidationListener;
import javafx.scene.chart.*;

import java.util.Observable;

import java.util.*;

public class StatisticheBigliettiModel extends Observable {

    private Map<String, Integer> mapBiglietti;

    public Map<String, Integer> getMapBiglietti() {
        return mapBiglietti;
    }

    public void setMapBiglietti(Map<String, Integer> mapBiglietti) {
        this.mapBiglietti = mapBiglietti;
        BarChart<String,Number> barChart = initStat();
        setChanged();
        notifyObservers(mapBiglietti);
    }

    public StatisticheBigliettiModel(){
        mapBiglietti = new HashMap<>();
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

}
