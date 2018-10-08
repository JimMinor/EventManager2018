package Control;

import View.CercaEventoView;
import View.MostraAlert;
import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.VisualizzaEventiModel;
import Model.Evento;
import Model.LuogoEnum;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.sql.SQLException;
import java.time.LocalDate;

public class RicercaEventoController {

    /**  ATTRIBUTI  */

    private VisualizzaEventiModel visualizzaEventiModel;
    private CercaEventoView cercaEventoView;
    private EventoDAO eventoDAO;
    private MenuPrincipaleController menuPrincipaleController;

    public RicercaEventoController(VisualizzaEventiModel cercaEventoModel, CercaEventoView cercaEventoView, MenuPrincipaleController menuPrincipaleController){
        this.visualizzaEventiModel =cercaEventoModel;
        this.cercaEventoView = cercaEventoView;
        this.menuPrincipaleController = menuPrincipaleController;
        this.eventoDAO = new EventoDAOImp();
        setListenerCercaEventoView();
        cercaEventi();
    }

    public void initialize (){}

    /**
     *   Setting dei Listeners per la classe (View) CercaEventoView
     */
    private void setListenerCercaEventoView() {
        setListenerCercaEventoButton();
        setListenerOkButton();
        setListenerModificaButton();
        setListenerEliminaButton();
        setListenerVisualizzaDatiButton();
        setListenerTabellaEventi();
    }

    private void setListenerCercaEventoButton() {
        Button cercaButton = cercaEventoView.getCercaEventoButton();
        cercaButton.addEventHandler(ActionEvent.ACTION,  event -> Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try{
                    cercaEventi();

                } catch ( Exception e) {
                    MostraAlert.mostraAlertErroreInserimentoDati(e.getMessage());
                }
            };
        }));
    }

    private void setListenerOkButton(){
        Button okButton = cercaEventoView.getOkButton();
        okButton.addEventHandler(ActionEvent.ACTION, event-> Platform.runLater(new Runnable(){
            @Override
            public void run() {
                modificaEventoSelezionato();
            }
        }));
    }

    private void setListenerModificaButton(){
        Button modificaButton = cercaEventoView.getModificaEventoButton();
        modificaButton.addEventHandler(ActionEvent.ACTION, event -> Platform.runLater(new Runnable(){
            @Override
            public void run(){
                cambiaModalita(true);
                Evento eventoSelezionato = cercaEventoView.getTabellaCercaEventoTableView().getSelectionModel()
                        .getSelectedItem();
                visualizzaEventiModel.setEventoSelezionato(eventoSelezionato);
            }

        }));
    }

    private void setListenerEliminaButton() {

        Button eliminaButton = cercaEventoView.getEliminaEventoButton();
        eliminaButton.addEventHandler(ActionEvent.ACTION, event -> Platform.runLater(new Runnable () {
            @Override
            public void run(){

                Evento evento =  cercaEventoView.getTabellaCercaEventoTableView().getSelectionModel().getSelectedItem();
                visualizzaEventiModel.setEventoSelezionato(evento);
                eliminaEventoSelezionato();
                visualizzaEventiModel.setEventoSelezionato(new Evento());
            }

        }));
    }

    private  void setListenerVisualizzaDatiButton() {

        Button visualizzaDatiButton = cercaEventoView.getVisualizzaDatiEventoButton();
        visualizzaDatiButton.addEventHandler(ActionEvent.ACTION , event -> Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Evento evento = (cercaEventoView.
                        getTabellaCercaEventoTableView().
                        getSelectionModel().
                        getSelectedItem());
                if(evento!=null) {
                    visualizzaEventiModel.setEventoSelezionato(evento);
                    menuPrincipaleController.mostraFormVisualizzaEvento(visualizzaEventiModel);
                }

            }
        }));
    }

    private void setListenerTabellaEventi(){
        cercaEventoView.getTabellaCercaEventoTableView().addEventHandler(
                ActionEvent.ACTION, event -> Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Evento evento = (cercaEventoView.
                                getTabellaCercaEventoTableView().
                                getSelectionModel().
                                getSelectedItem());
                        visualizzaEventiModel.setEventoSelezionato(evento);
                        System.out.println(evento);
                    }
                })
        );
    }



    /** Metodi comunicanti con il  DAO */

    public void  eliminaEventoSelezionato(){

       Evento eventoSelezionato =  visualizzaEventiModel.getEventoSelezionato();
        try {
            if(eventoSelezionato!=null) {

                eventoDAO.eliminaEvento(eventoSelezionato);
                visualizzaEventiModel.setEventoSelezionato(eventoSelezionato);
                visualizzaEventiModel.setListaEventiView(((EventoDAOImp) eventoDAO).cercaEvento());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void  modificaEventoSelezionato(){
        try {
            // Controllo sui dati:
            LocalDate data = cercaEventoView.getDataCercaEventoDataPicker().getValue();
            LuogoEnum luogo = cercaEventoView.getLuogoEventoComboBox().getValue();
            if ( data == null ) throw new NoValidEventDataException("Inserire Data");
            if ( luogo == null ) throw  new NoValidEventDataException("Selezionare Luogo");

            Evento e = visualizzaEventiModel.getEventoSelezionato();
            eventoDAO.modificaEvento(e.getIdEvento(),data, luogo);
            visualizzaEventiModel.setEventoSelezionato(e);
            visualizzaEventiModel.setListaEventiView(((EventoDAOImp) eventoDAO).cercaEvento());
            cambiaModalita(false);

        } catch ( SQLException e ){
            e.printStackTrace();
        }
        catch ( NoValidEventDataException e2) {

            MostraAlert.mostraAlertErroreInserimentoDati(e2.getMessagge());
        }
    }

    public synchronized void cercaEventi () {

        String nomeEvento = cercaEventoView.getNomeCercaEventoTextField().getText();
        LuogoEnum luogoEnum = cercaEventoView.getLuogoEventoComboBox().getValue();
        LocalDate dataEvento = cercaEventoView.getDataCercaEventoDataPicker().getValue();


        Task cercaEventiTask = new Task() {
            @Override
            protected Object call() throws Exception {
                try {
                    visualizzaEventiModel.setListaEventiView(((EventoDAOImp) eventoDAO).
                            cercaEvento(nomeEvento, dataEvento, luogoEnum));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        };
        new Thread(cercaEventiTask).start();


    }



    private synchronized void cambiaModalita(boolean isDisable){
        cercaEventoView.getLuogoEventoComboBox().setValue(null);
        cercaEventoView.getDataCercaEventoDataPicker().setValue(null);
        cercaEventoView.getOkButton().setDisable(!isDisable);
        cercaEventoView.getCercaEventoButton().setDisable(isDisable);
        cercaEventoView.getModificaEventoButton().setDisable(isDisable);
        cercaEventoView.getEliminaEventoButton().setDisable(isDisable);
        cercaEventoView.getAnnullaCercaEventoButton().setDisable(isDisable);
        cercaEventoView.getTabellaCercaEventoTableView().setDisable(isDisable);
    }

}
