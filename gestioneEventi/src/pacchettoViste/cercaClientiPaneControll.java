package pacchettoViste;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class cercaClientiPaneControll implements screenController, Initializable {
    @FXML public Button visualizzaDatiClienti;
    @FXML private AnchorPane cercaClientiPaneScreen;



    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    @Override
    public void setCambiaStage(cambiaStage cambiaStage){}
    public void visualizzaDatiClientiButton(){
        new cambiaPane().mostraPane(cercaClientiPaneScreen,"visuaizzaClientiScreen.fxml");
    }
}
