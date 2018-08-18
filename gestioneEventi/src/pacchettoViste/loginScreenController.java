package pacchettoViste;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import pacchettoDB.impiegatoController;

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

    /** Controller **/
   private impiegatoController myImpiegatoController;

   private screensControl myScreenController;

    /** METODI ereditati **/
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    @Override
    public void setScreenParent(screensControl screenPage){
        this.myScreenController=screenPage;
    }


    /** Metodi  FXML  **/
    @FXML
    public void entraButtonPressed(ActionEvent e){
        myImpiegatoController = new impiegatoController();
       // myImpiegatoController.controllaDatiUtente(usernameTextField.getText(),passwordTextField.getText());


        /** DEBUG **/
        System.out.println(usernameTextField.getText()+""+ passwordTextField.getText());

    }

    @FXML
    public void annullaButtonPressed(){
        usernameTextField.clear();
        passwordTextField.clear();
    }


}
