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


    private Stage stagePrincipale;



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Stage getStagePrincipale() {
        return stagePrincipale;
    }

    /**  Carica il primo stage con la schermata di login */
    @Override
    public void start(Stage stagePrincipale) throws Exception {

        this.stagePrincipale=stagePrincipale;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginScreen.fxml"));
        Parent radice=loader.load();
        stagePrincipale.setScene(new Scene(radice));
        loginScreenController myLoginScreen = loader.getController();
        myLoginScreen.setApp(this);
        stagePrincipale.setTitle("Login");
        stagePrincipale.show();

      }




}
