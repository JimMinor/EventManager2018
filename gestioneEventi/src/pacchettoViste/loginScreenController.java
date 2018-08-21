package pacchettoViste;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import pacchettoDB.autenticazione;
import pacchettoDB.autenticazioneConcreta;

public class loginScreenController implements Initializable,screenController {


    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    private cambiaStage myCambiaStage;



    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    @Override
    public void setCambiaStage(cambiaStage cambiaStage){myCambiaStage=cambiaStage;}

    /** entraButtonPressed()
     *
     *  Query al DB per la ricerca di un impiegato
     *
     */
    @FXML
    public void entraButtonPressed(javafx.event.ActionEvent event)  {

       try{
           // Verifica l'autenticazione dell'utente
           autenticazione myAut = new autenticazioneConcreta();
           if(!myAut.autenticaUtente(usernameTextField.getText(),passwordTextField.getText())) {
               mostraAlert.mostraAlertLogin();
               return;
           }

         }
       catch(Exception e){
           mostraAlert.mostraAlertErroreDB();
           return;
       }
        myCambiaStage.mostraScreen("menuPrincipaleScreen.fxml");
    }

    /**
     * Pulisce le TextField
     *
     */
    @FXML
    public void annullaButtonPressed(){
        usernameTextField.clear();
        passwordTextField.clear();
    }


}
