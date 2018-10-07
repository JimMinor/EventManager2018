package Control;

import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.Evento;
import Model.LuogoEnum;
import Model.StatisticheBigliettiModel;
import View.StatisticheBigliettiView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatisticheBigliettiController {

    private StatisticheBigliettiModel modelStat;
    private StatisticheBigliettiView viewStat;
    private MenuPrincipaleController menuController;
    private EventoDAO eventoDAO;

    public StatisticheBigliettiController(StatisticheBigliettiModel modelStat, StatisticheBigliettiView viewStat, MenuPrincipaleController menuController) {
        this.modelStat = modelStat;
        this.viewStat = viewStat;
        this.menuController = menuController;
        eventoDAO = new EventoDAOImp();
        setListenerCercaButton();
    }

    private void setListenerStatView(){
        setListenerCercaButton();
    }

    private void setListenerCercaButton() {

        viewStat.getCercaButton().
                addEventHandler(ActionEvent.ACTION, event -> Platform.runLater(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    List<Evento> listeventi = eventoDAO.cercaEvento();
                                    modelStat.setMapBiglietti(creaMappa(listeventi));
                                } catch (Exception e) { e.printStackTrace(); }

                            }
                        }
                ));
    }



    private Map<String,Integer> creaMappa(List<Evento> listeventi) {
        Map<String,Integer> mapStat = new HashMap<>();
        for(Evento e : listeventi)
            mapStat.put(e.getLuogoEvento().getCittaLuogo().name(),e.getBigliettiVenduti());
        return mapStat;
    }

}
