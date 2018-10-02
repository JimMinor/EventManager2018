package Controller;

import ControllerView.*;
import Model.Evento;
import Model.TipologiaEnum;
import Model.VisualizzaEventiModel;
import ControllerView.cercaDipendentiPaneController;
import Model.VisualizzaclientiModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        risorseForm.put("nuovoDipendente", "../FXMLView/inserisciDipendentePane.fxml");
        risorseForm.put("visualizzaEvento","../FXMLView/VisualizzaEventoPane.fxml");
    }

    private FXMLLoader caricaFormDaRisorsa(String risorsa) {
            pulisciForm();
            return  new FXMLLoader(getClass().getResource((risorseForm.get(risorsa))));

    }

    public void pulisciForm() {
        formCorrente.getChildren().clear();
    }

    /************************************************
     *                                              *
     *            CREAZIONE FORM                    *
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
            loader.setController(new CercaEventoControllerView(this, new VisualizzaEventiModel()));
            Node form = loader.load();
            formCorrente.getChildren().add(form);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void mostraFormGestioneClienti() {
        try {
            FXMLLoader loader = caricaFormDaRisorsa("gestioneClienti");
            loader.setController(new CercaClientiControllerView(this, new VisualizzaclientiModel()));
            Node form = loader.load();
            formCorrente.getChildren().add(form);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    public void mostraFormGestioneDipendeti() {
            try {
                FXMLLoader loader = caricaFormDaRisorsa("gestioneDipedenti");
                cercaDipendentiPaneController dipendentiController = new cercaDipendentiPaneController(this);
                loader.setController(dipendentiController);
                Node form = loader.load();
                formCorrente.getChildren().add(form);
            } catch (Exception e) {
                e.printStackTrace();

            }
    }

    public void mostraFormNuovoDipendente() {
        try {
            FXMLLoader loader = caricaFormDaRisorsa("nuovoDipendente");
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

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void mostraFormVisualizzaEvento(Evento eventoSelezionato) {

        try {
             FXMLLoader loader = caricaFormDaRisorsa("visualizzaEvento");
             VisualizzaEventoControllerView vec = new VisualizzaEventoControllerView(this,eventoSelezionato);
             loader.setController(vec);
             Parent root =loader.load();
             formCorrente.getChildren().add(root);


        } catch ( Exception e ){ e.printStackTrace(); }
    }
}
