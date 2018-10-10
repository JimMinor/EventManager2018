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
        visualizzaDatiClientiView.getUsernameClienteTextField().setEditable(false);
        visualizzaDatiClientiView.getNomeClienteTextField().setText(clienteDaVisualizzare.getNome());
        visualizzaDatiClientiView.getNomeClienteTextField().setEditable(false);
        visualizzaDatiClientiView.getCognomeClienteTextField().setText(clienteDaVisualizzare.getCognome());
        visualizzaDatiClientiView.getCognomeClienteTextField().setEditable(false);
        visualizzaDatiClientiView.getCodFiscaleClienteTextField().setText(clienteDaVisualizzare.getCF());
        visualizzaDatiClientiView.getCodFiscaleClienteTextField().setEditable(false);
        visualizzaDatiClientiView.getSpesaCartaClienteTextField().setText(String.valueOf(clienteDaVisualizzare.getSpesaCarta()));
        visualizzaDatiClientiView.getSpesaCartaClienteTextField().setEditable(false);
        visualizzaDatiClientiView.getSpesaTotaleClienteTextField().setText(String.valueOf(clienteDaVisualizzare.getSpesaTot()));
        visualizzaDatiClientiView.getSpesaTotaleClienteTextField().setEditable(false);
        visualizzaDatiClientiView.getEmailClienteTextField().setText(clienteDaVisualizzare.getMail());
        visualizzaDatiClientiView.getEmailClienteTextField().setEditable(false);
        visualizzaDatiClientiView.getBigliettiAcquistatiTextField().setText(String.valueOf(clienteDaVisualizzare.getNumBiglietti()));
        visualizzaDatiClientiView.getBigliettiAcquistatiTextField().setEditable(false);
        visualizzaDatiClientiView.getDataNascitaClienteDataPicker().setValue(clienteDaVisualizzare.getDataNascita());
        visualizzaDatiClientiView.getDataNascitaClienteDataPicker().setEditable(false);
        visualizzaDatiClientiView.getPasswordClienteTextField().setText(clienteDaVisualizzare.getPassword());
        visualizzaDatiClientiView.getPasswordClienteTextField().setEditable(false);
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
