package pacchettoEntita;

import sun.util.resources.LocaleData;

import java.util.List;

public class eventoMusicale extends Evento {

    private List<String> artisti;

    public List<String> getArtisti() {
        return artisti;
    }

    public void setArtisti(List<String> artisti) {
        this.artisti = artisti;
    }

    public eventoMusicale(String luogoEvento, String descrizione, float prezzoBiglietto, Enum<tipologiaEnum> tipologiaEvento,
                          String nome, LocaleData dataEvento, List<String> artisti) {
        super(luogoEvento, descrizione, prezzoBiglietto, tipologiaEvento, nome, dataEvento);
        this.artisti = artisti;
    }
}
