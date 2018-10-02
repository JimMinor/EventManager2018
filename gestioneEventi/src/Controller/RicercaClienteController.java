package Controller;


import ControllerView.CercaClientiControllerView;
import DB.ClienteDAOImp;
import DB.ClientiDAO;
import Model.Cliente;
import Model.VisualizzaClientiModel;

import java.sql.SQLException;


public class RicercaClienteController {

    private VisualizzaclientiModel visualizzaclientiModel;
   private ClientiDAO clientiDAO=new ClienteDAOImp();

    public RicercaClienteController(VisualizzaclientiModel cercaClientiModel1){
            this.visualizzaclientiModel = cercaClientiModel1;


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
