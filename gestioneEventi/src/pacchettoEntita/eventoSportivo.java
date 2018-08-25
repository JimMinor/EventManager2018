package pacchettoEntita;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.*;


public class eventoSportivo extends  Evento {

    private Enum<sportEnum> sport;
    private List<String> partecipanti;

    public eventoSportivo(luogoEnum luogoEvento, String descrizione, float prezzoBiglietto, Enum<tipologiaEnum> tipologiaEvento,
                          String nome, LocalDate dataEvento, Enum<sportEnum> sport, List<String> partecipanti) {
        super(luogoEvento, descrizione, prezzoBiglietto, tipologiaEvento, nome, dataEvento);
        this.sport = sport;
        this.partecipanti = partecipanti;
    }

    public Enum<sportEnum> getSport() {
        return sport;
    }

    public void setSport(Enum<sportEnum> sport) {
        this.sport = sport;
    }

    public List<String> getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(ArrayList<String> partecipanti) {
        this.partecipanti = partecipanti;
    }




}
