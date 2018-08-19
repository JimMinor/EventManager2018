package pacchettoViste;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class loginScreenController implements Initializable,controlledScreen {


    /** Attributi FXML **/
    @FXML
    private Button entraButton ;
    @FXML
    private Button annullaButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    private pacchettoDB.impiegatoDAO myImpiegatoDAO;
    private cambiaScreen myScreen;
    private gestioneEventiApp myApplication;

    /** METODI ereditati **/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myScreen= new cambiaScreen();
    }


   @Override
   public void setScreenParent(cambiaScreen screenPage){
        myScreen=screenPage;

   }

    public void setApp(gestioneEventiApp a){
       myApplication=a;
       System.out.println(myApplication);
        }

    /** Metodi  FXML  **/

    /** entraButtonPressed()
     *
     * @throws Exception
     *
     */
    @FXML
    public void entraButtonPressed(javafx.event.ActionEvent event) throws IOException {

        myImpiegatoDAO = new pacchettoDB.impiegatoDB();
       try{
           myImpiegatoDAO.trovaImpiegato(usernameTextField.getText(),passwordTextField.getText());
       }
       catch(Exception e){
           mostraAlert.mostraAlertLogin();
           return;
       }

        myScreen.mostraMenuPrincipale(myApplication);





    }

    @FXML
    public void annullaButtonPressed(){
        usernameTextField.clear();
        passwordTextField.clear();
    }


}
