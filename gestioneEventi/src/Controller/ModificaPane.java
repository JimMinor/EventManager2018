package Controller;

import ControllerView.InserisciEventoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import Scaffale.inserisciDipendentePaneController;
import View.visualizzaClientiPaneController;

/**
 * NON FUNZIONANTE:
 * Bisogna mantenere il riferimento ai nodi creati,
 * usando un HashMap<String,Node>, oppure un riferimento,
 * al Node attivo
 */
public class ModificaPane {

    public void mostraPaneEvento(AnchorPane pane, String risorsa) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(risorsa));
            rimuoviPane(pane);
            Node node = (Node) loader.load();
            pane.getChildren().add(node);
            InserisciEventoController c = (InserisciEventoController) loader.getController();
           /** c.getCittaEventoTextField().setDisable(true);
            c.getNomeEventoTextField().setDisable(true);
            c.getCapienzaMaxEventoTextField().setDisable(true);
            c.getEventoTipoComboBox().setDisable(true);
            c.getDescrizioneEventoTextArea().setDisable(true);
            c.operazione="chiudi";
            */


        } catch (Exception e) {
        }
    }

    /*la pricedura visualizzapaneclienti blocca tutti i campi del cliente in quanto non deve essere modificato */

    public void visualizzapaneclienti(AnchorPane pane, String risorsa){
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(risorsa));
        rimuoviPane(pane);
        Node node = (Node) loader.load();
        pane.getChildren().add(node);
        visualizzaClientiPaneController c = (visualizzaClientiPaneController) loader.getController();
        c.getUsernameClienteTextField().setDisable(true);
        c.getCodFiscaleClienteTextField().setDisable(true);
        c.getCognomeClienteTextField().setDisable(true);
        c.getNomeClienteTextField().setDisable(true);
        c.getEmailClienteTextField().setDisable(true);
        c.getIndirizzoClienteTextField().setDisable(true);
        c.getSessoFClienteRadioButton().setDisable(true);
        c.getSessoMClienteRadioButton().setDisable(true);

        } catch (Exception e) {
        }
    }

    public void modificaPaneDipendenti (AnchorPane pane, String risorsa){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(risorsa));
            rimuoviPane(pane);
            Node node = (Node) loader.load();
            pane.getChildren().add(node);
            inserisciDipendentePaneController c = (inserisciDipendentePaneController) loader.getController();
            c.getCodFiscaleDipendenteTextField().setDisable(true);
            c.getCognomeDipendenteTextField().setDisable(true);
            c.getDataNascitaDipendenteDatePicker().setDisable(true);
            c.getSessoFDipendenteRatioButton().setDisable(true);
            c.getSessoMDipendenteRadioButton().setDisable(true);
            c.nomeDipendenteTextField.setDisable(true);
            c.operazione="annulla";




        } catch (Exception e) {
        }
    }

    public void rimuoviPane(AnchorPane pane) {
        pane.getChildren().clear();//pulisce la scermata
    }


}
