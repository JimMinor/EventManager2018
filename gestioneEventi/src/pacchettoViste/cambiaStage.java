package pacchettoViste;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import jfxtras.styles.jmetro8.JMetro;


public class cambiaStage {

    private mainApp myApp;

    public cambiaStage(mainApp myApp){this.myApp=myApp;}


    public<S extends screenController> Scene caricaScene(String risorsaScreen) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(risorsaScreen));
        Parent root = loader.load();
        S screenController=loader.getController();
        screenController.setCambiaStage(this);
        return new Scene(root);
    }
    public void setScene(Scene scene){
        scene.getStylesheets().add("src/CSS/bootstrap3.css");
        myApp.getStagePrincipale().setScene(scene);
        myApp.getStagePrincipale().show();
    }
    public  void mostraScreenLogin(String risorsaScreen){

        try {
            // Carica la risorsa(File fxml) e inizializza il suo controller
            Scene scene = caricaScene(risorsaScreen);
            // Modifica le proprieta' per la schermata di Login
            if(scene!=null) {
                myApp.getStagePrincipale().setResizable(false);
                setScene(scene);
                }
            else throw new NullPointerException(); //necessaria?
    }
        catch(Exception e){
            // DO-Something
        }
    }
    public  void mostraScreenMenuPrincipale(String risorsaScreen){

        try {
            // Carica la risorsa(File fxml) e inizializza il suo controller
            Scene scene = caricaScene(risorsaScreen);
            // Modifica le proprieta' per il menu principale2
            if(scene!=null) {
                setScene(scene);
            }


        }
        catch(Exception e){
            // DO-Something
        }
    }

}
