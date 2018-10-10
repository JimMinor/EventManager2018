package Control;

import DB.AddettoDAO;
import DB.AddettoDAOImp;
import Model.Addetto;
import View.InserisciAddettoView;
import View.MostraAlert;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

import java.time.LocalDate;

import static Control.ControlloSintassi.controllaSintassiCF;
import static Control.ControlloSintassi.controllaSintassiEmail;
import static Control.ControlloSintassi.controllaSintassiIban;
public class InserisciAddettoController {

    private InserisciAddettoView inserisciAddettoView;
    private MenuPrincipaleController menuPrincipaleController;
    private AddettoDAO addettoDAO;

    public InserisciAddettoController(InserisciAddettoView inserisciAddettoView, MenuPrincipaleController menuPrincipaleController) {
        this.inserisciAddettoView = inserisciAddettoView;
        this.menuPrincipaleController = menuPrincipaleController;
        this.addettoDAO = new AddettoDAOImp();
        setListenerInserisciAddettoView();
    }

    private void setListenerInserisciAddettoView() {

        setListenerTelefonoTextField();
        setListenerStipendioTextField();
        setListenerCFTextField();
        setListenerAnnullaButton();
        setListenerInserisciButton();
    }

    private void setListenerInserisciButton() {
        inserisciAddettoView.getInserisciAddettoButton().addEventHandler(
                ActionEvent.ACTION, event -> Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            controllaDatiAddetto();
                        } catch ( Exception e ) {
                            e.printStackTrace();
                            MostraAlert.mostraAlertErroreInserimentoDati(e.getMessage());
                        }
                    }
                })
        );
    }

    private void setListenerAnnullaButton() {
        inserisciAddettoView.getAnnullaAddettoButton().
                addEventHandler(ActionEvent.ACTION, event->Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        menuPrincipaleController.mostraFormAddetti();
                    }
                }));
    }



    private void setListenerCFTextField() {

        inserisciAddettoView.getCodFiscaleAddettoTextField().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inserisciAddettoView.getCodFiscaleAddettoTextField().setText(newValue.toUpperCase());
                }
            }
        });
    }

    private void setListenerStipendioTextField() {

        inserisciAddettoView.getStipendioAddettoTextField().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d\\.\\d")) {
                    inserisciAddettoView.getStipendioAddettoTextField().setText(newValue.replaceAll("[^\\d\\.\\d]", ""));
                }
            }
        });
    }

    private void setListenerTelefonoTextField() {
        inserisciAddettoView.getTelefonoAddettoTextField().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inserisciAddettoView.getTelefonoAddettoTextField().setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }


    private boolean controllaDatiAddetto() throws NoValidEventDataException, Exception {

        // Controllo nome addetto: Diverso da NULL
        String nomeAddetto = inserisciAddettoView.getNomeAddettoTextField().getText();
        if (nomeAddetto.equals(""))
            throw new NoValidEventDataException("Nome non inserito");

        // Controllo cognome Addetto: Diverso da NULL
        String cognomeAddetto = inserisciAddettoView.getCognomeAddettoTextField().getText();
        if (cognomeAddetto.equals(""))
            throw new NoValidEventDataException("Cognome non inserito");

        // Controllo data di nascita: Diverso da NULL
        LocalDate dataNascita = inserisciAddettoView.getDataNascitaAddettoDatePicker().getValue();
        if (dataNascita == null)
            throw new NoValidEventDataException("Data non inserita");

        // Controllo codice fiscale: lenght = 16 e controllo regex
        String codiceFiscale = inserisciAddettoView.getCodFiscaleAddettoTextField().getText();
        if (codiceFiscale.length() != 16 || !controllaSintassiCF(codiceFiscale))
            throw new NoValidEventDataException("Codice Fiscale non valido");

        //Controllo telefono
        String telefono = inserisciAddettoView.getTelefonoAddettoTextField().getText();
        if (telefono.equals("") || telefono.length() < 9)
            throw new NoValidEventDataException("Telefono non valido");

        //Controllo email: controllo regex
        String email = inserisciAddettoView.getEmailAddettoTextField().getText();
        if (!controllaSintassiEmail(email))
            throw new NoValidEventDataException("Email non valida");

        //Controllo IBAN
        String iban = inserisciAddettoView.getIbanAddettoTextField().getText();
        if (iban.length() != 27 || !controllaSintassiIban(iban))
            throw new NoValidEventDataException("IBAN non valido");


        //Controllo stipendio Diverso da NULL (non è necessario controllo segno perché l'input è limitato)
        Float stipendio;
        if (inserisciAddettoView.getStipendioAddettoTextField().getText().equals(""))
            throw new NoValidEventDataException("Stipendio non valido");
        else
            stipendio = Float.valueOf(inserisciAddettoView.getStipendioAddettoTextField().getText());




        //Creazione oggetto Addetto
        Addetto addetto = new Addetto(nomeAddetto, cognomeAddetto, dataNascita, codiceFiscale, LocalDate.now(), stipendio, telefono, iban, email, 0);
        AddettoDAO addettoDAO = new AddettoDAOImp(addetto);


        addettoDAO.inserisciAddetto();


        return true;
    }
}