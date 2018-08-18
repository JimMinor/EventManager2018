package pacchettoViste;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class applicationController extends Application {


    public static String loginScreenID= "loginScreen";
    public static String menuPrincipaleScreenID = "menuPrincipale";
    public static String loginScreenFile = "loginScreen.fxml";
    public static String menuPrincipaleScreenFile = " menuPrincipaleScreen.fxml";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

       /** screensControl mainContainer = new screensControl();
        mainContainer.caricaScreen(loginScreenID,loginScreenFile);
        mainContainer.caricaScreen(menuPrincipaleScreenID,menuPrincipaleScreenFile);
        mainContainer.setScreen(loginScreenID);
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        **/
       pacchettoDB.connessioneDB.connettiDB();

    }
}
