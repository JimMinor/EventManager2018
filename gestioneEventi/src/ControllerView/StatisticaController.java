package ControllerView;

import Model.AnnoEnum;
import Model.LuogoEnum;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticaController implements Initializable, Observable {
    //-------Bottoni----------------
    @FXML private JFXButton annualeButton; //Visualizza tutti eventi divisi per anno
    @FXML private JFXButton mensiliButton; //Visualizza tutti gli eventi mese per mese
  //----------- ComboBox--------------
    @FXML private JFXComboBox<LuogoEnum> luogoComboBox; //Enumerazione per la scelta della citta
    @FXML private JFXComboBox<AnnoEnum> annoComboBox; //Enumerazione per la scelta dell'anno
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

    public JFXComboBox<AnnoEnum> getAnnoComboBox() {
        return annoComboBox;
    }

    public LineChart getStatisticheMensili() {
        return statisticheMensili;
    }
    public void initialize(URL url, ResourceBundle rb) {
        luogoComboBox.setItems(FXCollections.observableArrayList(LuogoEnum.values()));
        annoComboBox.setItems(FXCollections.observableArrayList(AnnoEnum.values()));

    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
