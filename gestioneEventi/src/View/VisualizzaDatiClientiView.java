package View;

import Control.*;
import Model.Cliente;
import Model.VisualizzaClientiModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class VisualizzaDatiClientiView implements Observer {

    @FXML private JFXTextField usernameClienteTextField;
    @FXML private JFXTextField nomeClienteTextField;
    @FXML private JFXTextField cognomeClienteTextField;
    @FXML private JFXTextField codFiscaleClienteTextField;
    @FXML private JFXTextField spesaCartaClienteTextField;
    @FXML private JFXTextField emailClienteTextField;
    @FXML private JFXButton indietroClientiButton;
    @FXML private JFXTextField bigliettiAcquistatiTextField;
    @FXML private JFXTextField spesaTotaleClienteTextField;
    @FXML private JFXTextField passwordClienteTextField;
    @FXML private JFXDatePicker dataNascitaClienteDataPicker;
    //--------FIELDS--------------

    private VisualizzaClientiModel visualizzaClientiModel;


    public VisualizzaDatiClientiView( VisualizzaClientiModel visualizzaClientiModel){
        this.visualizzaClientiModel = visualizzaClientiModel;
        visualizzaClientiModel.addObserver(this);


    }
    public void initialize(){}


    public JFXTextField getUsernameClienteTextField() {
        return usernameClienteTextField;
    }

    public JFXTextField getNomeClienteTextField() {
        return nomeClienteTextField;
    }

    public JFXTextField getCognomeClienteTextField() {
        return cognomeClienteTextField;
    }

    public JFXTextField getCodFiscaleClienteTextField() {
        return codFiscaleClienteTextField;
    }

    public JFXTextField getSpesaCartaClienteTextField() {
        return spesaCartaClienteTextField;
    }

    public JFXTextField getEmailClienteTextField() {
        return emailClienteTextField;
    }

    public JFXTextField getBigliettiAcquistatiTextField() {
        return bigliettiAcquistatiTextField;
    }

    public JFXTextField getSpesaTotaleClienteTextField() {
        return spesaTotaleClienteTextField;
    }

    public JFXTextField getPasswordClienteTextField() {
        return passwordClienteTextField;
    }

    public JFXDatePicker getDataNascitaClienteDataPicker() {
        return dataNascitaClienteDataPicker;
    }

    public VisualizzaClientiModel getVisualizzaClientiModel() {
        return visualizzaClientiModel;
    }

    public void setAttributiCliente() {


    }


    public JFXButton getIndietroClientiButton() {
        return indietroClientiButton;
    }

    @Override
    public void update(Observable o, Object arg) {
        Cliente clienteDaVisualizzare = (Cliente) arg;
        setAttributiCliente();
    }
}
