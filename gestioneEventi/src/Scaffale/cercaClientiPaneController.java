package Scaffale;

import Controller.CambiaStage;
import Controller.ControlledStage;
import Controller.ModificaPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class cercaClientiPaneController implements ControlledStage, Initializable {

    @FXML
    private AnchorPane cercaClientiPaneScreen;
    @FXML
    public Button visualizzaDatiClientiButton;
    @FXML
    public TableView tabellaCercaClientiTableView;
    @FXML
    public Button eliminaClientiButton;
    @FXML
    public Button annullaCercaClientiButton;
    @FXML
    public Button cercaClienteButton;
    @FXML 
    public TextField usernameCercaClientiTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void setCambiaStage(CambiaStage cambiaStage) {
    }

    public void visualizzaDatiClientiButtonPressed() {
        new ModificaPane().visualizzapaneclienti(cercaClientiPaneScreen, "visuaizzaClientiPane.fxml");

    }
    public void annullaCercaClientiButtonPressed(){
        usernameCercaClientiTextField.clear();
        
    }

    public void cercaClienteButtonPressed() {
    }

    public void eliminaClientiButtonPressed(ActionEvent actionEvent) {
    }
}
