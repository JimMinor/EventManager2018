package Scaffale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class inserisciDipendentePaneController implements Initializable {

    @FXML
    public TextField nomeDipendenteTextField;
    @FXML
    public TextField cognomeDipendenteTextField;
    @FXML
    public DatePicker dataNascitaDipendenteDatePicker;
    @FXML
    public TextField codFiscaleDipendenteTextField;
    @FXML
    public TextField indirizzoDipendenteTextField;
    @FXML
    public RadioButton sessoFDipendenteRatioButton;
    @FXML
    public RadioButton sessoMDipendenteRadioButton;
    @FXML
    public Button inserisciDipendenteButton;
    @FXML
    public RadioButton tipoContrattoFtimeDipendenteRatioButton;
    @FXML
    public RadioButton tipoContrattoPtimeDipendenteRatioButton;
    @FXML
    public DatePicker dataContrattoDipendenteDatePicker;
    @FXML
    public TextField stipendioDipendenteTextField;
    @FXML
    public TextField telefonoDipendenteTextField;
    @FXML
    public TextField emailDipendenteTextField;
    @FXML
    public TextField ibanDipendenteTextField;
    @FXML
    public Button annullaDipendenteButton;
    @FXML
    public ComboBox mansioneDipendenteComboBox;
    public AnchorPane formInserisciDipedente;
    public String operazione="pulisci";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mansioneDipendenteComboBox.setItems(list);



    }
    public void annullaDipendenteButtonPressed(ActionEvent actionEvent) {
        tastoAnnullaInserisciDipendenti(operazione);

    }
    //lista tipo evento
    ObservableList<String> list = FXCollections.observableArrayList("Amministratore","Operatore");
    public void tipoContrattoPtimeDipendenteRatioButtonPressed(ActionEvent actionEvent) {
        tipoContrattoFtimeDipendenteRatioButton.setSelected(false);
    }


    public TextField getStipendioDipendenteTextField() {
        return stipendioDipendenteTextField;
    }

    public TextField getNomeDipendenteTextField() {
        return nomeDipendenteTextField;
    }

    public TextField getCognomeDipendenteTextField() {
        return cognomeDipendenteTextField;
    }

    public TextField getCodFiscaleDipendenteTextField() {
        return codFiscaleDipendenteTextField;
    }

    public TextField getIndirizzoDipendenteTextField() {
        return indirizzoDipendenteTextField;
    }

    public RadioButton getSessoFDipendenteRatioButton() {
        return sessoFDipendenteRatioButton;
    }

    public RadioButton getSessoMDipendenteRadioButton() {
        return sessoMDipendenteRadioButton;
    }

    public Button getInserisciDipendenteButton() {
        return inserisciDipendenteButton;
    }

    public RadioButton getTipoContrattoFtimeDipendenteRatioButton() {
        return tipoContrattoFtimeDipendenteRatioButton;
    }

    public RadioButton getTipoContrattoPtimeDipendenteRatioButton() {
        return tipoContrattoPtimeDipendenteRatioButton;
    }

    public DatePicker getDataContrattoDipendenteDatePicker() {
        return dataContrattoDipendenteDatePicker;
    }

    public TextField getTelefonoDipendenteTextField() {
        return telefonoDipendenteTextField;
    }

    public TextField getEmailDipendenteTextField() {
        return emailDipendenteTextField;
    }

    public TextField getIbanDipendenteTextField() {
        return ibanDipendenteTextField;
    }

    public DatePicker getDataNascitaDipendenteDatePicker() {
        return dataNascitaDipendenteDatePicker;
    }

    public Button getAnnullaDipendenteButton() {
        return annullaDipendenteButton;
    }

    public ComboBox getMansioneDipendenteComboBox() {
        return mansioneDipendenteComboBox;
    }

    public AnchorPane getFormInserisciDipedente() {
        return formInserisciDipedente;
    }

    public String getOperazione() {
        return operazione;
    }

    public ObservableList<String> getList() {
        return list;
    }

    public void tastoAnnullaInserisciDipendenti(String operazione){
        if (operazione=="pulisci") {
            nomeDipendenteTextField.clear();
            cognomeDipendenteTextField.clear();
            codFiscaleDipendenteTextField.clear();
            indirizzoDipendenteTextField.clear();
            dataNascitaDipendenteDatePicker.setValue(null);
            dataContrattoDipendenteDatePicker.setValue(null);
            stipendioDipendenteTextField.clear();
            telefonoDipendenteTextField.clear();
            emailDipendenteTextField.clear();
            ibanDipendenteTextField.clear();
            sessoFDipendenteRatioButton.setSelected(false);
            sessoMDipendenteRadioButton.setSelected(false);
            tipoContrattoPtimeDipendenteRatioButton.setSelected(false);
            tipoContrattoFtimeDipendenteRatioButton.setSelected(false);
        }else {
          //  new CambiaView(formInserisciDipedente).caricaFormDaRisorsa(formInserisciDipedente, "cercaDipendentiPane.fxml");
        }
    }
}
