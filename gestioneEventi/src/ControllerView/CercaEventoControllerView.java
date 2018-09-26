package ControllerView;
import Controller.CambiaView;
import Controller.RicercaEventoController;
import Model.VisualizzaEventiModel;
import Model.Evento;
import Model.LuogoEnum;
import javafx.collections.FXCollections;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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
    @FXML private Button cercaCercaEventoButton;
    @FXML private TextField nomeCercaEventoTextField;
    @FXML private Button annullaCercaEventoButton;
    @FXML private DatePicker dataCercaEventoDataPicker;
    @FXML private ComboBox<LuogoEnum> luogoEventoComboBox;
    @FXML private AnchorPane cercaEventoPaneScreen;
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
    @FXML public void cercaEventiButtonPressed(){
        ricercaEventoController.cercaEventi();
    }
    @FXML public void eliminaEventoButtonPressed(){
        ricercaEventoController.eliminaEventoSelezionato(tabellaCercaEventoTableView.getSelectionModel().getSelectedItem());
    }

    @Override
    public void update(Observable observerModel, Object lista ){
        tabellaCercaEventoTableView.setItems(FXCollections.observableArrayList((List<Evento>)lista));
    }

}
