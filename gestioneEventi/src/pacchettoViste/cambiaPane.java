package pacchettoViste;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class cambiaPane {

    public void mostraPane(AnchorPane pane, String risorsa){
        try {
            rimuoviPane(pane);
            Node node = (Node) FXMLLoader.load(getClass().getResource(risorsa));
            pane.getChildren().add(node);
        }catch(Exception e){}
    }
    public void rimuoviPane(AnchorPane pane){
        pane.getChildren().removeAll();
    }




}
