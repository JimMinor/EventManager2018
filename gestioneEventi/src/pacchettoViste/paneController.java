package pacchettoViste;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * NON FUNZIONANTE:
 * Bisogna mantenere il riferimento ai nodi creati,
 * usando un HashMap<String,Node>, oppure un riferimento,
 * al Node attivo
 */
public class paneController {


    public void mostraPanePulito(AnchorPane pane, String risorsa) {
        try {
            rimuoviPane(pane);
            Node node = (Node) FXMLLoader.load(getClass().getResource("../FXML/"+risorsa));
            pane.getChildren().add(node);

        } catch (Exception e) {
        }
    }



    public void mostraPanePreCompilato(AnchorPane pane, String risorsa) {
        try {
            rimuoviPane(pane);
            Node node = (Node) FXMLLoader.load(getClass().getResource(risorsa));
            pane.getChildren().add(node);

        } catch (Exception e) {
        }
    }

    public void rimuoviPane(AnchorPane pane) {
        pane.getChildren().clear();//pulisce la scermata
    }


}
