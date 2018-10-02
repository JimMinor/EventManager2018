package View;

import Controller.*;
import Model.LuogoEnum;
import Model.TipologiaEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.*;

public class InserisciEventoView extends AnchorPane {

    //FXMLView Fields---------------------------
    @FXML private Button annullaButton;
    @FXML private Button inserisciButton;
    @FXML private Button aggiungiButton;
    @FXML private DatePicker dataEventoDatePicker;
    @FXML private TextArea descrizioneEventoTextArea;
    @FXML private ComboBox<LuogoEnum> luogoEventoComboBox;
    @FXML private TextField nomeEventoTextField;
    @FXML private TextField prezzoBigliettoTextField;
    @FXML private TextField partecipanteEventoTextField;
    @FXML private ComboBox<String> genereEventoComboBox;


    @FXML private ComboBox<TipologiaEnum> tipologiaEventoComboBox;
    // Utilies Fields---------------------------------
    private TipologiaEnum tipologiaEvento;
    private ObservableList<LuogoEnum> listaLuoghiEvento;
    private CambiaView cambiaView;
    private Set<String> partecipantiEvento;


    /**
     *       Metodi per l'inizializzazione
     */

    public void initialize() {
        luogoEventoComboBox.setItems(FXCollections.observableArrayList(LuogoEnum.values()));
        tipologiaEventoComboBox.setItems(FXCollections.observableArrayList(TipologiaEnum.values()));
    }

    public InserisciEventoView(CambiaView cambiaView) {
        this.cambiaView = cambiaView;
        partecipantiEvento= new HashSet<>();

    }

    /**GETTER per i campi da Inserire nell'evento*/

    public TextField getPrezzoBigliettoTextField() {
        return prezzoBigliettoTextField;
    }

    public DatePicker getDataEventoDatePicker() {
        return dataEventoDatePicker;
    }

    public TextArea getDescrizioneEventoTextArea() {
        return descrizioneEventoTextArea;
    }

    public ComboBox<LuogoEnum> getLuogoEventoComboBox() {
        return luogoEventoComboBox;
    }

    public TextField getNomeEventoTextField() {
        return nomeEventoTextField;
    }

    public TipologiaEnum getTipologiaEvento() {
        return tipologiaEvento;
    }

    public ComboBox<String> getGenereEventoComboBox() {
        return genereEventoComboBox;
    }

    public Set<String> getPartecipantiEvento () { return partecipantiEvento; }

    public TextField getPartecipanteEventoTextField() {
        return partecipanteEventoTextField;
    }

    public Button getAnnullaButton() {
        return annullaButton;
    }

    public Button getAggiungiButton() {
        return aggiungiButton;
    }

    public Button getInserisciButton() {
        return inserisciButton;

    }




    /**
     *  Metodi eventi View
     */



     public void selezioneTipologia()
    {

    }



    private void pulisciForm() {
        descrizioneEventoTextArea.clear();
        nomeEventoTextField.clear();
        prezzoBigliettoTextField.clear();
        tipologiaEventoComboBox.setValue(null);
        luogoEventoComboBox.setValue(null);
        genereEventoComboBox.setValue(null);
    }

    public ComboBox<TipologiaEnum> getTipologiaEventoComboBox() {
        return tipologiaEventoComboBox;
    }









}
