package ControllerView;

import Controller.CambiaStage;
import Controller.CambiaView;
import Controller.ControlledStage;
import DB.GestoreQueryCerca;
import Model.Clienti;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.util.ResourceBundle;

public class CercaClientiControllerView implements ControlledStage, Initializable {

    @FXML
    private Button visualizzaDatiClientiButton;
    @FXML
    private TableView<Clienti> tabellaCercaClientiTableView;
    @FXML
    private TableColumn<Clienti , String> username;
   @FXML
    private TableColumn<Clienti , String> nome;
   @FXML
   private TableColumn<Clienti , String> cognome;
    @FXML
    private Button eliminaClientiButton;
    @FXML
    private Button annullaCercaClientiButton;
    @FXML
    private Button cercaClienteButton;
    @FXML
    private TextField usernameCercaClientiTextField;
    @FXML
    private AnchorPane cercaClientiPaneScreen;
    private CambiaView cambiaForm;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cambiaForm=new CambiaView(cercaClientiPaneScreen);



    }

    @Override
    public void setCambiaStage(CambiaStage cambiaStage) {
    }


    public void visualizzaDatiClientiButtonPressed(ActionEvent actionEvent) {
        cambiaForm.visualizzaPaneClienti();

    }
    public void annullaCercaClientiButtonPressed(){
        usernameCercaClientiTextField.clear();
        
    }

    public void cercaClienteButtonPressed() {
    }

    public void eliminaClientiButtonPressed() {
    }

    public Button getVisualizzaDatiClientiButton() {
        return visualizzaDatiClientiButton;
    }

    public TableView getTabellaCercaClientiTableView() {
        return tabellaCercaClientiTableView;
    }

    public Button getEliminaClientiButton() {
        return eliminaClientiButton;
    }

    public Button getAnnullaCercaClientiButton() {
        return annullaCercaClientiButton;
    }

    public Button getCercaClienteButton() {
        return cercaClienteButton;
    }

    public TextField getUsernameCercaClientiTextField() {
        return usernameCercaClientiTextField;
    }

    public AnchorPane getCercaClientiPaneScreen() {
        return cercaClientiPaneScreen;
    }
}
