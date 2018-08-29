package pacchettoViste;

import javafx.application.Application;
import javafx.stage.Stage;
import pacchettoDB.inserisciEventoDB;
import pacchettoEntita.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class mainApp extends Application {


    private Stage stagePrincipale;
    private cambiaStage myScreen;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Stage getStagePrincipale() {
        return stagePrincipale;
    }

    /**
     * Carica il primo stage con la schermata di login
     */
    @Override
    public void start(Stage stagePrincipale) throws Exception {
        this.stagePrincipale = stagePrincipale;
        myScreen = new cambiaStage(this);
        myScreen.mostraScreenLogin("menuPrincipaleScreen.fxml");
        stagePrincipale.show();
      

    }

}
