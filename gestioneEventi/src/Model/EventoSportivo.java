package Model;

import java.time.LocalDate;
import java.util.*;


public class EventoSportivo extends  Evento {

    private String sport;
    private Set<String> partecipanti;

    public EventoSportivo(LuogoEnum luogoEvento, java.lang.String descrizione, float prezzoBiglietto, TipologiaEnum tipologiaEvento,
                          String nome, LocalDate dataEvento, String sport, Set<String> partecipanti) {
        super(luogoEvento, descrizione, prezzoBiglietto, tipologiaEvento, nome, dataEvento);
        this.sport = sport;
        this.partecipanti = partecipanti;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Set<String> getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(Set<String> partecipanti) {
        this.partecipanti = partecipanti;
    }

}
