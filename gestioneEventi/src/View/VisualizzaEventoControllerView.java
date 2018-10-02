package View;

import Controller.CambiaView;
import Model.Evento;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class VisualizzaEventoControllerView implements Initializable {

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
    private CambiaView cambiaView;
    private Evento eventoDaVisualizzare;

    public VisualizzaEventoControllerView(CambiaView cambiaView, Evento eventoDaVisualizzare)
    {
        this.cambiaView = cambiaView;
        this.eventoDaVisualizzare = eventoDaVisualizzare;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nomeEventoTextField.setText(eventoDaVisualizzare.getNome());
        luogoEventoTextField.setText(eventoDaVisualizzare.getLuogoEvento().name());
        tipoEventoTextField.setText(eventoDaVisualizzare.getTipologiaEvento().name());
        dataEventoDatePicker.setValue(eventoDaVisualizzare.getDataEvento());
        descrizioneEventoTextField.setText(eventoDaVisualizzare.getDescrizione());
        genereEventoTextField.setText(eventoDaVisualizzare.getGenereEvento());
        prezzoTextField.setText(eventoDaVisualizzare.getPrezzoBiglietto().toString());
    }

    @FXML public void okButtonPressed(){
        cambiaView.mostraFormCercaEvento();
    }


}
