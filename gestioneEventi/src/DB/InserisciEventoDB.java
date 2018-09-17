package DB;
import Model.*;
import View.MostraAlert;

import java.sql.*;

public class InserisciEventoDB<T extends  Evento> implements InserisciEventoDAO {

    private T eventoDaInserire;
    private GestoreQueryInserimentoEvento<T> inserimentoEvento;

    public InserisciEventoDB(T eventoDaInserire) {
        this.eventoDaInserire = eventoDaInserire;
        inserimentoEvento = BuilderGestoreQueryEvento.buildGestoreEvento(eventoDaInserire);
        System.out.println(inserimentoEvento + " evento " + eventoDaInserire);
    }
    @Override
    // Entry Point della Classe
    public void inserisciEvento() {
        try { inserimentoEvento.eseguiEPreparaQueryInserimentoEvento();}
            catch (SQLException sqlE){
                sqlE.printStackTrace();
                if(sqlE instanceof  SQLIntegrityConstraintViolationException)
                    MostraAlert.mostraAlertErroreInserimentoEvento("Evento precedentemente inserito");
            }

       }




}
