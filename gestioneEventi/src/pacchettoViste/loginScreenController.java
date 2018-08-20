package pacchettoViste;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import pacchettoDB.autenticatore;
import pacchettoDB.impiegatoDAO;

public class loginScreenController implements Initializable {

    @FXML
    private Button entraButton ;
    @FXML
    private Button annullaButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    private pacchettoDB.autenticatore myAut;
    private cambiaScreen myScreen;
    private mainApp myApplication;



     /****************************
      *     Getter               *
      ****************************
      */
    public autenticatore getMyAutenticatore() {
        return myAut;
    }

    public cambiaScreen getMyScreen() {
        return myScreen;
    }

    public mainApp getMyApplication() {
        return myApplication;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myScreen= new cambiaScreen();
        myAut = new autenticatore();
    }


    public void setApp(mainApp a){
       myApplication=a;
       System.out.println(myApplication);
        }



    /****************************
     *     Metodi FXML          *
     ****************************
     */


    /** entraButtonPressed()
     *
     *  Query al DB per la ricerca di un impiegato
     *
     */
    @FXML
    public void entraButtonPressed(javafx.event.ActionEvent event)  {

       try{
           // Verifica l'autenticazione dell'utente
           if(!myAut.autenticaUtente(usernameTextField.getText(),passwordTextField.getText()))
               mostraAlert.mostraAlertLogin();

         }
       catch(Exception e){
           mostraAlert.mostraAlertLogin();
           return;
       }

        myScreen.mostraMenuPrincipale(myApplication);
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
