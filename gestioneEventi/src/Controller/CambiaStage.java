package Controller;

import ControllerView.LoginStage;
import ControllerView.MenuPrincipaleStage;
import Model.Impiegato;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import Main.mainApp;

import java.util.HashMap;
import java.util.Map;



public class CambiaStage {

    private mainApp myApp;
    private Map<String,String> screens;

    public CambiaStage(mainApp myApp) {
        screens=new HashMap<>();
        screens.put("menuPrincipale","../FXMLView/menuPrincipaleScreen.fxml");
        screens.put("login","../FXMLView/loginScreen.fxml");
        this.myApp = myApp;
    }

    public void setScene(Scene scene) {
        scene.getStylesheets().clear();
        myApp.getStagePrincipale().setScene(scene);
    }

    public void mostraStageLogin() {

        try {
            // Carica la risorsa(File fxml) e inizializza il suo controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource(screens.get("login")));
            Parent root = loader.load();
            LoginStage screenController = loader.getController();
            screenController.setCambiaStage(this);
            Scene scene = new Scene(root);
            if (scene != null) {
                myApp.getStagePrincipale().setResizable(false);
                myApp.getStagePrincipale().setTitle("Schermata Login");
                setScene(scene);
            } else throw new Exception(); //necessaria?
        } catch (Exception e) {
            // DO-Something
        }
    }

    public void mostraStageMenuPrincipale(Impiegato utenteConnesso){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(screens.get("menuPrincipale")));
            Parent root = loader.load();
            MenuPrincipaleStage screenController = loader.getController();
            screenController.setCambiaStage(this);
            screenController.setUtenteConnesso(utenteConnesso);
            Scene scene = new Scene(root);

            if (scene != null) {
                myApp.getStagePrincipale().setResizable(false);
                myApp.getStagePrincipale().setTitle("Event Management");
                setScene(scene);
            } else throw new Exception(); //necessaria?
        } catch (Exception e) {
            // DO-Something
        }
    }


}
