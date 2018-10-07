package View;
import Model.LuogoEnum;
import Model.StatisticheBigliettiModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.sun.javafx.collections.MappingChange;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class StatisticheBigliettiView implements Observer {


    @FXML private JFXTextField nomePartecipanteTextField;
    @FXML private BarChart<String, Number> barChart;
    @FXML private CategoryAxis cittaX;
    @FXML private NumberAxis bigliettiY;
    @FXML private JFXButton cercaButton;
    private StatisticheBigliettiModel statisticheBigliettiModel;

    public void initialize(){}

    public StatisticheBigliettiView(StatisticheBigliettiModel statisticheBigliettiModel) {
        this.statisticheBigliettiModel = statisticheBigliettiModel;
        statisticheBigliettiModel.addObserver(this);
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

    @Override
    public void update(Observable o, Object arg) {
        Map<String,Integer> map = (Map)arg;
        bigliettiY.setLabel("Biglietti Venduti");
        cittaX.setLabel("Citta'");
        XYChart.Series<String,Number>  serie = new XYChart.Series<>();
        serie.setName(nomePartecipanteTextField.getText());
        Set<String> set = map.keySet();
        for(String luogo : set) {
            serie.getData().add(new XYChart.Data<String, Number>(luogo, map.get(luogo)));
        }
        barChart.getData().add(serie);
    }
}
