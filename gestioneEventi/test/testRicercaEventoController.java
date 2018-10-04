import Control.MenuPrincipaleController;
import Control.RicercaClienteController;
import Control.RicercaEventoController;
import Model.VisualizzaEventiModel;
import View.CercaEventoView;
import View.MenuPrincipaleView;
import javafx.scene.layout.AnchorPane;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

public class testRicercaEventoController extends TestCase {

    RicercaEventoController ricercaEventoController;
    @Before
    protected void setUp() throws Exception {
        super.setUp();
        MenuPrincipaleView viewMenu = new MenuPrincipaleView();
        AnchorPane pane = new AnchorPane();
        MenuPrincipaleController controllerMenu = new MenuPrincipaleController(pane,viewMenu);
        VisualizzaEventiModel model = new VisualizzaEventiModel();
        CercaEventoView view = new CercaEventoView(controllerMenu,model);
         ricercaEventoController = new RicercaEventoController(model,view,controllerMenu);
        assertNotNull(ricercaEventoController);


    }
    @After
    protected void tearDown() throws Exception {
        ricercaEventoController=null;
        assertNull(ricercaEventoController);
        super.tearDown();

    }



}
