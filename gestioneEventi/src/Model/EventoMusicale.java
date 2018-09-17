package Model;

import java.time.LocalDate;
import java.util.*;

public class EventoMusicale extends Evento {

    private GenereMusicaleEnum genere;
    private Set<String> artista;

    public GenereMusicaleEnum getGenere(){return  genere;}
    public Set<String>  getArtisti(){return artista;}
    public EventoMusicale(LuogoEnum luogoEvento, String descrizione, float prezzoBiglietto,
                          TipologiaEnum tipologiaEvento,
                          String nome, LocalDate dataEvento, GenereMusicaleEnum genere,Set<String> artista) {

        super(luogoEvento, descrizione, prezzoBiglietto, tipologiaEvento, nome, dataEvento);
        this.artista = artista;
        this.genere=genere;
    }
}
