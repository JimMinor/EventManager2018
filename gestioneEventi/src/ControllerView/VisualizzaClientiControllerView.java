package ControllerView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class VisualizzaClientiControllerView {
<<<<<<< HEAD
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
    public JFXTextField bigliettiAcquistatiTextField;
    public JFXTextField spesaTotaleTextField;
=======
   @FXML
    private TextField usernameClienteTextField;
  @FXML
   private TextField nomeClienteTextField;
   @FXML
    private TextField cognomeClienteTextField;
   @FXML
   private TextField codFiscaleClienteTextField;

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

    public AnchorPane getVisualizzaClientiForm() {
        return visualizzaClientiForm;
    }

    public JFXTextField getBigliettiAcquistatiTextField() {
        return bigliettiAcquistatiTextField;
    }

    public JFXTextField getSpesaTotaleTextField() {
        return spesaTotaleTextField;
    }

    @FXML
   private TextField indirizzoClienteTextField;
   @FXML
   private TextField emailClienteTextField;
   @FXML
   private RadioButton sessoFClienteRadioButton;
   @FXML
   private RadioButton sessoMClienteRadioButton;
   @FXML
   private Button fineClientiButton;
   @FXML
   private AnchorPane visualizzaClientiForm;
   @FXML
   private JFXTextField bigliettiAcquistatiTextField;
   @FXML
   private JFXTextField spesaTotaleTextField;
>>>>>>> 3bfba6ab623b3c912a45863a57135903ee83e7f4


    public void sessoFClienteRadioButtonPressed(ActionEvent actionEvent) {
        sessoMClienteRadioButton.setSelected(false);
    }


    public void sessoMClienteRadioButtonPressed(ActionEvent actionEvent) {
        sessoFClienteRadioButton.setSelected(false);
    }

    public void fineClientiButtonPressed(ActionEvent actionEvent) {
      //  new CambiaView(visualizzaClientiForm).caricaFormDaRisorsa(visualizzaClientiForm, "cercaClientiPane.fxml");


    }





}
