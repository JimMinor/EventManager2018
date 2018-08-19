package pacchettoViste;
import javafx.application.Application;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class menuPrincipaleController implements  Initializable,controlledScreen {


    @FXML
    private TabPane menuPrincipaleTabPane;
    @FXML
    private AnchorPane eventiArchorPane;

    private Application myApp;


    @Override
    public void initialize(URL url, ResourceBundle rb) {}
    @Override
    public void setScreenParent(cambiaScreen screenPage){}
    public void setApp(Application a){
        myApp=a;
    }










}
