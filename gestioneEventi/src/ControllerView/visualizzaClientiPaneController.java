package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
<<<<<<< HEAD:gestioneEventi/src/Scaffale/visualizzaClientiPaneController.java
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
      //  new CambiaView(visualizzaClientiForm).caricaFormDaRisorsa(visualizzaClientiForm, "cercaClientiPane.fxml");


    }
=======
>>>>>>> 23f06ea01ecbcd7587c88faf7d1872d73a751931:gestioneEventi/src/ControllerView/visualizzaClientiPaneController.java

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

    public AnchorPane getVisualizzaClientiForm() {
        return visualizzaClientiForm;
    }

    public JFXButton getFineClientiButton() {
        return fineClientiButton;
    }

    public JFXTextField getBigliettiAcquistatiTextField() {
        return bigliettiAcquistatiTextField;
    }

    public JFXTextField getSpesaTotaleTextField() {
        return spesaTotaleTextField;
    }

    public RadioButton sessoMClienteRadioButton;
    public AnchorPane visualizzaClientiForm;
    public JFXButton fineClientiButton;
    public JFXTextField bigliettiAcquistatiTextField;
    public JFXTextField spesaTotaleTextField;

    public void sessoFClienteRadioButtonPressed(ActionEvent actionEvent) {
        sessoMClienteRadioButton.setSelected(false);
    }


    public void sessoMClienteRadioButtonPressed(ActionEvent actionEvent) {
        sessoFClienteRadioButton.setSelected(false);
    }


}
