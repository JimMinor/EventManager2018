package View;

import Control.MenuPrincipaleController;
import Model.Evento;
import Model.VisualizzaEventiModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class VisualizzaEventoView implements Observer {

    // FXML FIELDS--------------------------------
    @FXML private JFXTextField nomeEventoTextField;
    @FXML private JFXTextField luogoEventoTextField;
    @FXML private JFXTextField tipoEventoTextField;
    @FXML private JFXTextField genereEventoTextField;
    @FXML private JFXDatePicker dataEventoDatePicker;
    @FXML private JFXTextArea descrizioneEventoTextField;
    @FXML private JFXButton okButton;
    @FXML private JFXListView<String> listaPartecipantiListView;
    @FXML private JFXTextField prezzoTextField;
    // Others FIELDS--------------------------------------------
    private VisualizzaEventiModel visualizzaEventiModel;

    public VisualizzaEventoView(VisualizzaEventiModel visualizzaEventiModel) {
        this.visualizzaEventiModel = visualizzaEventiModel;
        visualizzaEventiModel.addObserver(this);
    }

    public void initialize(){}

    public JFXTextField getNomeEventoTextField() {
        return nomeEventoTextField;
    }

    public JFXTextField getLuogoEventoTextField() {
        return luogoEventoTextField;
    }

    public JFXTextField getTipoEventoTextField() {
        return tipoEventoTextField;
    }

    public JFXTextField getGenereEventoTextField() {
        return genereEventoTextField;
    }

    public JFXDatePicker getDataEventoDatePicker() {
        return dataEventoDatePicker;
    }

    public JFXTextArea getDescrizioneEventoTextField() {
        return descrizioneEventoTextField;
    }

    public JFXButton getOkButton() {
        return okButton;
    }

    public JFXListView<String> getListaPartecipantiListView() {
        return listaPartecipantiListView;
    }

    public JFXTextField getPrezzoTextField() {
        return prezzoTextField;
    }


    @Override
    public void update(Observable o, Object arg) {
        Evento eventoDaVisualizzare = (Evento) arg;

    }
}
