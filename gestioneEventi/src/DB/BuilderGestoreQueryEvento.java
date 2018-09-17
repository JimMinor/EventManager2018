package DB;

import Model.Evento;
import Model.EventoMusicale;
import Model.EventoSportivo;
import Model.EventoTeatrale;

public class BuilderGestoreQueryEvento {


    public static <T extends Evento> GestoreQueryInserimentoEvento buildGestoreEvento( T eventoDaInserire) {

        if(eventoDaInserire instanceof  EventoMusicale) return new GestoreQueryInserimentoEventoMusicale((EventoMusicale)eventoDaInserire);
        if(eventoDaInserire instanceof EventoSportivo) return new GestoreQueryInserimentoEventoSportivo((EventoSportivo)eventoDaInserire);
        if(eventoDaInserire instanceof EventoTeatrale) return new GestoreQueryInserimentoEventoTeatrale((EventoTeatrale)eventoDaInserire);
        return null;
    }

}
