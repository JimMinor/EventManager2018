
package pacchettoViste;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
public class inserisciEventoController implements Initializable,screenController {
@FXML public ComboBox<String> eventoTipoCB;
ObservableList<String> list = FXCollections.observableArrayList("Musicali","Sportivi","Cultura e Teatro");
@FXML public AnchorPane generePane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventoTipoCB.setItems(list);

        eventoTipoCB.setOnAction(e -> tipoevento());

    }

    @Override
    public void setCambiaStage(cambiaStage cambiaStage) {

    }

    public void tipoevento(){
        String valore=eventoTipoCB.getValue();
        if (valore=="Musicali")
            new cambiaPane().mostraPane(generePane,"musicaliPane.fxml");
        else if(valore=="Sportivi")
            new cambiaPane().mostraPane(generePane,"sportivoPane.fxml");
        else if (valore=="Cultura e Teatro")
            new cambiaPane().mostraPane(generePane,"culturaPane.fxml");
    }


}
