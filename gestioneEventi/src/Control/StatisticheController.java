package Control;

import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.Evento;
import Model.StatisticheModel;
import View.MostraAlert;
import View.StatisticheView;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticheController {

    private StatisticheModel modelStat;
    private StatisticheView viewStat;
    private MenuPrincipaleController menuController;
    private EventoDAO eventoDAO;

    public StatisticheController(StatisticheModel modelStat, StatisticheView viewStat, MenuPrincipaleController menuController) {
        this.modelStat = modelStat;
        this.viewStat = viewStat;
        this.menuController = menuController;
        eventoDAO = new EventoDAOImp();
        setListenerCercaButton();
    }

    private void setListenerCercaButton() {

        viewStat.getCercaButton().
                addEventHandler(ActionEvent.ACTION, event -> Platform.runLater(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                     String artista = viewStat.getNomePartecipanteTextField().getText();

                                     if( !artista.equals("")) {

                                         List<Evento> listeventi = eventoDAO.cercaEvento(artista);
                                         if(!listeventi.isEmpty()){
                                         modelStat.setMapBiglietti(creaMappaBiglietti(listeventi));
                                         modelStat.setMapEventiCitta(eventoDAO.cercaEventiPerCitta(artista));
                                         modelStat.notifyView();
                                         }
                                         else MostraAlert.mostraAlertErroreInserimentoDati("Inserisci un Artista/Squadra/Atleta presente nel database");
                                     }
                                     else MostraAlert.mostraAlertErroreInserimentoDati("Inserisci una Artista/Squadra/Atleta");

                                } catch (Exception e) { e.printStackTrace(); }

                            }
                        }
                ));
    }

    private Map<String,Integer> creaMappaBiglietti(List<Evento> listeventi) {
        Map<String,Integer> mapStat = new HashMap<>();
        for(Evento e : listeventi)
            mapStat.put(e.getLuogoEvento().getCittaLuogo().name(),e.getBigliettiVenduti());
        return mapStat;
    }

}
