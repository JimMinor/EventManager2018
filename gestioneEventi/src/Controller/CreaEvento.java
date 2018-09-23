package Controller;

import DB.EventoDAO;
import DB.EventoDAOImp;
import Model.Evento;

public class CreaEvento {


    public void creaEvento(Evento e) {
        EventoDAO eventoDAO = new EventoDAOImp(e);

    }
}
