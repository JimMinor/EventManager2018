package pacchettoViste;
import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class screensControl extends StackPane{

    private HashMap<String,Node> screens = new HashMap<>();


    public screensControl()
    {
        super();
    }



    public  void addScreen(String nome,Node screen){
        screens.put(nome,screen);
    }

    /** removeScreen
     *  Permette  di eliminare uno screen
     *  dall'insieme
     */

    public  void removeScreen(String nome)
    {
        screens.remove(nome);
    }

    /** getScreen
     *  Ritorna uno specifico screen
     *  dall'insieme.
     */
    public Node getScreen(String nome){
        return screens.get(nome);
    }

    /** caricaScreen
     *  Carica un file fxml e lo aggiunge
     *  all'insieme di screen.
     *
     *  */

    public  boolean caricaScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            controlledScreen myScreenController = ((controlledScreen) myLoader.getController());
            myScreenController.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public synchronized boolean setScreen(String name){
        if (screens.get(name) != null) {   //screen loaded
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                getChildren().remove(0);
                                getChildren().add(0, screens.get(name));
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                                fadeIn.play();
                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {

            return false;
        }
    }


}