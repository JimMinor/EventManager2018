package Scaffale;

import Controller.CambiaView;
import Model.Evento;
import Model.LuogoEnum;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

import static Model.LuogoEnum.*;
import static Model.TipologiaEnum.*;


public class cercaEventoController {
    @FXML
    private Button modificaEventoButton;
    @FXML
    private Button eliminaEventoButton;
    @FXML
    private TableView<Evento> tabellaCercaEventoTableView;
    @FXML
    private TableColumn<Evento, String> colonnaNomeEvento;
    @FXML
    private TableColumn<Evento, String> colonnaLuogoEvento;
    @FXML
    private TableColumn<Evento, String> colonnaDataEvento;
    @FXML
    private Button cercaCercaEventoButton;
    @FXML
    private TextField nomeCercaEventoTextField;
    @FXML
    private Button annullaCercaEventoButton;
    @FXML
    private DatePicker dataCercaEventoDataPicker;
    @FXML
    private JFXComboBox luogoEventoComboBox;
    @FXML
    private AnchorPane cercaEventoPaneScreen;

    private ObservableList<Evento> eventiCercati = FXCollections.observableArrayList();

    public ComboBox<LuogoEnum> getLuogoEventoComboBox() {
        return luogoEventoComboBox;
    }
    public void initialize() {
        luogoEventoComboBox.setItems(FXCollections.observableArrayList(LuogoEnum.values()));
    }

    public void modificaEventoButtonPressed(ActionEvent actionEvent) {




    }

    public void cercaCercaEventoButtonPressed(ActionEvent actionEvent) {
        tabellaCercaEventoTableView.setItems(eventiCercati);
        //Qui va inserito il codice che, dopo aver fatto la query al database, crea gli oggetti evento da visualizzare nella tableview

        /////Codice Test - Inizio

        ////Codice Test - Fine

        mostraTabella();
    }

    public void annullaCercaEventoButtonPressed(ActionEvent actionEvent) {
        nomeCercaEventoTextField.clear();
        luogoEventoComboBox.setValue(null);
        dataCercaEventoDataPicker.setValue(null);

    }

    public void eliminaEventoButtonPressed(ActionEvent actionEvent) {
    }

    private void mostraTabella() {
        colonnaNomeEvento.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNome()));
        colonnaLuogoEvento.setCellValueFactory(
                cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getLuogoEvento()));
        colonnaDataEvento.setCellValueFactory(
                cellData -> new ReadOnlyObjectWrapper(cellData.getValue().getDataEvento()));
    }
}

