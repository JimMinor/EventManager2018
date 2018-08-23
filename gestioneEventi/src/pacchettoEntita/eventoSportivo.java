package pacchettoEntita;

import sun.util.resources.LocaleData;

import java.util.List;
import java.time.*;

public class eventoSportivo extends  Evento {

    private Enum<sportEnum> sport;
    private String[] partecipanti;

    public eventoSportivo(String luogoEvento, String descrizione, float prezzoBiglietto,
                          Enum<tipologiaEnum> tipologiaEvento,
                          String nome, LocalDate dataEvento, Enum<sportEnum> sport,
                          String[] partecipanti) {
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

    public String[] getPartecipanti() {
        return partecipanti;
    }


    }



