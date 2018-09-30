package ControllerView;
import Controller.CambiaView;
import Controller.RicercaEventoController;
import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.VisualizzaEventiModel;
import Model.Evento;
import Model.LuogoEnum;
import javafx.collections.FXCollections;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CercaEventoControllerView implements Observer,Initializable {

    //------------FXML Fields-------------------

    // ----- BUTTONS  ------
    @FXML private Button modificaEventoButton;
    @FXML private Button eliminaEventoButton;
    @FXML private Button cercaEventoButton;
    @FXML private Button annullaCercaEventoButton;
    @FXML private Button okButton;
    @FXML private Button visualizzaDatiEventoButton;
    //  ----   TABLES  -----
    @FXML private TableView<Evento> tabellaCercaEventoTableView;
    @FXML private TableColumn<Evento, String> colonnaNomeEvento;
    @FXML private TableColumn<Evento, LuogoEnum> colonnaLuogoEvento;
    @FXML private TableColumn<Evento, LocalDate> colonnaDataEvento;
   //  ---- DATE FIELDS ----
    @FXML private TextField nomeCercaEventoTextField;
    @FXML private DatePicker dataCercaEventoDataPicker;
    @FXML private ComboBox<LuogoEnum> luogoEventoComboBox;
    @FXML private AnchorPane cercaEventoPaneScreen;
    // Utilites e Altri Fields---------------------
    private CambiaView cambiaView;
    private VisualizzaEventiModel eventiModel;
    private RicercaEventoController ricercaEventoController;
    private Evento eventoSelezionato;

    /** Metodi per l'inizializzazione della classe */

    public CercaEventoControllerView(CambiaView cambiaView, VisualizzaEventiModel eventiModel) {
        this.cambiaView = cambiaView;
        this.eventiModel = eventiModel;
        ricercaEventoController = new RicercaEventoController(eventiModel);
        eventiModel.addObserver(this);
    }

    public void initialize() {

        luogoEventoComboBox.setItems(FXCollections.observableArrayList(LuogoEnum.values()));

    }

    /** Metodi FXML per gli eventi */
    @FXML public void cercaEventoButtonPressed(){

        String nomeEvento = nomeCercaEventoTextField.getText();
        LuogoEnum luogoEnum = luogoEventoComboBox.getValue();
        LocalDate dataEvento = dataCercaEventoDataPicker.getValue();
        System.out.println(nomeEvento + luogoEnum + dataEvento);
        ricercaEventoController.cercaEventi(nomeEvento,dataEvento,luogoEnum);
    }

    @FXML public void eliminaEventoButtonPressed(){
        Evento evento = tabellaCercaEventoTableView.getSelectionModel().getSelectedItem();
        System.out.println(evento);
        ricercaEventoController.eliminaEventoSelezionato(evento);

    }

    @FXML public void modificaEventoButtonPressed(){
         eventoSelezionato = tabellaCercaEventoTableView.getSelectionModel().getSelectedItem();
        cambiaModalita(true);
    }

    @FXML public void okButtonPressed(){
        // Invia i dati al controller
        LocalDate data = dataCercaEventoDataPicker.getValue();
        LuogoEnum luogo = luogoEventoComboBox.getValue();

        ricercaEventoController.modificaEventoSelezionato(eventoSelezionato,data,luogo);
        cambiaModalita(false);
        // Riattiva gli altri buttoni
    }

    @FXML public void annullaCercaEventoButtonPressed(){}

    @FXML public void visualizzaDatiEventoButtonPressed(){
        eventoSelezionato = tabellaCercaEventoTableView.getSelectionModel().getSelectedItem();
        cambiaView.mostraFormVisualizzaEvento(eventoSelezionato);
    }

    private void cambiaModalita(boolean isDisable){
        luogoEventoComboBox.setValue(null);
        dataCercaEventoDataPicker.setValue(null);
        okButton.setDisable(!isDisable);
        cercaEventoButton.setDisable(isDisable);
        modificaEventoButton.setDisable(isDisable);
        eliminaEventoButton.setDisable(isDisable);
        annullaCercaEventoButton.setDisable(isDisable);
        tabellaCercaEventoTableView.setDisable(isDisable);
    }

    @Override public void update(Observable observerModel, Object lista ){
        List<Evento> list = (List<Evento>)lista;
        tabellaCercaEventoTableView.setItems(FXCollections.observableArrayList(list));
        colonnaLuogoEvento.setCellValueFactory(new PropertyValueFactory<Evento, LuogoEnum>("LuogoEvento"));
        colonnaNomeEvento.setCellValueFactory(new PropertyValueFactory<Evento, String>("Nome"));
        colonnaDataEvento.setCellValueFactory(new PropertyValueFactory<Evento, LocalDate>("DataEvento"));

    }

}
