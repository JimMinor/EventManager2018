package Controller;

import ControllerView.*;
import Model.TipologiaEnum;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Map;

public class CambiaView {

    private Map<String,String> risorseForm;
    private Map<TipologiaEnum,String> eventiSpecificiFormMap; // EnumMap
    private AnchorPane formCorrente;
    private Node formAggiuntivo;

    public CambiaView(AnchorPane formCorrente){
        this.formCorrente=formCorrente;
        // Carico tutti i form in un HashMap<String,Resource>
        risorseForm=new HashMap<>();
        caricaRisorseForm();
    }

    private void caricaRisorseForm() {
        risorseForm.put("creaEvento","../FXMLView/inserisciEventoPane.fxml");
        risorseForm.put("tipoEvento","../FXMLView/tipoEventoPane.fxml");
        risorseForm.put("gestioneClienti", "../FXMLView/cercaClientPane.fxml");
        risorseForm.put("gestioneDipedenti", "../FXMLView/cercaDipendentiPane.fxml");
        risorseForm.put("cercaEvento", "../FXMLView/cercaEventoPane.fxml");
        risorseForm.put("visualizzaDatiClienti", "../FXMLView/visualizzaClientiPane.fxml");
    }

    private FXMLLoader caricaFormDaRisorsa(String risorsa) {
            pulisciForm();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource((risorseForm.get(risorsa))));
            return fxmlLoader;
    }

    public void pulisciForm() {
        formCorrente.getChildren().clear();
    }

    /************************************************
     *                                              *
     *      CREAZIONE FORM INSERISCI EVENTO         *
     *                                              *
     * **********************************************
     */


    public void mostraFormInserisciEvento(){

        try {

            FXMLLoader loader = caricaFormDaRisorsa("creaEvento");
            InserisciEventoController ief=new InserisciEventoController(this);
            loader.setController(ief);
            Node form = loader.load();
            formCorrente.getChildren().add(form);

        } catch( Exception e ) { e.printStackTrace(); }
    }

    public void mostraFormTipoEvento() {
        try {
           FXMLLoader loader = caricaFormDaRisorsa("tipoEvento");
           loader.setController(new SelezioneTipoEventoForm(this));
           Node form = loader.load();
           formCorrente.getChildren().add(form);
       } catch(Exception e) { e.printStackTrace(); }
    }

    public void mostraFormCercaEvento() {
        try {
            FXMLLoader loader = caricaFormDaRisorsa("cercaEvento");
            Node form = loader.load();
            formCorrente.getChildren().add(form);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void mostraFormGestioneClienti() {
        try {
            FXMLLoader loader = caricaFormDaRisorsa("gestioneClienti");
            Node form = loader.load();
            formCorrente.getChildren().add(form);

        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public void mostraFormGestioneDipendeti() {
        try {
            FXMLLoader loader = caricaFormDaRisorsa("gestioneDipedenti");
            Node form = loader.load();
            formCorrente.getChildren().add(form);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    public void mostraStaticheMenu() {
    }

    public void visualizzaPaneClienti() {
        try {
            FXMLLoader loader = caricaFormDaRisorsa("visualizzaDatiClienti");
            Node form = loader.load();
            formCorrente.getChildren().add(form);
            VisualizzaClientiControllerView c =  loader.getController();
            c.getUsernameClienteTextField().setDisable(true);
            c.getCodFiscaleClienteTextField().setDisable(true);
            c.getCognomeClienteTextField().setDisable(true);
            c.getNomeClienteTextField().setDisable(true);
            c.getEmailClienteTextField().setDisable(true);
            c.getIndirizzoClienteTextField().setDisable(true);
            c.getSessoFClienteRadioButton().setDisable(true);
            c.getSessoMClienteRadioButton().setDisable(true);
            c.getBigliettiAcquistatiTextField().setDisable(true);
            c.getSpesaTotaleTextField().setDisable(true);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
