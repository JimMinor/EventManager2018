package Scaffale;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class visualizzaClientiPaneController {
    public TextField usernameClienteTextField;
    public TextField nomeClienteTextField;
    public TextField cognomeClienteTextField;
    public TextField codFiscaleClienteTextField;
    public TextField indirizzoClienteTextField;
    public TextField emailClienteTextField;
    public RadioButton sessoFClienteRadioButton;
    public RadioButton sessoMClienteRadioButton;
    public Button fineClientiButton;
    public AnchorPane visualizzaClientiForm;

    public void sessoFClienteRadioButtonPressed(ActionEvent actionEvent) {
        sessoMClienteRadioButton.setSelected(false);
    }


    public void sessoMClienteRadioButtonPressed(ActionEvent actionEvent) {
        sessoFClienteRadioButton.setSelected(false);
    }

    public void fineClientiButtonPressed(ActionEvent actionEvent) {
      //  new FormController(visualizzaClientiForm).caricaFormDaRisorsa(visualizzaClientiForm, "cercaClientiPane.fxml");


    }

    public TextField getUsernameClienteTextField() {
        return usernameClienteTextField;
    }

    public TextField getNomeClienteTextField() {
        return nomeClienteTextField;
    }

    public TextField getCognomeClienteTextField() {
        return cognomeClienteTextField;
    }

    public TextField getCodFiscaleClienteTextField() {
        return codFiscaleClienteTextField;
    }

    public TextField getIndirizzoClienteTextField() {
        return indirizzoClienteTextField;
    }

    public TextField getEmailClienteTextField() {
        return emailClienteTextField;
    }

    public RadioButton getSessoFClienteRadioButton() {
        return sessoFClienteRadioButton;
    }

    public RadioButton getSessoMClienteRadioButton() {
        return sessoMClienteRadioButton;
    }

    public Button getFineClientiButton() {
        return fineClientiButton;
    }
}
