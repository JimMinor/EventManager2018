package Control;

import Model.Evento;
import Model.VisualizzaEventiModel;
import View.VisualizzaEventoView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import javax.swing.*;



public class VisualizzaEventoController {

    private VisualizzaEventiModel visualizzaEventiModel;// Model
    private VisualizzaEventoView visualizzaEventoView; // View
    private MenuPrincipaleController menuPrincipaleController;

    public VisualizzaEventoController (VisualizzaEventiModel visualizzaEventiModel, VisualizzaEventoView visualizzaEventoView, MenuPrincipaleController menuPrincipaleController) {
        this.visualizzaEventiModel = visualizzaEventiModel;
        this.visualizzaEventoView = visualizzaEventoView;
        this.menuPrincipaleController = menuPrincipaleController;
        setListenerOkButton();
        setDatiEvento();
    }

    private void setDatiEvento() {
        visualizzaEventoView.getNomeEventoTextField().setText(visualizzaEventiModel.getEventoSelezionato().getNome());
        visualizzaEventoView.getLuogoEventoTextField().setText(visualizzaEventiModel.getEventoSelezionato().getLuogoEvento().name());
        visualizzaEventoView.getTipoEventoTextField().setText(visualizzaEventiModel.getEventoSelezionato().getTipologiaEvento().name());
        visualizzaEventoView.getDataEventoDatePicker().setValue(visualizzaEventiModel.getEventoSelezionato().getDataEvento());
        visualizzaEventoView.getDescrizioneEventoTextField().setText(visualizzaEventiModel.getEventoSelezionato().getDescrizione());
        visualizzaEventoView.getGenereEventoTextField().setText(visualizzaEventiModel.getEventoSelezionato().getGenereEvento());
        visualizzaEventoView.getPrezzoTextField().setText(visualizzaEventiModel.getEventoSelezionato().getPrezzoBiglietto().toString()+"€");
        visualizzaEventoView.getListaPartecipantiListView().setItems(
                FXCollections.observableArrayList(visualizzaEventiModel.getEventoSelezionato().getPartecipantiEvento()));
    }

    private void setListenerOkButton() {
        Button okButton = visualizzaEventoView.getOkButton();
        okButton.addEventHandler(ActionEvent.ACTION, event-> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    menuPrincipaleController.mostraFormCercaEvento();
                }
            });});
    }


}
