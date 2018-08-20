package pacchettoViste;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.ArrayList;

public class mainApp extends Application {

    private String loginScreenFile = "loginScreen.fxml";
    private Group root = new Group();
    public Stage stagePrincipale;



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**  Carica il primo stage con la schermata di login */
    @Override
    public void start(Stage stagePrincipale) throws Exception {

        this.stagePrincipale=stagePrincipale;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(loginScreenFile));
        Parent radice=(Parent)loader.load();
        stagePrincipale.setScene(new Scene(radice));
        loginScreenController myLoginScreen = (loginScreenController)loader.getController();
        myLoginScreen.setApp(this);
        stagePrincipale.show();

      }




}
