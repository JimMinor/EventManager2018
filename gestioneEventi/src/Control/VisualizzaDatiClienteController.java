package Control;

import Model.Cliente;
import Model.VisualizzaClientiModel;
import View.VisualizzaDatiClientiView;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class VisualizzaDatiClienteController {

    private VisualizzaDatiClientiView visualizzaDatiClientiView;
    private VisualizzaClientiModel visualizzaClientiModel;
    private MenuPrincipaleController menuPrincipaleController;

    public VisualizzaDatiClienteController(VisualizzaDatiClientiView visualizzaDatiClientiView, VisualizzaClientiModel visualizzaClientiModel, MenuPrincipaleController menuPrincipaleController) {
        this.visualizzaDatiClientiView = visualizzaDatiClientiView;
        this.visualizzaClientiModel = visualizzaClientiModel;
        this.menuPrincipaleController = menuPrincipaleController;
        this.visualizzaClientiModel.setClienteSelezionato(visualizzaClientiModel.getClienteSelezionato());//forzo l'update della vista
        setListenerVisualizzaCliente();
        setAttributiCliente();
    }

    private void setAttributiCliente() {
        Cliente clienteDaVisualizzare = visualizzaClientiModel.getClienteSelezionato();
        visualizzaDatiClientiView.getUsernameClienteTextField().setText(clienteDaVisualizzare.getUsername());
        visualizzaDatiClientiView.getUsernameClienteTextField().setDisable(true);
        visualizzaDatiClientiView.getNomeClienteTextField().setText(clienteDaVisualizzare.getNome());
        visualizzaDatiClientiView.getNomeClienteTextField().setDisable(true);
        visualizzaDatiClientiView.getCognomeClienteTextField().setText(clienteDaVisualizzare.getCognome());
        visualizzaDatiClientiView.getCognomeClienteTextField().setDisable(true);
        visualizzaDatiClientiView.getCodFiscaleClienteTextField().setText(clienteDaVisualizzare.getCF());
        visualizzaDatiClientiView.getCodFiscaleClienteTextField().setDisable(true);
        visualizzaDatiClientiView.getSpesaCartaClienteTextField().setText(String.valueOf(clienteDaVisualizzare.getSpesaCarta()));
        visualizzaDatiClientiView.getSpesaCartaClienteTextField().setDisable(true);
        visualizzaDatiClientiView.getSpesaTotaleClienteTextField().setText(String.valueOf(clienteDaVisualizzare.getSpesaTot()));
        visualizzaDatiClientiView.getSpesaTotaleClienteTextField().setDisable(true);
        visualizzaDatiClientiView.getEmailClienteTextField().setText(clienteDaVisualizzare.getMail());
        visualizzaDatiClientiView.getEmailClienteTextField().setDisable(true);
        visualizzaDatiClientiView.getBigliettiAcquistatiTextField().setText(String.valueOf(clienteDaVisualizzare.getNumBiglietti()));
        visualizzaDatiClientiView.getBigliettiAcquistatiTextField().setDisable(true);
        //visualizzaDatiClientiView.passwordClienteTextField.setText(clienteDaVisualizzare.getPassword());
        //visualizzaDatiClientiView.passwordClienteTextField.setDisable(true);
        visualizzaDatiClientiView.getDataNascitaClienteDataPicker().setValue(clienteDaVisualizzare.getDataNascita());
        visualizzaDatiClientiView.getDataNascitaClienteDataPicker().setDisable(true);
    }

    private void setListenerVisualizzaCliente(){
        setListenerIndietroButton();
    }

    private void setListenerIndietroButton() {
        visualizzaDatiClientiView.getIndietroClientiButton().addEventHandler(
                ActionEvent.ACTION, event->{
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            menuPrincipaleController.mostraFormGestioneClienti();
                        }
                    });
                }
        );

    }
}
