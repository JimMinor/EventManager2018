package pacchettoViste;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class cercaEventoController {
    @FXML
    public Button modificaEventoButton;
    @FXML
    public Button eliminaEventoButton;
    @FXML
    public TableView tabellaCercaEventoTableView;
    @FXML
    public Button cercaCercaEventoButton;
    @FXML
    public TextField nomeCercaEventoTextField;
    @FXML
    public TextField luogoCercaEventoTextField;

    @FXML
    public Button annullaCercaEventoButton;
    @FXML
    public DatePicker dataCercaEventoDataPicker;
    @FXML
    private AnchorPane cercaEventoPaneScreen;


    public void modificaEventoButtonPressed(ActionEvent actionEvent) {
        new modificaPane().mostraPaneEvento(cercaEventoPaneScreen, "inserisciEventoPane.fxml");



    }

    public void cercaCercaEventoButtonPressed(ActionEvent actionEvent) {

    }

    public void annullaCercaEventoButtonPressed(ActionEvent actionEvent) {
        nomeCercaEventoTextField.clear();
        luogoCercaEventoTextField.clear();
        dataCercaEventoDataPicker.setValue(null);

    }

    public void eliminaEventoButtonPressed(ActionEvent actionEvent) {
    }
}

