package Model;

import java.time.LocalDate;
import java.util.*;

public class EventoMusicale extends Evento {

    private List<String> artisti;
    public List<String>  getArtisti(){return artisti;}
    public EventoMusicale(LuogoEnum luogoEvento, String descrizione, float prezzoBiglietto,
                          TipologiaEnum tipologiaEvento,
                          String nome, LocalDate dataEvento, List<String> artisti) {

        super(luogoEvento, descrizione, prezzoBiglietto, tipologiaEvento, nome, dataEvento);
        this.artisti = artisti;
    }
}
