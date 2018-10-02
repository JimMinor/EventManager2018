package Main;

import Controller.CambiaStage;
import DB.GestoreQueryCerca;
import Model.Evento;
import Model.Impiegato;
import Model.LuogoEnum;
import javafx.application.Application;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

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
        // TEST - BEGIN 
        Impiegato i = new Impiegato();
        i.setAmministratore("Amministratore");
        i.setUsername("JimMinor");
        // TEST - END
        cambiaStagePrincipale.mostraStageMenuPrincipale(i);
        stagePrincipale.show();
    }


}
