package View;
import Controller.EventoController;
import Controller.FormController;
import Model.Evento;
import javafx.fxml.*;
import javafx.scene.control.*;

public class CercaEventoForm {

    @FXML
    private TextField nomeEventoTextField;
    @FXML
    private TextField luogoEventoTextField;
    @FXML
    private DatePicker dataEventoDatePicker;
    @FXML
    private TableView<? extends Evento> eventiTableView;
    private EventoController eventoController;
    private FormController formController;

    public CercaEventoForm(FormController formController) { this.formController = formController; }

    @FXML public void cercaEventiButtonPressed(){}
    @FXML public void eliminaEventoButtonPressed(){}

}
