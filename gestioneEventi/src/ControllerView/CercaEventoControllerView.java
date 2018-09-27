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
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CercaEventoControllerView implements Observer {

    //FXML Fields------------------------------
    @FXML private Button modificaEventoButton;
    @FXML private Button eliminaEventoButton;
    @FXML private TableView<Evento> tabellaCercaEventoTableView;
    @FXML private TableColumn<Evento, String> colonnaNomeEvento;
    @FXML private TableColumn<Evento, String> colonnaLuogoEvento;
    @FXML private TableColumn<Evento, String> colonnaDataEvento;
    @FXML private Button cercaEventoButton;
    @FXML private TextField nomeCercaEventoTextField;
    @FXML private Button annullaCercaEventoButton;
    @FXML private DatePicker dataCercaEventoDataPicker;
    @FXML private ComboBox<LuogoEnum> luogoEventoComboBox;
    @FXML private AnchorPane cercaEventoPaneScreen;
    @FXML private Button okButton;
    // Utilites e Altri Fields---------------------
    private CambiaView cambiaView;
    private VisualizzaEventiModel eventiModel;
    private RicercaEventoController ricercaEventoController;

    /** Metodi per l'inizializzazione della classe */

    public CercaEventoControllerView(CambiaView cambiaView, VisualizzaEventiModel eventiModel) {
        this.cambiaView = cambiaView;
        this.eventiModel = eventiModel;
        ricercaEventoController = new RicercaEventoController(eventiModel,this);
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
        ricercaEventoController.eliminaEventoSelezionato(tabellaCercaEventoTableView.getSelectionModel().getSelectedItem());
    }

    @FXML public void modificaEventoButtonPressed(){
        cambiaModalita(true);
    }

    @FXML public void okButtonPressed(){
        // Invia i dati al controller
        LocalDate data = dataCercaEventoDataPicker.getValue();
        LuogoEnum luogo = luogoEventoComboBox.getValue();
        Evento evento = tabellaCercaEventoTableView.getSelectionModel().getSelectedItem();
        ricercaEventoController.modificaEventoSelezionato(evento,data,luogo);
        cambiaModalita(false);
        // Riattiva gli altri buttoni
    }

    @FXML public void annullaCercaEventoButtonPressed(){}

    private void cambiaModalita(boolean isDisable){
        luogoEventoComboBox.setValue(null);
        dataCercaEventoDataPicker.setValue(null);
        okButton.setDisable(!isDisable);
        cercaEventoButton.setDisable(isDisable);
        modificaEventoButton.setDisable(isDisable);
        eliminaEventoButton.setDisable(isDisable);
        annullaCercaEventoButton.setDisable(isDisable);
    }

    @Override
    public void update(Observable observerModel, Object lista ){
        List<Evento> list = (List<Evento>)lista;
        tabellaCercaEventoTableView.setItems(FXCollections.observableArrayList(list));
    }

}
