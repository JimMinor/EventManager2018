package pacchettoEntita;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.*;

public class eventoMusicale extends Evento {

    private List<String> artisti;
    public List<String> getArtisti() {
        return artisti;
    }

    public void setArtisti(List<String> artisti) {
        this.artisti = artisti;
    }

    public eventoMusicale(luogoEnum luogoEvento, String descrizione, float prezzoBiglietto,
                         tipologiaEnum tipologiaEvento,
                          String nome, LocalDate dataEvento, List<String> artisti) {
        super(luogoEvento, descrizione, prezzoBiglietto, tipologiaEvento, nome, dataEvento);
        this.artisti = artisti;
    }
}
