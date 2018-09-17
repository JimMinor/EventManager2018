package View;

import Controller.EventoController;
import Controller.EventoSpecificoForm;
import Controller.NoValidEventDataException;
import javafx.collections.FXCollections;
import javafx.scene.control.*;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javafx.fxml.*;


public class EventoArtisticoForm<T extends Enum<T>> implements EventoSpecificoForm {

    @FXML private ComboBox<T> genereSpettacoloComboBox;
    @FXML private TextField artistaTextField;
    @FXML private Button inserisciArtistaButton;
    private EventoController eventoController;
    private Set<String> artisti;
    private Class<T> enumClass;


    public EventoArtisticoForm(EventoController eventoController, Class<T> enumClass){
        this.eventoController = eventoController;
        artisti= new HashSet<>();
        this.enumClass=enumClass;
    }

    public void initialize(){
        genereSpettacoloComboBox.setItems(FXCollections.observableArrayList(EnumSet.allOf(enumClass)));
    }

    @Override public void inviaDatiEventoSpecifico() {
        try{
            eventoController.controllaDatiEventoArtistico(this);
        }
        catch (NoValidEventDataException e){
            MostraAlert.mostraAlertErroreInserimentoEvento(e.getMessagge());
        }
    }

    @Override public void pulisciForm(){
        artistaTextField.clear();
        genereSpettacoloComboBox.setValue(null);
    }

    public Enum<T> getGenereSpettacoloComboBox() {
        return genereSpettacoloComboBox.getValue();
    }

    public TextField getArtistaTextField() {
        return artistaTextField;
    }

    public Button getInserisciArtistaButton() {
        return inserisciArtistaButton;
    }

    public EventoController getEventoController() {
        return eventoController;
    }

    public Set<String> getArtisti() {
        return artisti;
    }

    @FXML
    public void inserisciPartecipanteButtonPressed(){
        String partecipante = artistaTextField.getText();
        if(partecipante.equals("") || partecipante==null)
            //TODO:Creare nuovo alert
            MostraAlert.mostraAlertErroreInserimentoEvento("Campo Artista Vuoto!!!");
        else
        {
            artisti.add(partecipante);
            artistaTextField.clear();
        }
    }
}
