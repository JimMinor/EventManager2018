package Model;

import java.time.LocalDate;
import java.util.Set;
public class EventoManifestazione extends Evento {

    private GenereManifestazioneEnum genereFestival;
    private Set<String> specialGuest;





    public EventoManifestazione(LuogoEnum luogoEvento, String descrizione, float prezzoBiglietto, TipologiaEnum tipologiaEvento, String nome, LocalDate dataEvento) {
        super(luogoEvento, descrizione, prezzoBiglietto, tipologiaEvento, nome, dataEvento);
        this.genereFestival=genereFestival;
        this.specialGuest=specialGuest;
    }
    public GenereManifestazioneEnum getGenereFestival(){return  genereFestival;}

    public Set<String> getSpecialGuest() {
        return specialGuest;
    }
}
