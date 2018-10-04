package View;

import Control.MenuPrincipaleController;
import javafx.scene.control.Button;
import javafx.fxml.FXML;


public class SelezioneTipoEventoForm {

    @FXML private Button eventoSportivoButton;
    @FXML private Button eventoMusicaleButton;
    @FXML private Button eventoTeatraleButton;
    @FXML private Button eventoCinemaButton;
    private MenuPrincipaleController cambiaForm;

    public SelezioneTipoEventoForm(MenuPrincipaleController cambiaForm) { this.cambiaForm=cambiaForm; }

    @FXML public void eventoSportivoButtonPressed() { cambiaForm.mostraFormInserisciEvento(); }

    @FXML public void eventoMusicaleButtonPressed() { cambiaForm.mostraFormInserisciEvento(); }

    @FXML public void eventoTeatraleButtonPressed() { cambiaForm.mostraFormInserisciEvento(); }

    @FXML public void eventoManifestazioneButtonPressed() { cambiaForm.mostraFormInserisciEvento(); }

}
