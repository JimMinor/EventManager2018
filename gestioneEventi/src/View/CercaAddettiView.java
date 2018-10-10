package View;

import Control.RicercaAddettoController;
import Model.Addetto;
import Model.VisualizzaAddettiModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CercaAddettiView implements Observer {

    @FXML private AnchorPane cercaAddettiScreenAnchorPane;
    @FXML private Button visualizzaAddettoButton;
    @FXML private Button eliminaAddettiButton;
    @FXML private TableView<Addetto> tabellaCercaAddettoTableView;
    @FXML private TableColumn<Addetto, String> colonnaNomeAddetto;
    @FXML private TableColumn<Addetto, String> colonnaCognomeAddetto;
    @FXML private TableColumn<Addetto, String> colonnaCFAddetto;
    @FXML private Button cercaAddettoButton;
    @FXML private TextField nomeCercaAddettoTextField;
    @FXML private TextField cognomeCercaAddettoTextField;
    @FXML private DatePicker dataNascitaCercaAddettoDataPicker;
    @FXML private Button annullaCercaAddettoButton;
    @FXML private Button nuovoAddettoButton;
    private RicercaAddettoController ricercaAddettoController;
    private VisualizzaAddettiModel addettiModel;

    public CercaAddettiView(VisualizzaAddettiModel addettiModel) {
        this.addettiModel = addettiModel;
        addettiModel.addObserver(this);
    }

    public void initialize(){}

    public AnchorPane getCercaAddettiScreenAnchorPane() {
        return cercaAddettiScreenAnchorPane;
    }

    public Button getVisualizzaAddettoButton() {
        return visualizzaAddettoButton;
    }

    public Button getEliminaAddettiButton() {
        return eliminaAddettiButton;
    }

    public TableView<Addetto> getTabellaCercaAddettoTableView() {
        return tabellaCercaAddettoTableView;
    }

    public TableColumn<Addetto, String> getColonnaNomeAddetto() {
        return colonnaNomeAddetto;
    }

    public TableColumn<Addetto, String> getColonnaCognomeAddetto() {
        return colonnaCognomeAddetto;
    }

    public TableColumn<Addetto, String> getColonnaCFAddetto() {
        return colonnaCFAddetto;
    }

    public Button getCercaAddettoButton() {
        return cercaAddettoButton;
    }

    public TextField getNomeCercaAddettoTextField() {
        return nomeCercaAddettoTextField;
    }

    public TextField getCognomeCercaAddettoTextField() {
        return cognomeCercaAddettoTextField;
    }

    public DatePicker getDataNascitaCercaAddettoDataPicker() {
        return dataNascitaCercaAddettoDataPicker;
    }

    public Button getAnnullaCercaAddettoButton() {
        return annullaCercaAddettoButton;
    }

    public Button getNuovoAddettoButton() {
        return nuovoAddettoButton;
    }

    @Override public void update(Observable observerModel, Object lista ){
        List<Addetto> list = (List<Addetto>)lista;
        tabellaCercaAddettoTableView.setItems(FXCollections.observableArrayList(list));
        colonnaNomeAddetto.setCellValueFactory(new PropertyValueFactory<Addetto, String>("nome"));
        colonnaCognomeAddetto.setCellValueFactory(new PropertyValueFactory<Addetto, String>("cognome"));
        colonnaCFAddetto.setCellValueFactory(new PropertyValueFactory<Addetto, String>("CF"));

    }


}
