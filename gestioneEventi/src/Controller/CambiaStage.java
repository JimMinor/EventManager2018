package Controller;

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
        screens.put("menuPrincipale","../FXML/menuPrincipaleScreen.fxml");
        screens.put("login","../FXML/loginScreen.fxml");
        this.myApp = myApp;
    }
    public <S extends ControlledStage> Scene caricaScene(String risorsaScreen) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(screens.get(risorsaScreen)));
        Parent root = loader.load();
        S screenController = loader.getController();
        screenController.setCambiaStage(this);
        return new Scene(root);
    }

    public void setScene(Scene scene) {
        scene.getStylesheets().clear();
        myApp.getStagePrincipale().setScene(scene);
    }

    public void mostraStageLogin() {

        try {
            // Carica la risorsa(File fxml) e inizializza il suo controller
            Scene scene = caricaScene("login");
            if (scene != null) {
                myApp.getStagePrincipale().setResizable(false);
                myApp.getStagePrincipale().setTitle("Schermata Login");
                setScene(scene);
            } else throw new Exception(); //necessaria?
        } catch (Exception e) {
            // DO-Something
        }
    }

    public void mostraStageMenuPrincipale(){
        try {
            // Carica la risorsa(File fxml) e inizializza il suo controller
            Scene scene = caricaScene("menuPrincipale");
            if (scene != null) {
                myApp.getStagePrincipale().setResizable(true);
                myApp.getStagePrincipale().setTitle("Gestione Eventi e Personale");
                setScene(scene);
            } else throw new Exception(); //necessaria?
        } catch (Exception e) {
            // DO-Something
        }
    }


}
