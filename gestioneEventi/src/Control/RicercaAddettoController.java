package Control;

import DB.AddettoDAO;
import DB.AddettoDAOImp;
import Model.Addetto;
import Model.VisualizzaAddettiModel;
import View.CercaAddettiView;
import View.MostraAlert;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import sun.net.www.content.text.PlainTextInputStream;

import java.sql.SQLException;
import java.time.LocalDate;

public class RicercaAddettoController {

    private CercaAddettiView cercaAddettiView;
    private VisualizzaAddettiModel visualizzaAddettiModel;
    private MenuPrincipaleController menuPrincipaleController;
    private AddettoDAO addettoDAO;

    public RicercaAddettoController(CercaAddettiView cercaAddettiView, VisualizzaAddettiModel visualizzaAddettiModel, MenuPrincipaleController menuPrincipaleController) {

        this.cercaAddettiView = cercaAddettiView;
        this.visualizzaAddettiModel = visualizzaAddettiModel;
        this.menuPrincipaleController = menuPrincipaleController;
        addettoDAO = new AddettoDAOImp();
        setListenerAddettiView();
        cercaAddetti();
    }

    private void setListenerAddettiView(){
        setListenerAnnullaButton();
        setListenerCercaButton();
        setListenerEliminaButton();
    }

    private void setListenerAnnullaButton() {
        cercaAddettiView.getAnnullaCercaAddettoButton().addEventHandler(ActionEvent.ACTION,
                event -> Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        cercaAddettiView.getNomeCercaAddettoTextField().clear();
                        cercaAddettiView.getCognomeCercaAddettoTextField().clear();
                        cercaAddettiView.getDataNascitaCercaAddettoDataPicker().setValue(null);
                    }
                }));
    }

    private void setListenerCercaButton() {
        cercaAddettiView.getCercaAddettoButton().addEventHandler(ActionEvent.ACTION,
                event -> Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        cercaAddetti();
                    }
                }));
    }

    private void setListenerEliminaButton() {
        cercaAddettiView.getEliminaAddettiButton().addEventHandler(
                ActionEvent.ACTION, event -> Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Addetto addetto = cercaAddettiView.getTabellaCercaAddettoTableView().
                                getSelectionModel().getSelectedItem();

                        visualizzaAddettiModel.setAddettoSelezionato(addetto);
                        eliminaAddettoSelezionato();
                    }
                })
        );
    }

    private void setListenerNuovoButton() {}

    private void  eliminaAddettoSelezionato(){

        Addetto addettoSelezionato = visualizzaAddettiModel.getAddettoSelezionato();
            try {
                 if(addettoSelezionato!=null) {
                     addettoDAO.eliminaAddetto(addettoSelezionato);
                    visualizzaAddettiModel.setListaAddettiView(((AddettoDAOImp) addettoDAO).cercaAddetto("", "", null));
                     MostraAlert.mostraAlertAddettoEliminato();
             }
        } catch (Exception e) {
            e.printStackTrace();
            MostraAlert.mostraAlertErroreInserimentoDati("Non è stato possibile eliminare l'addetto. Riprovare.\"");
        }

    }




    public void cercaAddetti () {
        String nomeAddetto = cercaAddettiView.getNomeCercaAddettoTextField().getText();
        String cognomeAddetto = cercaAddettiView.getColonnaCognomeAddetto().getText();
        LocalDate dataNascitaAddetto = cercaAddettiView.getDataNascitaCercaAddettoDataPicker().getValue();

        Task cercaAddettiTask = new Task() {
            @Override
            protected Object call() throws Exception {
                try {
                    visualizzaAddettiModel.setListaAddettiView(((AddettoDAOImp) addettoDAO).cercaAddetto(nomeAddetto, cognomeAddetto, dataNascitaAddetto));
                } catch ( SQLException e ) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        new Thread(cercaAddettiTask).start();

    }
}
