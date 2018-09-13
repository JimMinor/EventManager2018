package DB;
import Model.*;
import View.MostraAlert;

import java.sql.*;

public class InserisciEventoDB implements InserisciEventoDAO {

    private Evento eventoDaInserire;
    private CreaQueryInserimentoEvento inserimentoEvento;

    public InserisciEventoDB(Evento eventoDaInserire){
        this.eventoDaInserire=eventoDaInserire;
        inserimentoEvento=controllaTipoEvento(eventoDaInserire);

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

    private CreaQueryInserimentoEvento controllaTipoEvento(Evento eventoDaInserire) {
         if (eventoDaInserire instanceof EventoSportivo)
            return new CreaQueryInserimentoEventoSportivo((EventoSportivo) eventoDaInserire);

        return null;
    }



}
