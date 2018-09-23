package Controller;

import DB.InserisciEventoDAO;
import DB.InserisciEventoDB;
import Model.*;
import View.EventoArtisticoForm;
import View.EventoSportivoForm;
import View.InserisciEventoForm;
import View.EventoManifestazioneForm;

import javax.swing.text.TableView;
import java.time.LocalDate;
import java.util.Set;

public class EventoController {

    private LocalDate dataEvento;
    private String nomeEvento;
    private Float prezzoBiglietto;
    private TipologiaEnum tipologiaEvento;
    private LuogoEnum luogoEvento;
    private String descrizioneEvento;


    public void controllaDatiEventoGenerico(InserisciEventoForm dati) throws NoValidEventDataException
    {
        // Controllo DATE: Diverso da NULL e data non passata
         dataEvento = dati.getDataEventoDatePicker().getValue();
        if( dataEvento== null || dataEvento.isBefore(LocalDate.now())) throw new NoValidEventDataException("Data Non Valida");

        // Controllo NOME EVENTO: Diverso da NULL e almeno lenght>=8
        nomeEvento = dati.getNomeEventoTextField().getText();
        if(nomeEvento==null || nomeEvento.equals("") || nomeEvento.length()<8) throw new NoValidEventDataException("Nome non inserito, oppure" +
                "numero di caratteri minimo non raggiunto");

        //Controllo Prezzo Biglietto: Diverso da NULL e >0 e che deve essere un Double
          prezzoBiglietto = Float.valueOf(dati.getPrezzoBigliettoTextField().getText());
        if(prezzoBiglietto == null || prezzoBiglietto<=0.00) throw  new NoValidEventDataException("Prezzo biglietto non valido");

        // Controllo che TipologiaEvento e LuogoEvento non siano vuoti(non selezionati)
        tipologiaEvento = dati.getTipologiaEvento();
        if(tipologiaEvento==null) throw new NoValidEventDataException("Inserire tipologia di evento");

        luogoEvento = dati.getLuogoEventoComboBox().getValue();
        if(luogoEvento==null) throw new NoValidEventDataException("Inserire luogo dell'evento");

        // Controllo DESCRIZIONE: MAX 200 Caratteri può essere null
        descrizioneEvento=dati.getDescrizioneEventoTextArea().getText();
        if(descrizioneEvento==null) descrizioneEvento="";//Puo' essere null
        if(descrizioneEvento.length()>200) throw new NoValidEventDataException("Descrizione" +
                "supera i limiti concessi");
    }

    public void controllaDatiEventoSportivo(EventoSportivoForm datiEventoSportivo) throws NoValidEventDataException {

        // Controllo SPORT: Deve essere stato selezionato lo sport
        SportEnum sport = datiEventoSportivo.getSportEnumComboBox().getValue();
        if(sport == null || sport.equals("")) throw new NoValidEventDataException("Selezionare uno sport");

        // Controllo Numero partecipanti: Almeno 2 o piu'
        Set<String> partecipanti = datiEventoSportivo.getPartecipanti();
        SportEnum sportSelezionato = datiEventoSportivo.getSportEnumComboBox().getValue();
        // Sport che ammettono piu' di 2 partecipanti
        if(sportSelezionato==SportEnum.ATELTICA || sportSelezionato==SportEnum.NUOTO || sportSelezionato==SportEnum.CICLISMO)
            if(partecipanti.size()<2) throw new NoValidEventDataException("Per lo sport selezionato servono piu' partecipanti," +
                    " inserisci altri partecipanti");
        if(partecipanti.size()!=2) throw new NoValidEventDataException("Per lo sporto selezionato il numero di partecipanti," +
                " deve essere pari a 2");

        // Crea l'evento sportivo
        InserisciEventoDAO eventoDAO=  new InserisciEventoDB(new EventoSportivo(luogoEvento,descrizioneEvento,prezzoBiglietto,
                tipologiaEvento,nomeEvento,dataEvento,sport,partecipanti));
        eventoDAO.inserisciEvento();

    }


    public void controllaDatiEventoArtistico(EventoArtisticoForm eventoArtisticoForm)throws NoValidEventDataException {
        // Controllo GENERE : Deve essere stato selezionato un genere
        Enum<? extends Enum<?>> genere;
        genere = eventoArtisticoForm.getGenereSpettacoloComboBox();
        if(genere == null || genere.equals("")) throw new NoValidEventDataException("Selezionare un genere musicale");

        // Controllo Numero artisti
        Set<String> artista= eventoArtisticoForm.getArtisti();
        if(artista.equals("") || artista == null) throw new NoValidEventDataException("Inserire almeno un artista");

         // Controllo effettuati, inserisco l'evento:
        if(genere instanceof GenereMusicaleEnum) {
            InserisciEventoDAO eventoDAO = new InserisciEventoDB(new EventoMusicale(luogoEvento, descrizioneEvento,prezzoBiglietto, tipologiaEvento, nomeEvento, dataEvento,(GenereMusicaleEnum) genere, artista));
            eventoDAO.inserisciEvento();
        }

        if(genere instanceof GenereTeatroEnum) {
            InserisciEventoDAO eventoDAO = new InserisciEventoDB(new EventoTeatrale(luogoEvento, descrizioneEvento, prezzoBiglietto,
                    tipologiaEvento, nomeEvento, dataEvento, (GenereTeatroEnum) genere, artista));
            eventoDAO.inserisciEvento();
        }
    }
}




