package View;

import Control.RicercaClienteController;
import Control.*;
import Model.Cliente;
import Model.VisualizzaClientiModel;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.util.Observer;

import java.util.List;
import java.util.Observable;

public class CercaClientiView implements Observer {

    //----------------TABELLA-------------
    @FXML private TableView<Cliente> tabellaCercaClientiTableView;
    @FXML private TableColumn<Cliente, String> colonnausername;
    @FXML private TableColumn<Cliente, String> colonnanome;
    @FXML private TableColumn<Cliente, String> colonnacognome;
    //--------------BOTTONI-----------------
    @FXML private Button visualizzaDatiClientiButton;
    @FXML private Button eliminaClientiButton;
    @FXML private Button annullaCercaClientiButton;
    @FXML private Button cercaClienteButton;
    //-----------DATA fIELDS------------------
    @FXML private TextField usernameCercaClientiTextField;
    @FXML private AnchorPane cercaClientiPaneScreen;
    //-----------UTILITY--------------
    private MenuPrincipaleView menuPrincipaleView;
    private RicercaClienteController ricercaController;
    private VisualizzaClientiModel visualizzaclientiModel;
    private Cliente cliente;

    public CercaClientiView(VisualizzaClientiModel visualizzaclientiModel) {
        this.visualizzaclientiModel = visualizzaclientiModel;
        visualizzaclientiModel.addObserver(this);
    }

    public void initialize() {


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

    @Override
    public void update(Observable observableModel,Object lista){
        List<Cliente> list = (List<Cliente>) lista;
        tabellaCercaClientiTableView.setItems(FXCollections.observableArrayList(list));
        colonnacognome.setCellValueFactory(new PropertyValueFactory<Cliente,String>("Cognome"));
        colonnanome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Nome"));
        colonnausername.setCellValueFactory(new PropertyValueFactory<Cliente,String>("Username"));
    }
}