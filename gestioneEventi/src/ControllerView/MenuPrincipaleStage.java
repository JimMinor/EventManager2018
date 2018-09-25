package ControllerView;

import Controller.CambiaStage;
import Controller.CambiaView;
import Controller.ControlledStage;
import DB.GestoreQueryCerca;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuPrincipaleStage implements Initializable, ControlledStage {

    @FXML public Button gestioneClientiButton;
    @FXML public Button gestionePersonaleButton;
    @FXML public Button visualizzaStaticheButton;
    @FXML public Button cercaEventoButton;
    @FXML public Button inserisciEventiButton;
    @FXML private AnchorPane cambiaFormMenuPrincipale;
    private Stage stagePrincipale;
    private CambiaStage myScreen;
    private CambiaView cambiaForm;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cambiaForm=new CambiaView(cambiaFormMenuPrincipale);
    }

    @Override
    public void setCambiaStage(CambiaStage cambiaStage) {}

    public void inserisciEventiButtonPressed() {

        cambiaForm.mostraFormInserisciEvento();
    }

    public void cercaEventoButtonPressed() {
        cambiaForm.mostraFormCercaEvento();

    }

    public void CercaClientiButtonPressed() {
        cambiaForm.mostraFormGestioneClienti();
    }

    public void getsionePersonaleButtonPressed() { cambiaForm.mostraFormGestioneDipendeti(); }

    public void statisticaButtonPressed() { cambiaForm.mostraStaticheMenu(); }


    public void logoutHyperlinkPressed() {


    }
}
