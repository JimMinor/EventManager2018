package pacchettoViste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class menuPrincipaleController implements  Initializable,screenController {

    @FXML public Button cercaClientiButton;
    @FXML public Button inserisciDipendenteButton;
    @FXML public Button cercaDipendenteButton;
    @FXML public Button statisticaButton;
    @FXML public Button cercaEventoButton;
    @FXML private AnchorPane switchPane;
    @FXML private Button inserisciEventoButton;
    private cambiaStage myCambiaStage;
    @FXML public Button visualizzaDatiClienti;
    @FXML private AnchorPane cercaClientiPaneScreen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    @Override
    public void setCambiaStage(cambiaStage cambiaStage){myCambiaStage=cambiaStage;}

     public void inserisciEventoButtonPressed(){
        new cambiaPane().mostraPane(switchPane,"inserisciEventoPane.fxml");
    }
     public void cercaEventoButtonPressed(){
        new cambiaPane().mostraPane(switchPane,"cercaEventoPane.fxml");
    }

     public void CercaClientiButtonPressed(){
        new cambiaPane().mostraPane(switchPane,"cercaClientPane.fxml");
    }


    public void inserisciDipendentiButtonPressed() {
        new cambiaPane().mostraPane(switchPane,"inserisciDipendentePane.fxml");

    }

    public void cercaDipendentiButtonPressed() {
        new cambiaPane().mostraPane(switchPane,"cercaDipendentiPane.fxml");
    }

    public void statisticaButtonPressed(ActionEvent actionEvent) {
        new cambiaPane().mostraPane(switchPane,"");
    }
}
