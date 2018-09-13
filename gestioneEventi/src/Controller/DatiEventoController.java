package Controller;

import DB.InserisciEventoDAO;
import DB.InserisciEventoDB;
import View.EventoSportivoForm;
import View.InserisciEventoForm;
import Model.EventoSportivo;
import Model.LuogoEnum;
import Model.TipologiaEnum;

import java.time.LocalDate;
import java.util.Set;

public class DatiEventoController {

    private LocalDate dataEvento;
    private String nomeEvento;
    private Float prezzoBiglietto;
    private TipologiaEnum tipologiaEvento;
    private LuogoEnum luogoEvento;
    private String descrizioneEvento;

    public void controllaDatiEventoGenerico(InserisciEventoForm dati) throws NoValidEventDateException
    {
        // Controllo DATE: Diverso da NULL e data non passata
         dataEvento = dati.getDataEventoDatePicker().getValue();
        if( dataEvento== null || dataEvento.isBefore(LocalDate.now())) throw new NoValidEventDateException("Data Non Valida");

        // Controllo NOME EVENTO: Diverso da NULL e almeno lenght>=8
        nomeEvento = dati.getNomeEventoTextField().getText();
        if(nomeEvento==null || nomeEvento.equals("") || nomeEvento.length()<8) throw new NoValidEventDateException("Nome non inserito, oppure" +
                "numero di caratteri minimo non raggiunto");

        //Controllo Prezzo Biglietto: Diverso da NULL e >0 e che deve essere un Double
          prezzoBiglietto = Float.valueOf(dati.getPrezzoBigliettoTextField().getText());
        if(prezzoBiglietto == null || prezzoBiglietto<=0.00) throw  new NoValidEventDateException("Prezzo biglietto non valido");

        // Controllo che TipologiaEvento e LuogoEvento non siano vuoti(non selezionati)
        tipologiaEvento = dati.getTipologiaEvento();
        if(tipologiaEvento==null) throw new NoValidEventDateException("Inserire tipologia di evento");

        luogoEvento = dati.getLuogoEventoComboBox().getValue();
        if(luogoEvento==null) throw new NoValidEventDateException("Inserire luogo dell'evento");

        // Controllo DESCRIZIONE: MAX 200 Caratteri può essere null
        descrizioneEvento=dati.getDescrizioneEventoTextArea().getText();
        if(descrizioneEvento==null) descrizioneEvento="";//Puo' essere null
        if(descrizioneEvento.length()>200) throw new  NoValidEventDateException("Descrizione" +
                "supera i limiti concessi");
    }

    public void controllaDatiEventoSportivo(EventoSportivoForm eventoSportivoForm) throws NoValidEventDateException {

        // Controllo SPORT: Deve essere stato selezionato lo sport
        String sport = eventoSportivoForm.getSportEnumComboBox().getValue().name();
        if(sport == null || sport.equals("")) throw new NoValidEventDateException("Selezionare uno sport");

        // Controllo Numero partecipanti: Almeno 2
        Set<String> partecipanti = eventoSportivoForm.getPartecipantiList();
        if(partecipanti.size()<2) throw new NoValidEventDateException("Ci devono essere almeno due partecipanti");

        // Crea l'evento sportivo
        EventoSportivo eventoSportivo = new EventoSportivo(luogoEvento,descrizioneEvento,prezzoBiglietto,
                tipologiaEvento,nomeEvento,dataEvento,sport,partecipanti);
        InserisciEventoDAO inserisciEventoDAO = new InserisciEventoDB(eventoSportivo);
        inserisciEventoDAO.inserisciEvento();
    }


}
