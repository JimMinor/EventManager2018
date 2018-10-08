package Control;

import Model.*;
import View.*;
import View.cercaDipendentiPaneController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Map;

public class MenuPrincipaleController {

    private Map<String,String> risorseForm;
    private Map<TipologiaEnum,String> eventiSpecificiFormMap; // EnumMap
    private MenuPrincipaleView menuPrincipaleView;
    private AnchorPane formCorrente;

    public MenuPrincipaleController(AnchorPane formCorrente,MenuPrincipaleView menuPrincipaleView){
        this.menuPrincipaleView = menuPrincipaleView;
        this.formCorrente=formCorrente;
        // Carico tutti i form in un HashMap<String,Resource>
        risorseForm=new HashMap<>();
        caricaRisorseForm();
        // Setto i Listener per la View del MenuPrincipale
        setListenerMenuPrincipale();
    }


    private void caricaRisorseForm() {
        Thread inserisciRisorseRun = new Thread(){
            @Override
            public void run() {
                risorseForm.put("creaEvento","../FXMLView/inserisciEventoPane.fxml");
                risorseForm.put("tipoEvento","../FXMLView/tipoEventoPane.fxml");
                risorseForm.put("gestioneClienti", "../FXMLView/cercaClientPane.fxml");
                risorseForm.put("gestioneDipedenti", "../FXMLView/cercaDipendentiPane.fxml");
                risorseForm.put("cercaEvento", "../FXMLView/cercaEventoPane.fxml");
                risorseForm.put("visualizzaDatiClienti", "../FXMLView/visualizzaClientiPane.fxml");
                risorseForm.put("nuovoDipendente", "../FXMLView/inserisciDipendentePane.fxml");
                risorseForm.put("visualizzaEvento","../FXMLView/VisualizzaEventoPane.fxml");
                risorseForm.put("statistiche","../FXMLView/StatisicheBigliettiPane.fxml");

            }
        };
        inserisciRisorseRun.start();


    }

    private FXMLLoader caricaFormDaRisorsa(String risorsa) {
            pulisciForm();
            return  new FXMLLoader(getClass().getResource((risorseForm.get(risorsa))));

    }

    public void pulisciForm() {
        formCorrente.getChildren().clear();
    }

    /** Set Listener per i pulsati del menu principale */

    private void setListenerMenuPrincipale() {
        setListenerInserisciEvento();
        setListenerCercaEvento();
        setListenerCercaClienti();
        setListenerGestionePersonale();
        setListenerStat();
    }

    private void setListenerInserisciEvento(){
        Button inserisciEventi = menuPrincipaleView.getInserisciEventiButton();
        inserisciEventi.addEventHandler(ActionEvent.ACTION, event ->{
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    mostraFormInserisciEvento();
                }
                });
            });
    }

    private void setListenerCercaEvento(){
        Button cercaEventoButton = menuPrincipaleView.getCercaEventoButton();
        cercaEventoButton.addEventHandler(ActionEvent.ACTION, event-> Platform.runLater(new Runnable(){
            @Override
            public void run(){
                mostraFormCercaEvento();
            }

        }));
    }

    private void setListenerCercaClienti(){
        Button cercaClientiButton = menuPrincipaleView.getGestioneClientiButton();
        cercaClientiButton.addEventHandler(ActionEvent.ACTION, event -> Platform.runLater(new Runnable() {
            @Override
            public void run() {
                mostraFormGestioneClienti();
            }
        }));
    }

    private void setListenerGestionePersonale(){
        Button gestionePersonaleButton = menuPrincipaleView.getGestionePersonaleButton();
        gestionePersonaleButton.addEventHandler(ActionEvent.ACTION, event -> Platform.runLater(new Runnable() {
            @Override
            public void run() {
                mostraFormGestioneDipendeti();
            }
        }));
    }

    private void setListenerStat(){
        menuPrincipaleView.getVisualizzaStaticheButton().addEventHandler(ActionEvent.ACTION, event-> Platform.runLater(new Runnable() {
            @Override
            public void run() {
                mostraStaticheMenu();
            }
        }));
    }


    /************************************************
     *                                              *
     *            CREAZIONE FORMS                    *
     *                                              *
     * **********************************************
     */


    public void mostraFormInserisciEvento(){

        try {

            FXMLLoader loader = caricaFormDaRisorsa("creaEvento");
            InserisciEventoView inserisciEventoForm=new InserisciEventoView(this);
            loader.setController(inserisciEventoForm);
            AnchorPane pane = loader.load();
            InserisciEventoController inserisciEventoController = new InserisciEventoController(new Evento(),inserisciEventoForm);
            formCorrente.getChildren().add(pane);

        } catch( Exception e ) { e.printStackTrace(); }
    }

    public void mostraFormCercaEvento() {
        try {

            FXMLLoader loader = caricaFormDaRisorsa("cercaEvento");
            VisualizzaEventiModel visualizzaEventiModel = new VisualizzaEventiModel();
            CercaEventoView cercaEventoView = new CercaEventoView(this,visualizzaEventiModel);
            loader.setController(cercaEventoView);
            AnchorPane form = loader.load();
            RicercaEventoController ricercaEventoController = new RicercaEventoController(visualizzaEventiModel,cercaEventoView,this);
            formCorrente.getChildren().add(form);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void mostraFormGestioneClienti() {
        try {
            FXMLLoader loader = caricaFormDaRisorsa("gestioneClienti");
            VisualizzaClientiModel visualizzaClientiModel = new VisualizzaClientiModel();
            CercaClientiView cercaClientiView = new CercaClientiView(visualizzaClientiModel);
            loader.setController(cercaClientiView);
            Node form = loader.load();
            RicercaClienteController  ricercaClienteController = new RicercaClienteController(
                    visualizzaClientiModel,cercaClientiView,this);
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
        try {
            FXMLLoader loader = caricaFormDaRisorsa("statistiche");
            StatisticheModel statisticheModel = new StatisticheModel();
            StatisticheView statisticheView = new StatisticheView(statisticheModel);
            loader.setController(statisticheView);
            AnchorPane form = loader.load();
            StatisticheController statisticheController = new StatisticheController(statisticheModel, statisticheView,this);
            formCorrente.getChildren().add(form);
        } catch ( Exception e)  { e.printStackTrace(); }

    }

    public void visualizzaPaneClienti(VisualizzaClientiModel visualizzaClientiModel) {
        try {
                FXMLLoader loader  = caricaFormDaRisorsa("visualizzaDatiClienti");
                VisualizzaDatiClientiView visualizzaDatiClientiView = new VisualizzaDatiClientiView(
                        visualizzaClientiModel);
                loader.setController(visualizzaDatiClientiView);
                Parent root = loader.load();
                formCorrente.getChildren().add(root);
            VisualizzaDatiClienteController controllerCliente = new VisualizzaDatiClienteController(
                    visualizzaDatiClientiView,visualizzaClientiModel,this);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void mostraFormVisualizzaEvento(VisualizzaEventiModel visualizzaEventiModel) {

        try {
             FXMLLoader loader = caricaFormDaRisorsa("visualizzaEvento");
             VisualizzaEventoView visualizzaEventoView = new VisualizzaEventoView(visualizzaEventiModel);
             loader.setController(visualizzaEventoView);
             Parent root =loader.load();

             formCorrente.getChildren().add(root);
            VisualizzaEventoController visualizzaEventoController = new VisualizzaEventoController(visualizzaEventiModel,visualizzaEventoView
                    ,this);


        } catch ( Exception e ){ e.printStackTrace(); }
    }
}
