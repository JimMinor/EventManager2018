package Control;

import Control.MenuPrincipaleController;
import Model.Addetto;
import Model.VisualizzaAddettiModel;
import View.VisualizzaAddettoView;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class VisualizzaAddettoController {

    private VisualizzaAddettiModel visualizzaAddettiModel;
    private VisualizzaAddettoView visualizzaAddettoView;
    private MenuPrincipaleController menuPrincipaleController;

    public VisualizzaAddettoController(VisualizzaAddettiModel visualizzaAddettiModel, VisualizzaAddettoView visualizzaAddettoView, MenuPrincipaleController menuPrincipaleController) {
        this.visualizzaAddettiModel = visualizzaAddettiModel;
        this.visualizzaAddettoView = visualizzaAddettoView;
        this.menuPrincipaleController = menuPrincipaleController;
        setListenerIndietroButton();
        setDatiAddetto();
    }

    private void setListenerIndietroButton(){
        visualizzaAddettoView.getIndietroButton().
                addEventHandler(ActionEvent.ACTION,event -> Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        menuPrincipaleController.mostraFormAddetti();
                    }
                }));
    }

    private void setDatiAddetto() {

        Addetto addetto = visualizzaAddettiModel.getAddettoSelezionato();
        visualizzaAddettoView.getCodFiscaleAddettoTextField().setText(addetto.getCF());
        visualizzaAddettoView.getNomeAddettoTextField().setText(addetto.getNome());
        visualizzaAddettoView.getCognomeAddettoTextField().setText(addetto.getCognome());
        visualizzaAddettoView.getDataNascitaAddettoDataPicker().setValue(addetto.getDataNascita());
        visualizzaAddettoView.getTelefonoAddettoTextField().setText(addetto.getTelefono());
        visualizzaAddettoView.getEmailAddettoTextField().setText(addetto.getEmail());
        visualizzaAddettoView.getIbanAddettoTextField().setText(addetto.getIban());
        visualizzaAddettoView.getStipendioAddettoTextField().setText(addetto.getStipendio().toString()+"€");
        // EDITABLE -> FALSE
        visualizzaAddettoView.getCodFiscaleAddettoTextField().setEditable(false);
        visualizzaAddettoView.getNomeAddettoTextField().setEditable(false);
        visualizzaAddettoView.getCognomeAddettoTextField().setEditable(false);
        visualizzaAddettoView.getDataNascitaAddettoDataPicker().setEditable(false);
        visualizzaAddettoView.getTelefonoAddettoTextField().setEditable(false);
        visualizzaAddettoView.getEmailAddettoTextField().setEditable(false);
        visualizzaAddettoView.getIbanAddettoTextField().setEditable(false);
        visualizzaAddettoView.getStipendioAddettoTextField().setEditable(false);





    }


}
