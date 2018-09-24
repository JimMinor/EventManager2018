package View;
import Controller.EventoController;
import Controller.FormController;
import Model.Evento;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.util.Observable;
import java.util.Observer;

public class CercaEventoForm implements Observer {

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

    @Override
    public void update(Observable o, Object arg) {

    }
}
