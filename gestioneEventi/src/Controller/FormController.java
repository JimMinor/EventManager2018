package Controller;

import Model.GenereManifestazioneEnum;
import Model.GenereMusicaleEnum;
import Model.GenereTeatroEnum;
import View.EventoArtisticoForm;
import View.EventoSportivoForm;
import View.InserisciEventoForm;
import View.SelezioneTipoEventoForm;
import Model.TipologiaEnum;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class FormController {

    private Map<String,String> risorseForm;
    private Map<TipologiaEnum,String> eventiSpecificiFormMap; // EnumMap
    private AnchorPane formCorrente;
    private Node formAggiuntivo;

    public FormController(AnchorPane formCorrente){
        this.formCorrente=formCorrente;
        // Carico tutti i form in un HashMap<String,Resource>
        risorseForm=new HashMap<>();
        caricaRisorseForm();

    }

    private void caricaRisorseForm() {
        risorseForm.put("creaEvento","../FXML/inserisciEventoPane.fxml");
        risorseForm.put("tipoEvento","../FXML/tipoEventoPane.fxml");

    }

    private FXMLLoader caricaFormDaRisorsa(String risorsa) {
            pulisciForm();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource((risorseForm.get(risorsa))));
            return fxmlLoader;
    }

    public void pulisciForm() {
        formCorrente.getChildren().clear();
    }

    /************************************************
     *                                              *
     *      CREAZIONE FORM INSERISCI EVENTO         *
     *                                              *
     * **********************************************
     */

    private void inserisciFormEventoSpecifico() {
        eventiSpecificiFormMap = new EnumMap<>(TipologiaEnum.class);
        eventiSpecificiFormMap.put(TipologiaEnum.MUSICALE,"../FXML/eventoArtisticoPane.fxml");
        eventiSpecificiFormMap.put(TipologiaEnum.TEATRO,"../FXML/eventoArtisticoPane.fxml");
        eventiSpecificiFormMap.put(TipologiaEnum.SPORTIVO,"../FXML/eventoSportivoPane.fxml");
        eventiSpecificiFormMap.put(TipologiaEnum.MANIFESTAZIONI,"../FXML/eventoManifestazionePane.fxml");

    }

    public void mostraFormInserisciEvento(TipologiaEnum tipologia){
        FXMLLoader loader = caricaFormDaRisorsa("creaEvento");
        EventoController controllaDatiEvento = new EventoController();
        EventoSpecificoForm eventoSpecifico=creaFormEventoSpecifico(tipologia,controllaDatiEvento);

        try{
            InserisciEventoForm ief=new InserisciEventoForm(this,eventoSpecifico,
                    controllaDatiEvento);

            loader.setController(ief);
            Node form = loader.load();
            formCorrente.getChildren().add(form);

            //Viene settato il pane per la visualizzazione del form dell'evento specifico
            ief.getGenereEventoAnchorPane().getChildren().add(formAggiuntivo);
            ief.setTipologiaEvento(tipologia);

        }catch(Exception e) {e.printStackTrace();}
    }

    private EventoSpecificoForm creaFormEventoSpecifico(TipologiaEnum tipologia, EventoController controllaDatiEvento) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(eventiSpecificiFormMap.get(tipologia)));
        EventoSpecificoForm eventoSpecifico=null;

        if(tipologia==TipologiaEnum.SPORTIVO)
                    eventoSpecifico = setFXMLFileControllerEventoSpecifico(loader,new EventoSportivoForm(controllaDatiEvento));
        if(tipologia==TipologiaEnum.MUSICALE)
                    eventoSpecifico = setFXMLFileControllerEventoSpecifico(loader,new EventoArtisticoForm<GenereMusicaleEnum>(controllaDatiEvento, GenereMusicaleEnum.class));
        if(tipologia == TipologiaEnum.TEATRO)
                    eventoSpecifico = setFXMLFileControllerEventoSpecifico(loader,new EventoArtisticoForm<GenereTeatroEnum>(controllaDatiEvento, GenereTeatroEnum.class));
        if(tipologia == TipologiaEnum.MANIFESTAZIONI)
            eventoSpecifico = setFXMLFileControllerEventoSpecifico(loader,new EventoArtisticoForm<GenereManifestazioneEnum>(controllaDatiEvento, GenereManifestazioneEnum.class));

        return eventoSpecifico;

    }

    private EventoSpecificoForm setFXMLFileControllerEventoSpecifico(FXMLLoader loader, EventoSpecificoForm eventoSpecificoForm) {
        try {
            loader.setController(eventoSpecificoForm);
            formAggiuntivo= loader.load();
            return eventoSpecificoForm;
        }
        catch(Exception e ){ e.printStackTrace(); }
        return null;
    }

    public void mostraFormTipoEvento() {
        try {
           FXMLLoader loader=caricaFormDaRisorsa("tipoEvento");
           loader.setController(new SelezioneTipoEventoForm(this));
           Node form = loader.load();
           formCorrente.getChildren().add(form);
       }catch(Exception e){
           e.printStackTrace();
       }

        inserisciFormEventoSpecifico();
    }

    public void mostraFormCercaEvento() {
        caricaFormDaRisorsa("cercaEvento");
    }

    public void mostraFormGestioneClienti() {
        caricaFormDaRisorsa("gestioneClienti");
    }

    public void mostraFormGestioneDipendeti() {
        caricaFormDaRisorsa("gestioneDipedenti");
    }

    public void mostraStaticheMenu() {
    }


}
