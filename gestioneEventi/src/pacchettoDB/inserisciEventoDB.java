package pacchettoDB;
import pacchettoEntita.*;
import java.sql.*;

public class inserisciEventoDB implements inserisciEventoDAO {

    private Evento eventoDaInserire;
    private gestioneQueryInserimentoEvento inserimentoEvento;

    public inserisciEventoDB(Evento eventoDaInserire){
        this.eventoDaInserire=eventoDaInserire;
        inserimentoEvento=controllaTipoEvento(eventoDaInserire);

    }
    @Override
    // Entry Point della Classe
    public void inserisciEvento() {
        try {

            inserimentoEvento.eseguiEPreparaQueryInserimentoEvento();
            }
            catch (SQLException sqlE){
            sqlE.printStackTrace();
            System.out.println("non inserito");
            }
       }

    private gestioneQueryInserimentoEvento controllaTipoEvento(Evento eventoDaInserire) {


        if (eventoDaInserire instanceof eventoSportivo)
            return new gestioneQueryInserimentoEventoSportivo((eventoSportivo) eventoDaInserire);

        return null;
    }



}
