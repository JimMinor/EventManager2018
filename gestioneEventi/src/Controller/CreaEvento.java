package Controller;

import DB.InserisciEventoDAO;
import DB.InserisciEventoDB;
import Model.Evento;

public class CreaEvento {


    public void creaEvento(Evento e) {
        InserisciEventoDAO inserisciEventoDAO = new InserisciEventoDB(e);
        inserisciEventoDAO.inserisciEvento();
    }
}
