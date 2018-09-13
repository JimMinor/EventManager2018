package Main;

import Controller.CambiaStage;
import Model.LuogoEnum;
import javafx.application.Application;
import javafx.stage.Stage;

public class mainApp extends Application {
    private Stage stagePrincipale;
    private CambiaStage cambiaStagePrincipale;
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
        cambiaStagePrincipale = new CambiaStage(this);
        cambiaStagePrincipale.mostraStageMenuPrincipale();
        for(LuogoEnum l: LuogoEnum.values()){
            System.out.println(l);
        }
        stagePrincipale.show();
    }

}
