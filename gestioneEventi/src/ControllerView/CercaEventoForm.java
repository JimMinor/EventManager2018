package ControllerView;
import Controller.CambiaView;
import Model.Evento;
import javafx.fxml.*;
import javafx.scene.control.*;

public class CercaEventoForm {

    @FXML private TextField nomeEventoTextField;
    @FXML private TextField luogoEventoTextField;
    @FXML private DatePicker dataEventoDatePicker;
    @FXML private TableView<? extends Evento> eventiTableView;
    private CambiaView cambiaView;

    public CercaEventoForm(CambiaView cambiaView) { this.cambiaView = cambiaView; }

    @FXML public void cercaEventiButtonPressed(){}
    @FXML public void eliminaEventoButtonPressed(){}

}
