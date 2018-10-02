package ControllerView;

import Controller.CambiaView;
import ControllerView.MenuPrincipaleStage;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class cercaDipendentiPaneController {
    @FXML private AnchorPane cercaDipendentiScreenAnchorPane;
    @FXML private Button modificaDipendenteButton;
    @FXML private Button eliminaDipendentiButton;
    @FXML private TableView tabellaCercaDipendenteTableView;
    @FXML private Button cercaCercaDipendenteButton;
    @FXML private TextField nomeCercaDipendenteTextField;
    @FXML private TextField cognomeCercaDipendenteTextField;
    @FXML private DatePicker dataNascitaCercaDipendenteDataPicker;
    @FXML private Button annullaCercaDipendenteButton;
    @FXML private Button nuovoDipendenteButton;

    private CambiaView creaFormNuovoDipendente;


    public cercaDipendentiPaneController(CambiaView cambiaView) {
        this.creaFormNuovoDipendente = cambiaView;
    }

    public void modificaDipendenteButtonPressed(ActionEvent actionEvent) {
        
    }

    public void eliminaDipendentiButton(ActionEvent actionEvent) {
    }

    public void cercaCercaDipendenteButton(ActionEvent actionEvent) {
    }

    public void annullaCercaDipendenteButtonPressed(ActionEvent actionEvent) {
        nomeCercaDipendenteTextField.clear();
        cognomeCercaDipendenteTextField.clear();
        dataNascitaCercaDipendenteDataPicker.setValue(null);
    }

    public void nuovoDipendenteButtonPressed(ActionEvent actionEvent) {
        creaFormNuovoDipendente.mostraFormNuovoDipendente();
    }
}
