package pacchettoViste;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class cambiaStage {

    private mainApp myApp;

    public cambiaStage(mainApp myApp){this.myApp=myApp;}

    public<S extends screenController> void mostraScreen(String risorsaScreen){

        try {
            // Carica la risorsa(File fxml) e inizializza il suo controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource(risorsaScreen));

             Parent root = loader.load();
             S screenController=loader.getController();
             screenController.setCambiaStage(this);
             myApp.getStagePrincipale().setScene(new Scene(root));
             myApp.getStagePrincipale().show();

        }
        catch(IOException e){
            // DO-Something
        }
    }

}
