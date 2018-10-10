package View;



import Model.Cliente;
import Model.Addetto;
import Model.VisualizzaAddettiModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class VisualizzaAddettoView {

    @FXML private JFXTextField nomeAddettoTextField;
    @FXML private JFXTextField cognomeAddettoTextField;
    @FXML private JFXDatePicker dataNascitaAddettoDataPicker;
    @FXML private JFXTextField codFiscaleAddettoTextField;
    @FXML private JFXTextField telefonoAddettoTextField;
    @FXML private JFXTextField emailAddettoTextField;
    @FXML private JFXTextField ibanAddettoTextField;
    @FXML private JFXTextField stipendioAddettoTextField;
    @FXML private JFXButton indietroButton;
    @FXML private AnchorPane formVisualizzaAddetto;
    private VisualizzaAddettiModel visualizzaAddettiModel;

    public VisualizzaAddettoView(VisualizzaAddettiModel visualizzaAddettiModel) {
        this.visualizzaAddettiModel = visualizzaAddettiModel;
    }

    public void initialize() {

    }

    public JFXTextField getNomeAddettoTextField() {
        return nomeAddettoTextField;
    }

    public JFXTextField getCognomeAddettoTextField() {
        return cognomeAddettoTextField;
    }

    public JFXDatePicker getDataNascitaAddettoDataPicker() {
        return dataNascitaAddettoDataPicker;
    }

    public JFXTextField getCodFiscaleAddettoTextField() {
        return codFiscaleAddettoTextField;
    }

    public JFXTextField getTelefonoAddettoTextField() {
        return telefonoAddettoTextField;
    }

    public JFXTextField getEmailAddettoTextField() {
        return emailAddettoTextField;
    }

    public JFXTextField getIbanAddettoTextField() {
        return ibanAddettoTextField;
    }

    public JFXTextField getStipendioAddettoTextField() {
        return stipendioAddettoTextField;
    }

    public JFXButton getIndietroButton() {
        return indietroButton;
    }

    public AnchorPane getFormVisualizzaAddetto() {
        return formVisualizzaAddetto;
    }

}