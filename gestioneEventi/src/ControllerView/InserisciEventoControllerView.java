package ControllerView;

import Controller.*;
import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.Evento;
import Model.LuogoEnum;
import Model.TipologiaEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.*;

public class InserisciEventoControllerView {

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

    public InserisciEventoControllerView(CambiaView cambiaView) {
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




    /**
     *  Metodi eventi ControllerView
     */
    @FXML public void inserisciEventoButtonPressed() {
       try {

           new DatiEventoController(this).controllaDatiEvento();
           MostraAlert.mostraAlertEventoInserito();
           pulisciForm();
       }
       catch (NoValidEventDataException e) {
           MostraAlert.mostraAlertErroreInserimentoEvento(e.getMessagge());
       }
       catch( Exception e){
           e.printStackTrace();
           MostraAlert.mostraAlertErroreInserimentoEvento("Errore Inserimento Evento");
       }

    }

    @FXML public void selezioneTipologia()
    {
        genereEventoComboBox.setItems(FXCollections.observableArrayList(tipologiaEventoComboBox.getValue().getListaGeneri()));
    }

    @FXML public void aggiungiButtonPressed(){
        partecipantiEvento.add(partecipanteEventoTextField.getText());
        partecipanteEventoTextField.clear();
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
