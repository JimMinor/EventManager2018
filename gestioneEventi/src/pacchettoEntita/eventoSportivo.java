package pacchettoEntita;

import sun.util.resources.LocaleData;

import java.util.List;

public class eventoSportivo extends  Evento {

    public eventoSportivo(String luogoEvento, String descrizione, float prezzoBiglietto, Enum<tipologiaEnum> tipologiaEvento,
                          String nome, LocaleData dataEvento, Enum<sportEnum> sport, List<String> partecipanti) {
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

    public void setPartecipanti(List<String> partecipanti) {
        this.partecipanti = partecipanti;
    }

    private Enum<sportEnum> sport;
    private List<String> partecipanti;


}