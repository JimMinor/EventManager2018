package View;

import Controller.CambiaStage;
import Controller.ControlledStage;
import Controller.FormController;
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
   
    public Button visualizzaDatiClientiButton;
    public TableView tabellaCercaClientiTableView;
    public Button eliminaClientiButton;
    public Button annullaCercaClientiButton;
    public Button cercaClienteButton;
    public TextField usernameCercaClientiTextField;
    public AnchorPane cercaClientiPaneScreen;
    private FormController cambiaForm;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cambiaForm=new FormController(cercaClientiPaneScreen);


    }

    @Override
    public void setCambiaStage(CambiaStage cambiaStage) {
    }


    public void visualizzaDatiClientiButtonPressed(ActionEvent actionEvent) {
        cambiaForm.visualizzaPaneClienti();

    }
    public void annullaCercaClientiButtonPressed(){
        usernameCercaClientiTextField.clear();
        
    }

    public void cercaClienteButtonPressed() {
    }

    public void eliminaClientiButtonPressed() {
    }
}
