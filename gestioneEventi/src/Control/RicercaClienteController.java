package Control;

import DB.ClienteDAOImp;
import DB.ClientiDAO;
import Model.Cliente;
import Model.VisualizzaClientiModel;
import View.CercaClientiView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class RicercaClienteController {

    private VisualizzaClientiModel visualizzaclientiModel;
    private CercaClientiView cercaClientiView;
    private ClientiDAO clientiDAO ;
    private MenuPrincipaleController menuPrincipaleController;

    public RicercaClienteController(VisualizzaClientiModel cercaClientiModel1, CercaClientiView cercaClientiView,
                                    MenuPrincipaleController menuPrincipaleController){
        this.visualizzaclientiModel = cercaClientiModel1;
        this.cercaClientiView = cercaClientiView;
        this.menuPrincipaleController = menuPrincipaleController;
        this.clientiDAO =  new ClienteDAOImp();
        setListenerCercaClienti();
    }

    /** Set Listener per la classe CercaClientiView */
    private void setListenerCercaClienti(){
        setListenerVisualizzaDatiButton();
        setListenerAnnullaButton();
        setListenerCercaButton();
        setListenerEliminaButton();
    }

    private void setListenerVisualizzaDatiButton() {
        cercaClientiView.getVisualizzaDatiClientiButton()
                .addEventHandler(ActionEvent.ACTION, event -> Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Cliente cliente = (Cliente)cercaClientiView.getTabellaCercaClientiTableView()
                        .getSelectionModel().getSelectedItem();
                if(cliente!=null) {
                    visualizzaclientiModel.setClienteSelezionato(cliente);
                    menuPrincipaleController.visualizzaPaneClienti(visualizzaclientiModel);
                }
            }
        }));
    }

    private void setListenerAnnullaButton() {
        cercaClientiView.getAnnullaCercaClientiButton()
                .addEventHandler(ActionEvent.ACTION, event -> Platform.runLater(new Runnable() {
            @Override
            public void run() {
                cercaClientiView.getUsernameCercaClientiTextField().clear();
            }
        }));
    }

    private void setListenerCercaButton(){
        cercaClientiView.getCercaClienteButton()
                .addEventHandler(ActionEvent.ACTION, event -> Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("cerca");
                        cercaCliente(cercaClientiView.getUsernameCercaClientiTextField().getText());
                    }
                }));
    }

    private void setListenerEliminaButton(){
        cercaClientiView.getEliminaClientiButton().
                addEventHandler(ActionEvent.ACTION, event -> Platform.runLater((new Runnable() {
                    @Override
                    public void run() {
                        Cliente clienteSelezionato = (Cliente)cercaClientiView.getTabellaCercaClientiTableView()
                                .getSelectionModel().getSelectedItem();
                        visualizzaclientiModel.setClienteSelezionato(clienteSelezionato);
                        eliminClienteSelezionato(clienteSelezionato);
                        visualizzaclientiModel.setClienteSelezionato(new Cliente());
                    }
                })));
    }

    public void eliminClienteSelezionato (Cliente clienteSelezionato){

        try {
            if(clienteSelezionato!=null) {
                clientiDAO.eliminaCliente(clienteSelezionato);
                visualizzaclientiModel.setListaClientiView(((ClienteDAOImp) clientiDAO).cercaCliente());

            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void cercaCliente(String username){
        try{
            visualizzaclientiModel.setListaClientiView(((ClienteDAOImp) clientiDAO).cercaCliente(username));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



}

