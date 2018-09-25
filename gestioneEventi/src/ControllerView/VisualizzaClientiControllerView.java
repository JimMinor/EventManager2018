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

   @FXML
    private TextField usernameClienteTextField;
  @FXML
   private TextField nomeClienteTextField;
   @FXML
    private TextField cognomeClienteTextField;
   @FXML
   private TextField codFiscaleClienteTextField;
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
