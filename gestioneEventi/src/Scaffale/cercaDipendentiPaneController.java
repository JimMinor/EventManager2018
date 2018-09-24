package Scaffale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class cercaDipendentiPaneController {
    @FXML
    public AnchorPane cercaDipendentiScreenAnchorPane;
   @FXML
    public Button modificaDipendenteButton;
   @FXML
   public Button eliminaDipendentiButton;
   @FXML
    public TableView tabellaCercaDipendenteTableView;
   @FXML
    public Button cercaCercaDipendenteButton;
   @FXML
    public TextField nomeCercaDipendenteTextField;
   @FXML
    public TextField cognomeCercaDipendenteTextField;
   @FXML
    public DatePicker dataNascitaCercaDipendenteDataPicker;
   @FXML
    public Button annullaCercaDipendenteButton;

    public void modificaDipendenteButtonPressed(ActionEvent actionEvent) {
        
    }

    public void eliminaDipendentiButton(ActionEvent actionEvent) {
    }

    public void cercaCercaDipendenteButton(ActionEvent actionEvent) {
    }

    public void annullaCercaDipendenteButtonPressed(ActionEvent actionEvent) {
        nomeCercaDipendenteTextField.clear();
        cognomeCercaDipendenteTextField.clear();
        dataNascitaCercaDipendenteDataPicker.setValue(null);
    }
}
