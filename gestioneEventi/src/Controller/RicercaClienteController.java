package Controller;


import ControllerView.CercaClientiControllerView;
import DB.ClienteDAOImp;
import DB.ClientiDAO;
import Model.Cliente;
import Model.VisualizzaclientiModel;


public class RicercaClienteController {

    private VisualizzaclientiModel visualizzaclientiModel;
    private CercaClientiControllerView cercaClientiControllerView;

    public RicercaClienteController(VisualizzaclientiModel cercaClientiModel1,
                                    CercaClientiControllerView cercaClientiControllerView){
        this.visualizzaclientiModel =cercaClientiModel1;
        this.cercaClientiControllerView=cercaClientiControllerView;

    }

    public boolean eliminClienteSelezionato (Cliente clienteSelezionato){
        ClientiDAO clientiDAO = new ClienteDAOImp();
        try {
            return clientiDAO.eliminaCliente();
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }



    public void cercaCliente(String username){
        ClientiDAO clientiDAO = new ClienteDAOImp();
        visualizzaclientiModel.setListaClientiView(((ClienteDAOImp) clientiDAO).cercaCliente(username));
    }


}
