package Scaffale;

import Control.CambiaStage;
import Control.ControlledStage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class cercaClientiPaneControll implements ControlledStage, Initializable {

    @FXML public Button visualizzaDatiClienti;
    @FXML private AnchorPane cercaClientiPaneScreen;

    @Override public void initialize(URL url, ResourceBundle rb) {}

    @Override public void setCambiaStage(CambiaStage cambiaStage){}

    public void visualizzaDatiClientiButton(){
     //   new cambiaPane().mostraPane(cercaClientiPaneScreen);
    }
}
