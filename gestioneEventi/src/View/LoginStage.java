package View;

import Controller.CambiaStage;
import Controller.ControlledStage;
import DB.Autenticazione;
import DB.AutenticazioneConcreta;
import Model.Impiegato;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginStage implements Initializable, ControlledStage {

    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordTextField;
    @FXML private Button entraButton;
    @FXML private Button annullaButton;
    private CambiaStage cambiaStage;
    private Autenticazione autenticazione = new AutenticazioneConcreta();


    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    @Override
    public void setCambiaStage(CambiaStage cambiaStage) { this.cambiaStage = cambiaStage;}

    /**
     * entraButtonPressed()
     * <p>
     * Verifica se i dati inseriti siano corretti
     */
    @FXML public void entraButtonPressed() {
        String username = usernameTextField.getText();
        String password =  passwordTextField.getText();
        try{
            Impiegato utenteConnesso = autenticazione.autenticaUtente(username,password);
            cambiaStage.mostraStageMenuPrincipale(utenteConnesso);
        }
        catch(Exception e){ MostraAlert.mostraAlertLogin(); }
    }

    @FXML public void annullaButtonPressed() {
        usernameTextField.clear();
        passwordTextField.clear();
    }


}
