package View;

import Controller.EventoController;
import Controller.EventoSpecificoForm;
import Controller.NoValidEventDataException;
import Model.SportEnum;
import javafx.collections.FXCollections;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.HashSet;
import java.util.Set;

public class EventoSportivoForm implements EventoSpecificoForm {

    @FXML private ComboBox<SportEnum> sportEnumComboBox;
    @FXML private TextField partecipanteTextField;
    @FXML private Button inserisciPartecipanteButton;
    private Set<String> partecipanti;
    private EventoController controllaDati;

    public EventoSportivoForm(){}

    public EventoSportivoForm(EventoController controllaDati){
        this.controllaDati=controllaDati;
        partecipanti =new HashSet<>();

    }


    public void initialize(){
        sportEnumComboBox.setItems(FXCollections.observableArrayList(SportEnum.values()));

    }

    @Override public void inviaDatiEventoSpecifico() {
      try {
          controllaDati.controllaDatiEventoSportivo(this);
          } catch (NoValidEventDataException e) {
          MostraAlert.mostraAlertErroreInserimentoEvento(e.getMessagge());
          }
    }

    @Override public void pulisciForm(){
        partecipanteTextField.clear();
        sportEnumComboBox.setValue(null);
    }
    @FXML public void inserisciPartecipanteButtonPressed(){
        String partecipante = partecipanteTextField.getText();
        if(partecipante.equals("") || partecipante==null)
            MostraAlert.mostraAlertErroreInserimentoEvento("Campo Partecipante Vuoto!!!");
        else
        {
            partecipanti.add(partecipante);
            partecipanteTextField.clear();
        }
    }

    /** Getter */

    public ComboBox<SportEnum> getSportEnumComboBox() {
        return sportEnumComboBox;
    }

    public Set<String> getPartecipanti() {
        return partecipanti;
    }
}
