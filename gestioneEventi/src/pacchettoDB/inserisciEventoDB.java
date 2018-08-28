package pacchettoDB;
import pacchettoEntita.*;
import java.sql.*;

public class inserisciEventoDB implements inserisciEventoDAO {

    private Evento eventoDaInserire;
    private gestioneQueryInserimentoEvento inserimentoEvento;

    public inserisciEventoDB(Evento eventoDaInserire){
        this.eventoDaInserire=eventoDaInserire;
        inserimentoEvento=new gestioneQueryInserimentoEvento(eventoDaInserire);
    }
    @Override
    // Entry Point della Classe
    public void inserisciEvento() {
        try{
            int idEventoGenericoCreato=inserimentoEvento.inserimentoEventoGenerico();
           }
            catch (SQLException sqlE){}
    }











}
