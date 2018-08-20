package pacchettoViste;

import java.io.IOException;
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
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class cambiaScreen extends StackPane{

    private HashMap<String,Node> screens = new HashMap<>();


    public cambiaScreen()
    {
        super();
    }

    /**  addScreen:
     *   Permette di aggiungere uno screen all'insieme di
     *   screen che dovranno essere controllati.
     */

    public synchronized void addScreen(String nome,Node screen){
        screens.put(nome,screen);
    }

    /** removeScreen
     *  Permette  di eliminare uno screen dall'insieme.
     * @return void
     * @param nome dello screen da rimuovere
     *
     */

    public synchronized  void removeScreen(String nome)
    {
        screens.remove(nome);
    }

    /** getScreen
     * @return node Uno screen dall'insieme
     * @param nome dello screen selezionato
     */
    public synchronized Node getScreen(String nome){
        return screens.get(nome);
    }

    /** caricaScreen
     * @param name nome dello screen da inserire
     * @param resource nome della risorsa,file fxml
     * @return true se e' stato trovata la risorsa
     *          false altrimenti
     *
     *  */

    public synchronized  boolean caricaScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            controlledScreen myScreenControler = ((controlledScreen) myLoader.getController());
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println("Non trovato"+e.getMessage());
            return false;
        }
    }

    /**
     *
     * @param name
     * @return
     */
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

    public void mostraMenuPrincipale(mainApp g){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menuPrincipaleScreen.fxml"));
            g.stagePrincipale.setScene(new Scene(root));
            g.stagePrincipale.show();
        }
        catch(IOException e){}
    }
}
