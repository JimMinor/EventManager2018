package Scaffale;

import Controller.CambiaView;
import Model.LuogoEnum;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


public class cercaEventoController {
    @FXML
    public Button modificaEventoButton;
    public Button eliminaEventoButton;
    public TableView tabellaCercaEventoTableView;
    public Button cercaCercaEventoButton;
    public TextField nomeCercaEventoTextField;
    public Button annullaCercaEventoButton;
    public DatePicker dataCercaEventoDataPicker;
    public JFXComboBox luogoEventoComboBox;
    private AnchorPane cercaEventoPaneScreen;

    public ComboBox<LuogoEnum> getLuogoEventoComboBox() {
        return luogoEventoComboBox;
    }
    public void initialize() {
        luogoEventoComboBox.setItems(FXCollections.observableArrayList(LuogoEnum.values()));
    }

    public void modificaEventoButtonPressed(ActionEvent actionEvent) {




    }

    public void cercaCercaEventoButtonPressed(ActionEvent actionEvent) {

    }

    public void annullaCercaEventoButtonPressed(ActionEvent actionEvent) {
        nomeCercaEventoTextField.clear();
        luogoEventoComboBox.setValue(null);
        dataCercaEventoDataPicker.setValue(null);

    }

    public void eliminaEventoButtonPressed(ActionEvent actionEvent) {
    }
}

