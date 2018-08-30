package pacchettoViste;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class inserisciEventoController implements Initializable, screenController {

    @FXML
    public Button annullaEventoButton;
    @FXML
    public AnchorPane inserisciEventoAnchorPane;

    public Button getAnnullaEventoButton() {
        return annullaEventoButton;
    }

    public Button getInserisciEventoButton() {
        return inserisciEventoButton;
    }

    public DatePicker getDataEventoDatePicker() {
        return dataEventoDatePicker;
    }

    public TextField getCapienzaMaxEventoTextField() {
        return capienzaMaxEventoTextField;
    }

    public TextArea getDescrizioneEventoTextArea() {
        return descrizioneEventoTextArea;
    }

    public TextField getCittaEventoTextField() {
        return cittaEventoTextField;
    }

    public TextField getLuogoEventoTextField() {
        return luogoEventoTextField;
    }

    public TextField getNomeEventoTextField() {
        return nomeEventoTextField;
    }

    public AnchorPane getGenereEventoAnchorPane() {
        return genereEventoAnchorPane;
    }

    public ComboBox getEventoTipoComboBox() {
        return eventoTipoComboBox;
    }

    @FXML
    public Button inserisciEventoButton;
    @FXML
    public DatePicker dataEventoDatePicker;
    @FXML
    public TextField capienzaMaxEventoTextField;
    @FXML
    public TextArea descrizioneEventoTextArea;
    @FXML
    public TextField cittaEventoTextField;
    @FXML
    public TextField luogoEventoTextField;
    @FXML
    public TextField nomeEventoTextField;
    @FXML
    public AnchorPane genereEventoAnchorPane;
    @FXML
    public ComboBox eventoTipoComboBox;
    public String operazione="pulisci";

    //lista tipo evento
    ObservableList<String> list = FXCollections.observableArrayList("Musicali", "Sportivi", "Cultura e Teatro");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventoTipoComboBox.setItems(list);
        eventoTipoComboBox.setOnAction(e -> tipoevento());


    }


    public void tipoevento() {
        String valore = (String) eventoTipoComboBox.getValue();
        if (valore == "Musicali")
            new paneController().mostraPanePulito(genereEventoAnchorPane, "musicaliPane.fxml");
        else if (valore == "Sportivi")
            new paneController().mostraPanePulito(genereEventoAnchorPane, "sportivoPane.fxml");
        else if (valore == "Cultura e Teatro")
            new paneController().mostraPanePulito(genereEventoAnchorPane, "culturaPane.fxml");
        else new paneController().mostraPanePulito(genereEventoAnchorPane, "");
    }


    public void inserisciEventoButton(ActionEvent actionEvent) {
    }

    public void annullaEventoButtonPressed(ActionEvent actionEvent) {
        tastoAnnulla(operazione);
    }

    @Override
    public void setCambiaStage(cambiaStage cambiaStage) {

    }
    public void tastoAnnulla(String operazione){
        if (operazione=="pulisci") {
            nomeEventoTextField.clear();
            cittaEventoTextField.clear();
            luogoEventoTextField.clear();
            capienzaMaxEventoTextField.clear();
            dataEventoDatePicker.setValue(null);
            eventoTipoComboBox.setValue(null);
            descrizioneEventoTextArea.clear();
        }else {
            new paneController().mostraPanePulito(inserisciEventoAnchorPane, "cercaEventoPane.fxml");
        }

    }

}
