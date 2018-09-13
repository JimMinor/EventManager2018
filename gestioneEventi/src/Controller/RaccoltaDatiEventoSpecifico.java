package Controller;

import java.util.List;

public class RaccoltaDatiEventoSpecifico {

    private String genereEventoSpecifico;
    private List<String> partecipantiEvento;

    public void setGenereEventoSpecifico(String genereEventoSpecifico) {
        this.genereEventoSpecifico = genereEventoSpecifico;
    }

    public void setPartecipantiEvento(List<String> partecipantiEvento) {
        this.partecipantiEvento = partecipantiEvento;
    }

    public String getGenereEventoSpecifico() {

        return genereEventoSpecifico;
    }

    public List<String> getPartecipantiEvento() {
        return partecipantiEvento;
    }
}
