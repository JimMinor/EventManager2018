package ControllerView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class VisualizzaClientiControllerView {
   @FXML public TextField usernameClienteTextField;
   @FXML public TextField nomeClienteTextField;
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
