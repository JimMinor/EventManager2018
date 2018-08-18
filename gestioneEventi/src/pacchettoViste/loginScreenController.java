package pacchettoViste;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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

    /** METODI ereditati **/
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

   @Override
   public void setScreenParent(cambiaScreen screenPage){
        myScreen=screenPage;

   }


    /** Metodi  FXML  **/

    /** entraButtonPressed()
     *
     * @throws Exception
     *
     */
    @FXML
    public void entraButtonPressed() {

        myImpiegatoDAO = new pacchettoDB.impiegatoDB();
       try{
           myImpiegatoDAO.trovaImpiegato(usernameTextField.getText(),passwordTextField.getText());
       }
       catch(Exception e){
           alertController.mostraAlertLogin();
           return;
       }
        myScreen.setScreen(applicationController.menuPrincipaleScreenID);

    }

    @FXML
    public void annullaButtonPressed(){
        usernameTextField.clear();
        passwordTextField.clear();
    }


}
