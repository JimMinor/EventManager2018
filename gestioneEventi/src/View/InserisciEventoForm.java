package View;

import Controller.*;
import Model.LuogoEnum;
import Model.TipologiaEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class InserisciEventoForm {

    @FXML private Button annullaButton;
    @FXML private Button inserisciButton;
    @FXML private DatePicker dataEventoDatePicker;
    @FXML private TextArea descrizioneEventoTextArea;
    @FXML private ComboBox<LuogoEnum> luogoEventoComboBox;
    @FXML private TextField nomeEventoTextField;
    @FXML private AnchorPane genereEventoAnchorPane;
    @FXML private TextField prezzoBigliettoTextField;
    private TipologiaEnum tipologiaEvento;
    private ObservableList<LuogoEnum> listaLuoghiEvento;
    private FormController creaFormEventoSpecifico;
    private EventoController controllaDatiEvento;
    private EventoSpecificoForm datiEventoSpecifico;

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



    public AnchorPane getGenereEventoAnchorPane() {

        return genereEventoAnchorPane;
    }

    public void setGenereEventoAnchorPane(AnchorPane genereEventoAnchorPane) {
        this.genereEventoAnchorPane = genereEventoAnchorPane;
    }

    public void initialize() {
      luogoEventoComboBox.setItems(FXCollections.observableArrayList(LuogoEnum.values()));
    }
    public InserisciEventoForm(FormController creaFormEventoSpecifico, EventoSpecificoForm datiEventoSpecifico, EventoController controllaDatiEvento) {
        this.controllaDatiEvento=controllaDatiEvento;
        this.creaFormEventoSpecifico = creaFormEventoSpecifico;
        this.datiEventoSpecifico=datiEventoSpecifico;

    }

    public TipologiaEnum getTipologiaEvento() {
        return tipologiaEvento;
    }

    public void setTipologiaEvento(TipologiaEnum tipologiaEvento) {
        this.tipologiaEvento = tipologiaEvento;
    }

    @FXML public void inserisciEventoButtonPressed() {
       try{
           controllaDatiEvento.controllaDatiEventoGenerico(this);
           datiEventoSpecifico.inviaDatiEventoSpecifico();
           pulisciForm();
           datiEventoSpecifico.pulisciForm();
           MostraAlert.mostraAlertEventoInserito();

       }
       catch(NoValidEventDataException e){
           MostraAlert.mostraAlertErroreInserimentoEvento(e.getMessagge());
       }
    }

    private void pulisciForm() {
        descrizioneEventoTextArea.clear();
        nomeEventoTextField.clear();
        prezzoBigliettoTextField.clear();

    }

    @FXML public void annullaButtonPressed(ActionEvent actionEvent) {tastoAnnulla();}

    public void tastoAnnulla() {
        creaFormEventoSpecifico.mostraFormTipoEvento();
    }





}
