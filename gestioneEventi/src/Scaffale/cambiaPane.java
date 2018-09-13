package Scaffale;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
/** NON FUNZIONANTE:
  Bisogna mantenere il riferimento ai nodi creati,
  usando un HashMap<String,Node>, oppure un riferimento,
  al Node attivo
  */
public class cambiaPane {

    public void mostraPane(AnchorPane pane, String risorsa){
        System.out.println("../FXML/"+risorsa);
        try {
            rimuoviPane(pane);
            Node node = (Node) FXMLLoader.load(getClass().getResource("../FXML/"+risorsa));
            pane.getChildren().add(node);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void rimuoviPane(AnchorPane pane){
        //pulisce la scermata
        pane.getChildren().clear();
    }




}
