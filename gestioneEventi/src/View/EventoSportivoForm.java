package View;

import Controller.DatiEventoController;
import Controller.EventoSpecificoForm;
import Controller.NoValidEventDateException;
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
    private Set<String> partecipantiList;
    private DatiEventoController controllaDati;


    public EventoSportivoForm(){}

    public EventoSportivoForm(DatiEventoController controllaDati){
        this.controllaDati=controllaDati;
        partecipantiList=new HashSet<>();

    }

    public void initialize(){
        sportEnumComboBox.setItems(FXCollections.observableArrayList(SportEnum.values()));

    }


    @Override
    public void inviaDatiEventoSpecifico() {
      try {
          controllaDati.controllaDatiEventoSportivo(this);
          } catch (NoValidEventDateException e) {
          MostraAlert.mostraAlertErroreInserimentoEvento(e.getMessagge());
          }
    }

    @FXML
    public void inserisciPartecipanteButtonPressed(){
        String partecipante = partecipanteTextField.getText();
        if(partecipante.equals("") || partecipante==null)
            //TODO:Creare nuovo alert
            MostraAlert.mostraAlertLogin();
        else
        {
            partecipantiList.add(partecipante);
            partecipanteTextField.clear();
        }
    }

    /** Getter */

    public ComboBox<SportEnum> getSportEnumComboBox() {
        return sportEnumComboBox;
    }

    public Set<String> getPartecipantiList() {
        return partecipantiList;
    }
}
