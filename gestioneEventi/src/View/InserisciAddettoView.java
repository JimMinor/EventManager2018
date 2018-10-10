package View;

import DB.AddettoDAO;
import DB.AddettoDAOImp;
import Model.Addetto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import Control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;



public class InserisciAddettoView {

    @FXML private AnchorPane formInserisciAddetto;
    @FXML private TextField nomeAddettoTextField;
    @FXML private TextField cognomeAddettoTextField;
    @FXML private DatePicker dataNascitaAddettoDatePicker;
    @FXML private TextField codFiscaleAddettoTextField;
    @FXML private Button inserisciAddettoButton;
    @FXML private TextField stipendioAddettoTextField;
    @FXML private TextField telefonoAddettoTextField;
    @FXML private TextField emailAddettoTextField;
    @FXML private TextField ibanAddettoTextField;
    @FXML private Button annullaAddettoButton;
    //lista mansioni
    ObservableList<String> list = FXCollections.observableArrayList("Amministratore","Operatore");

    public InserisciAddettoView(){
    }


    public ObservableList<String> getList() {
        return list;
    }


    public AnchorPane getFormInserisciAddetto() {
        return formInserisciAddetto;
    }

    public TextField getNomeAddettoTextField() {
        return nomeAddettoTextField;
    }

    public TextField getCognomeAddettoTextField() {
        return cognomeAddettoTextField;
    }

    public DatePicker getDataNascitaAddettoDatePicker() {
        return dataNascitaAddettoDatePicker;
    }

    public TextField getCodFiscaleAddettoTextField() {
        return codFiscaleAddettoTextField;
    }

    public Button getInserisciAddettoButton() {
        return inserisciAddettoButton;
    }

    public TextField getStipendioAddettoTextField() {
        return stipendioAddettoTextField;
    }

    public TextField getTelefonoAddettoTextField() {
        return telefonoAddettoTextField;
    }

    public TextField getEmailAddettoTextField() {
        return emailAddettoTextField;
    }

    public TextField getIbanAddettoTextField() {
        return ibanAddettoTextField;
    }

    public Button getAnnullaAddettoButton() {
        return annullaAddettoButton;
    }

    public void initialize() {}
}

