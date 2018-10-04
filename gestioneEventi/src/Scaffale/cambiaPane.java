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
        System.out.println("../FXMLView/"+risorsa);
        try {
            rimuoviPane(pane);
            Node node = FXMLLoader.load(getClass().getResource("../FXMLView/"+risorsa));
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
