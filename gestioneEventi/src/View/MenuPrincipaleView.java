package View;

import Control.CambiaStage;
import Control.MenuPrincipaleController;
import Control.ControlledStage;
import Model.Impiegato;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuPrincipaleView implements Initializable, ControlledStage {

    @FXML private Button gestioneClientiButton;
    @FXML private Button gestionePersonaleButton;
    @FXML private Button visualizzaStaticheButton;
    @FXML private Button cercaEventoButton;
    @FXML private Button inserisciEventiButton;
    @FXML private AnchorPane cambiaFormMenuPrincipale;
    @FXML private Label utenteConnessoLabel;
    private Stage stagePrincipale;
    private CambiaStage myScreen;
    private MenuPrincipaleController cambiaForm;



    private Impiegato utenteConnesso;

    @Override public void initialize(URL url, ResourceBundle rb) {
        cambiaForm=new MenuPrincipaleController(cambiaFormMenuPrincipale,this);
    }

    @Override public void setCambiaStage(CambiaStage cambiaStage) {}

    @FXML public void statisticaButtonPressed() { cambiaForm.mostraStaticheMenu(); }

    @FXML public void logoutHyperlinkPressed() {


    }


    public Button getGestioneClientiButton() {
        return gestioneClientiButton;
    }

    public Button getGestionePersonaleButton() {
        return gestionePersonaleButton;
    }

    public Button getVisualizzaStaticheButton() {
        return visualizzaStaticheButton;
    }

    public Button getCercaEventoButton() {
        return cercaEventoButton;
    }

    public Button getInserisciEventiButton() {
        return inserisciEventiButton;
    }

    public AnchorPane getCambiaFormMenuPrincipale() {
        return cambiaFormMenuPrincipale;
    }

    public Label getUtenteConnessoLabel() {
        return utenteConnessoLabel;
    }

    public Stage getStagePrincipale() {
        return stagePrincipale;
    }

    public CambiaStage getMyScreen() {
        return myScreen;
    }

    public MenuPrincipaleController getCambiaForm() {
        return cambiaForm;
    }

    public Impiegato getUtenteConnesso() {
        return utenteConnesso;
    }

    public void setUtenteConnesso(Impiegato utenteConnesso) {

        this.utenteConnesso = utenteConnesso;
        utenteConnessoLabel.setText(utenteConnesso.getUsername()+ " - " + utenteConnesso.getAmministratore());
    }
}
