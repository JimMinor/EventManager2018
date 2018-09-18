package DB;

import Model.*;

public class BuilderGestoreQueryEvento {


    public BuilderGestoreQueryEvento() {
    }

    public static <T extends Evento> GestoreQueryInserimentoEvento buildGestoreEvento(T eventoDaInserire) {

        if(eventoDaInserire instanceof  EventoMusicale) return new GestoreQueryInserimentoEventoMusicale((EventoMusicale)eventoDaInserire);
        if(eventoDaInserire instanceof EventoSportivo) return new GestoreQueryInserimentoEventoSportivo((EventoSportivo)eventoDaInserire);
        if(eventoDaInserire instanceof EventoTeatrale) return new GestoreQueryInserimentoEventoTeatrale((EventoTeatrale)eventoDaInserire);
        if(eventoDaInserire instanceof EventoManifestazione) return new GestoreQueryInserimentoEventoManifestazione((EventoManifestazione)eventoDaInserire);
        return null;
    }

}
