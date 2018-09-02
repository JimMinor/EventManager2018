package pacchettoViste;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.vivoxalabs.customstage.CustomStage;
import lk.vivoxalabs.customstage.CustomStageBuilder;
import lk.vivoxalabs.customstage.tools.NavigationType;
import lk.vivoxalabs.customstage.tools.Style;
import lk.vivoxalabs.scenemanager.tools.FileLoader;

public class mainApp extends Application {


    private CustomStage stagePrincipale;
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

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../FXML/menuPrincipaleScreen.fxml"));
        CustomStageBuilder builder = new CustomStageBuilder();
        builder=builder.setWindowTitle("Gestione Vendita Biglietti");
        builder=builder.setTitleColor("blue");
        builder=builder.setWindowColor("white");
        builder = builder.setNavigationPane(NavigationType.TOP,pane);
        builder = builder.setStyleSheet(getClass().getResource("bootstrap3.css"));
        CustomStage stagePrincipaleCustom = builder.build();
        this.stagePrincipale = stagePrincipaleCustom;

        //myScreen = new cambiaStage(this);
        //myScreen.mostraScreenLogin("../FXML/menuPrincipaleScreen.fxml");

        stagePrincipaleCustom.show();



    }

}
