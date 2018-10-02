package View;

import Model.LuogoEnum;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class StatisticaController implements Observer {
    //-------Bottoni----------------
    @FXML private JFXButton annualeButton; //Visualizza tutti eventi divisi per anno
    @FXML private JFXButton mensiliButton; //Visualizza tutti gli eventi mese per mese
  //----------- ComboBox--------------
    @FXML private JFXComboBox<LuogoEnum> luogoComboBox; //Enumerazione per la scelta della citta
    @FXML private JFXComboBox<?> annoComboBox; //Enumerazione per la scelta dell'anno
    //----------Grafico---------------
    @FXML private LineChart statisticheMensili; //Grafico per visualizzare le statistiche mensili


    public JFXButton getAnnualeButton() {
        return annualeButton;
    }

    public JFXButton getMensiliButton() {
        return mensiliButton;
    }

    public JFXComboBox<LuogoEnum> getLuogoComboBox() {
        return luogoComboBox;
    }

    public JFXComboBox<?> getAnnoComboBox() {
        return annoComboBox;
    }

    public LineChart getStatisticheMensili() {
        return statisticheMensili;
    }

    public void initialize(URL url, ResourceBundle rb) {
        luogoComboBox.setItems(FXCollections.observableArrayList(LuogoEnum.values()));
        //annoComboBox.setItems(FXCollections.observableArrayList(AnnoEnum.values()));

    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
