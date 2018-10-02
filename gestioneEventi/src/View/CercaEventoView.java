package View;
import Controller.CambiaView;
import Controller.RicercaEventoController;
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

public class CercaEventoView  extends AnchorPane implements Observer {

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

    public CercaEventoView(CambiaView cambiaView, VisualizzaEventiModel eventiModel) {
        this.cambiaView = cambiaView;
        this.eventiModel = eventiModel;
        eventiModel.addObserver(this);
    }

    public void initialize() {

        luogoEventoComboBox.setItems(FXCollections.observableArrayList(LuogoEnum.values()));

    }



    /** Metodi FXML per gli eventi */



    public Button getModificaEventoButton() {
        return modificaEventoButton;
    }

    public Button getEliminaEventoButton() {
        return eliminaEventoButton;
    }

    public Button getCercaEventoButton() {
        return cercaEventoButton;
    }

    public Button getAnnullaCercaEventoButton() {
        return annullaCercaEventoButton;
    }

    public Button getOkButton() {
        return okButton;
    }

    public Button getVisualizzaDatiEventoButton() {
        return visualizzaDatiEventoButton;
    }

    public TableView<Evento> getTabellaCercaEventoTableView() {
        return tabellaCercaEventoTableView;
    }

    public TableColumn<Evento, String> getColonnaNomeEvento() {
        return colonnaNomeEvento;
    }

    public TableColumn<Evento, LuogoEnum> getColonnaLuogoEvento() {
        return colonnaLuogoEvento;
    }

    public TableColumn<Evento, LocalDate> getColonnaDataEvento() {
        return colonnaDataEvento;
    }

    public TextField getNomeCercaEventoTextField() {
        return nomeCercaEventoTextField;
    }

    public DatePicker getDataCercaEventoDataPicker() {
        return dataCercaEventoDataPicker;
    }

    public ComboBox<LuogoEnum> getLuogoEventoComboBox() {
        return luogoEventoComboBox;
    }

    public AnchorPane getCercaEventoPaneScreen() {
        return cercaEventoPaneScreen;
    }

    public CambiaView getCambiaView() {
        return cambiaView;
    }

    public VisualizzaEventiModel getEventiModel() {
        return eventiModel;
    }

    public RicercaEventoController getRicercaEventoController() {
        return ricercaEventoController;
    }

    public Evento getEventoSelezionato() {
        return eventoSelezionato;
    }

    /**    GETTERS  */

    @Override public void update(Observable observerModel, Object lista ){

        List<Evento> list = (List<Evento>)lista;
        tabellaCercaEventoTableView.setItems(FXCollections.observableArrayList(list));
        colonnaLuogoEvento.setCellValueFactory(new PropertyValueFactory<Evento, LuogoEnum>("LuogoEvento"));
        colonnaNomeEvento.setCellValueFactory(new PropertyValueFactory<Evento, String>("Nome"));
        colonnaDataEvento.setCellValueFactory(new PropertyValueFactory<Evento, LocalDate>("DataEvento"));

    }

}
