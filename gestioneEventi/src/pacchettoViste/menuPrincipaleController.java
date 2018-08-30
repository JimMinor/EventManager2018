package pacchettoViste;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class menuPrincipaleController implements Initializable, screenController {

    @FXML
    public Button cercaClientiButton;
    @FXML
    public Button inserisciDipendenteButton;
    @FXML
    public Button cercaDipendenteButton;
    @FXML
    public Button statisticaButton;
    @FXML
    public Button cercaEventoButton;
    @FXML
    public Label username;
    @FXML
    public Hyperlink logoutHyperlink;
    @FXML
    public Button inserisciEventiButton;
    public AnchorPane menuAnchorPane;
    @FXML
    private AnchorPane switchPane;

    private Stage stagePrincipale;
    private cambiaStage myScreen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @Override
    public void setCambiaStage(cambiaStage cambiaStage) {

    }

    public void inserisciEventiButtonPressed() {

        new paneController().mostraPanePulito(switchPane, "inserisciEventoPane.fxml");
    }

    public void cercaEventoButtonPressed() {
        new paneController().mostraPanePulito(switchPane, "cercaEventoPane.fxml");
    }

    public void CercaClientiButtonPressed() {
        new paneController().mostraPanePulito(switchPane, "cercaClientPane.fxml");
    }


    public void inserisciDipendentiButtonPressed() {
        new paneController().mostraPanePulito(switchPane, "inserisciDipendentePane.fxml");

    }

    public void cercaDipendentiButtonPressed() {
        new paneController().mostraPanePulito(switchPane, "cercaDipendentiPane.fxml");
    }

    public void statisticaButtonPressed() {
        new paneController().mostraPanePulito(switchPane, "");
    }




    public void logoutHyperlinkPressed() {


    }
}
