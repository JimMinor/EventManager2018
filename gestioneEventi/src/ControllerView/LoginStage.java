package ControllerView;

import Controller.CambiaStage;
import Controller.ControlledStage;
import DB.LoginCommand;
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
    private CambiaStage myCambiaStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    @Override
    public void setCambiaStage(CambiaStage cambiaStage) { myCambiaStage = cambiaStage;}

    /**
     * entraButtonPressed()
     * <p>
     * Verifica se i dati inseriti siano corretti
     */
    @FXML
    public void entraButtonPressed(javafx.event.ActionEvent event) {
        String username = usernameTextField.getText();
        String password =  passwordTextField.getText();
        try{
            new LoginCommand(username, password).execute();
            myCambiaStage.mostraStageMenuPrincipale();
        }
        catch(Exception e){ MostraAlert.mostraAlertLogin(); }
    }
    @FXML
    public void annullaButtonPressed() {
        usernameTextField.clear();
        passwordTextField.clear();
    }


}
