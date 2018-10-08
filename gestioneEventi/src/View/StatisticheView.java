package View;
import Model.StatisticheModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;

import java.util.*;

public class StatisticheView implements Observer {


    @FXML private JFXTextField nomePartecipanteTextField;
    @FXML private BarChart<String, Number> barChart;
    @FXML private PieChart pieChart;
    @FXML private CategoryAxis cittaX;
    @FXML private NumberAxis bigliettiY;
    @FXML private JFXButton cercaButton;
    private StatisticheModel statisticheModel;

    public void initialize(){}

    public StatisticheView(StatisticheModel statisticheModel) {
        this.statisticheModel = statisticheModel;
        statisticheModel.addObserver(this);
    }


    public JFXTextField getNomePartecipanteTextField() {
        return nomePartecipanteTextField;
    }

    public BarChart<String, Number> getBarChart() {
        return barChart;
    }

    public CategoryAxis getCittaX() {
        return cittaX;
    }

    public NumberAxis getBigliettiY() {
        return bigliettiY;
    }

    public JFXButton getCercaButton() {
        return cercaButton;
    }

    public void setBarChart(BarChart<String, Number> barChart) {
        this.barChart = barChart;
    }

    public PieChart getPieChart() {
        return pieChart;
    }

    @Override
    public void update(Observable o, Object arg) {

        List<Map<String,Integer>> listMap = (List<Map<String,Integer>>) arg;
        Map<String,Integer> mapBiglietti = listMap.get(0);
        Map<String,Integer> mapEventi = listMap.get(1);
        // BAR CHART
        bigliettiY.setLabel("Biglietti Venduti");
        cittaX.setLabel("Citta'");
        XYChart.Series<String,Number>  serie = new XYChart.Series<>();
        serie.setName(nomePartecipanteTextField.getText());
        Set<String> set = mapBiglietti.keySet();
        for(String luogo : set) {
            serie.getData().add(new XYChart.Data<String, Number>(luogo, mapBiglietti.get(luogo)));
        }
        barChart.getData().add(serie);
        // PIE CHART
        List<PieChart.Data> listDate = new ArrayList<>();
        Set<String> setCitta = mapEventi.keySet();
        for(String citta : setCitta )
            listDate.add(new PieChart.Data(citta,mapEventi.get(citta)));

        ObservableList<PieChart.Data> dataPieChart = FXCollections.observableArrayList(listDate);
        pieChart.setData(dataPieChart);
    }


}
