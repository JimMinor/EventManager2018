package ControllerView;

import Controller.CambiaStage;
import Controller.CambiaView;
import Controller.ControlledStage;
import DB.GestoreQueryCerca;
import Model.Impiegato;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.ECMAException;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuPrincipaleStage implements Initializable, ControlledStage {

    @FXML private Button gestioneClientiButton;
    @FXML private Button gestionePersonaleButton;
    @FXML private Button visualizzaStaticheButton;
    @FXML private Button cercaEventoButton;
    @FXML private Button inserisciEventiButton;
    @FXML private AnchorPane cambiaFormMenuPrincipale;
    @FXML private Label utenteConnessoLabel;
    private Stage stagePrincipale;
    private CambiaStage myScreen;
    private CambiaView cambiaForm;



    private Impiegato utenteConnesso;

    @Override public void initialize(URL url, ResourceBundle rb) {
        cambiaForm=new CambiaView(cambiaFormMenuPrincipale);
    }

    @Override public void setCambiaStage(CambiaStage cambiaStage) {}

    @FXML public void inserisciEventiButtonPressed() {

        cambiaForm.mostraFormInserisciEvento();
    }

    @FXML public void cercaEventoButtonPressed() {
        cambiaForm.mostraFormCercaEvento();

    }

    @FXML public void CercaClientiButtonPressed() {

        try {

            if (!utenteConnesso.getAmministratore().equals("Amministratore")) throw new Exception();
            cambiaForm.mostraFormGestioneClienti();
        } catch ( Exception e ) {

            MostraAlert.mostraAlertErroreInserimentoEvento(" Non hai i permessi per accedere a quest'area");
        }

    }

    @FXML public void getsionePersonaleButtonPressed() {
        try {

            if (!utenteConnesso.getAmministratore().equals("Amministratore")) throw new Exception();
            cambiaForm.mostraFormGestioneDipendeti();
        } catch ( Exception e ) {

            MostraAlert.mostraAlertErroreInserimentoEvento(" Non hai i permessi per accedere a quest'area");
        }
    }

    @FXML public void statisticaButtonPressed() { cambiaForm.mostraStaticheMenu(); }

    @FXML public void logoutHyperlinkPressed() {


    }

    public void setUtenteConnesso(Impiegato utenteConnesso) {

        this.utenteConnesso = utenteConnesso;
        utenteConnessoLabel.setText(utenteConnesso.getUsername());
    }
}
