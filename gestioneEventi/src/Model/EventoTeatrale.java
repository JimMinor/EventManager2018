package Model;

import java.time.LocalDate;
import java.util.Set;

public class EventoTeatrale extends  Evento {

    private GenereTeatroEnum genereSpettacolo;
    private Set<String>  artisti;

    public EventoTeatrale(LuogoEnum luogoEvento, java.lang.String descrizione, float prezzoBiglietto, TipologiaEnum tipologiaEvento,
                          String nome, LocalDate dataEvento, GenereTeatroEnum genereSpettacolo,Set<String> artisti){
        super(luogoEvento, descrizione, prezzoBiglietto, tipologiaEvento, nome, dataEvento);
        this.genereSpettacolo=genereSpettacolo;
        this.artisti=artisti;
    }

    public GenereTeatroEnum getGenereSpettacolo() {
        return genereSpettacolo;
    }

    public Set<String> getArtisti() {
        return artisti;
    }
}
