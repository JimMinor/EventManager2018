package pacchettoViste;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class menuPrincipaleController implements  Initializable,screenController {

    @FXML private AnchorPane  switchPane;
    @FXML private Button inserisciEventoButton;
    private cambiaStage myCambiaStage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    @Override
    public void setCambiaStage(cambiaStage cambiaStage){myCambiaStage=cambiaStage;}

    @FXML public void inserisciEventoButtonPressed(){
        new cambiaPane().mostraPane(switchPane,"inserisciEventoPane.fxml"); }
     @FXML public void cercaEventoButtonPressed(){
        new cambiaPane().mostraPane(switchPane,"cercaEventoPane.fxml");
     }











}
