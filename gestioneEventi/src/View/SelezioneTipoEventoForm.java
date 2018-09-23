package View;

import Controller.FormController;
import Model.TipologiaEnum;
import javafx.scene.control.Button;
import javafx.fxml.FXML;


public class SelezioneTipoEventoForm {

    @FXML private Button eventoSportivoButton;
    @FXML private Button eventoMusicaleButton;
    @FXML private Button eventoTeatraleButton;
    @FXML private Button eventoCinemaButton;
    private FormController cambiaForm;

    public SelezioneTipoEventoForm(FormController cambiaForm){
        this.cambiaForm=cambiaForm;

    }

    @FXML public void eventoSportivoButtonPressed(){ cambiaForm.mostraFormInserisciEvento(TipologiaEnum.SPORTIVO); }

    @FXML public void eventoMusicaleButtonPressed(){cambiaForm.mostraFormInserisciEvento(TipologiaEnum.MUSICALE);}

    @FXML public void eventoTeatraleButtonPressed(){cambiaForm.mostraFormInserisciEvento(TipologiaEnum.TEATRO);}

    @FXML public void eventoManifestazioneButtonPressed(){cambiaForm.mostraFormInserisciEvento(TipologiaEnum.MANIFESTAZIONI);}



}
