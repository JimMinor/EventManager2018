package pacchettoEntita;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.*;

public class eventoMusicale extends Evento {

    private String artisti;

    public String getArtisti() {
        return artisti;
    }

    public void setArtisti(String artisti) {
        this.artisti = artisti;
    }

    public eventoMusicale(luogoEnum luogoEvento, String descrizione, float prezzoBiglietto,
                         tipologiaEnum tipologiaEvento,
                          String nome, LocalDate dataEvento, String artisti) {
        super(luogoEvento, descrizione, prezzoBiglietto, tipologiaEvento, nome, dataEvento);
        this.artisti = artisti;
    }
}
