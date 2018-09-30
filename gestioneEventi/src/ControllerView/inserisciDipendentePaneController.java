package ControllerView;

import ControllerView.MostraAlert;
import DB.ImpiegatoDAO;
import DB.ImpiegatoDAOImp;
import Model.Impiegato;
import Model.MansioneEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import Controller.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class inserisciDipendentePaneController implements Initializable {

    @FXML
    private AnchorPane formInserisciDipedente;
    @FXML
    private TextField nomeDipendenteTextField;
    @FXML
    private TextField cognomeDipendenteTextField;
    @FXML
    private DatePicker dataNascitaDipendenteDatePicker;
    @FXML
    private TextField codFiscaleDipendenteTextField;
    //@FXML
    //private TextField indirizzoDipendenteTextField;
    @FXML
    private RadioButton sessoFDipendenteRadioButton;
    @FXML
    private RadioButton sessoMDipendenteRadioButton;
    @FXML
    private Button inserisciDipendenteButton;
    @FXML
    private RadioButton tipoContrattoFtimeDipendenteRatioButton;
    @FXML
    private RadioButton tipoContrattoPtimeDipendenteRatioButton;
    //@FXML
    //private DatePicker dataContrattoDipendenteDatePicker;
    @FXML
    private TextField stipendioDipendenteTextField;
    @FXML
    private TextField telefonoDipendenteTextField;
    @FXML
    private TextField emailDipendenteTextField;
    @FXML
    private TextField ibanDipendenteTextField;
    @FXML
    private Button annullaDipendenteButton;
    @FXML
    private ComboBox<MansioneEnum> mansioneDipendenteComboBox;
    @FXML
    private TextField usernameDipendenteTextField;
    @FXML
    private PasswordField passwordDipendentePasswordField;

    public String operazione="pulisci";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mansioneDipendenteComboBox.setItems(FXCollections.observableArrayList(MansioneEnum.values()));
    }
    public void annullaDipendenteButtonPressed(ActionEvent actionEvent) {
        tastoAnnullaInserisciDipendenti(operazione);

    }
    //lista tipo evento
    ObservableList<String> list = FXCollections.observableArrayList("Amministratore","Operatore");

    @FXML
    private void tipoContrattoPtimeDipendenteRadioButtonPressed(ActionEvent actionEvent) {
        tipoContrattoFtimeDipendenteRatioButton.setSelected(false);
    }
    @FXML
    private void tipoContrattoFtimeDipendenteRadioButtonPressed(ActionEvent actionEvent) {
        tipoContrattoPtimeDipendenteRatioButton.setSelected(false);
    }
    @FXML
    private void sessoMDipendenteRadioButtonPressed(ActionEvent actionEvent) {
        sessoFDipendenteRadioButton.setSelected(false);
    }
    @FXML
    private void sessoFDipendenteRadioButtonPressed(ActionEvent actionEvent) {
        sessoMDipendenteRadioButton.setSelected(false);
    }


    public TextField getStipendioDipendenteTextField() {
        return stipendioDipendenteTextField;
    }

    public TextField getNomeDipendenteTextField() {
        return nomeDipendenteTextField;
    }

    public TextField getCognomeDipendenteTextField() {
        return cognomeDipendenteTextField;
    }

    public TextField getCodFiscaleDipendenteTextField() {
        return codFiscaleDipendenteTextField;
    }

    /*public TextField getIndirizzoDipendenteTextField() {
        return indirizzoDipendenteTextField;
    }*/

    public RadioButton getSessoFDipendenteRatioButton() {
        return sessoFDipendenteRadioButton;
    }

    public RadioButton getSessoMDipendenteRadioButton() {
        return sessoMDipendenteRadioButton;
    }

    public Button getInserisciDipendenteButton() {
        return inserisciDipendenteButton;
    }

    public RadioButton getTipoContrattoFtimeDipendenteRatioButton() {
        return tipoContrattoFtimeDipendenteRatioButton;
    }

    public RadioButton getTipoContrattoPtimeDipendenteRatioButton() {
        return tipoContrattoPtimeDipendenteRatioButton;
    }

    //public DatePicker getDataContrattoDipendenteDatePicker() {
    //    return dataContrattoDipendenteDatePicker;
    //}

    public TextField getTelefonoDipendenteTextField() {
        return telefonoDipendenteTextField;
    }

    public TextField getEmailDipendenteTextField() {
        return emailDipendenteTextField;
    }

    public TextField getIbanDipendenteTextField() {
        return ibanDipendenteTextField;
    }

    public DatePicker getDataNascitaDipendenteDatePicker() {
        return dataNascitaDipendenteDatePicker;
    }

    public Button getAnnullaDipendenteButton() {
        return annullaDipendenteButton;
    }

    public ComboBox getMansioneDipendenteComboBox() {
        return mansioneDipendenteComboBox;
    }

    public AnchorPane getFormInserisciDipedente() {
        return formInserisciDipedente;
    }

    public String getOperazione() {
        return operazione;
    }

    public ObservableList<String> getList() {
        return list;
    }



    public void tastoAnnullaInserisciDipendenti(String operazione){
        if (operazione=="pulisci") {
            nomeDipendenteTextField.clear();
            cognomeDipendenteTextField.clear();
            codFiscaleDipendenteTextField.clear();
            //indirizzoDipendenteTextField.clear();
            dataNascitaDipendenteDatePicker.setValue(null);
            //dataContrattoDipendenteDatePicker.setValue(null);
            stipendioDipendenteTextField.clear();
            telefonoDipendenteTextField.clear();
            emailDipendenteTextField.clear();
            ibanDipendenteTextField.clear();
            sessoFDipendenteRadioButton.setSelected(false);
            sessoMDipendenteRadioButton.setSelected(false);
            tipoContrattoPtimeDipendenteRatioButton.setSelected(false);
            tipoContrattoFtimeDipendenteRatioButton.setSelected(false);
        }else {
          //  new CambiaView(formInserisciDipedente).caricaFormDaRisorsa(formInserisciDipedente, "cercaDipendentiPane.fxml");
        }
    }

    @FXML
    public void inserisciDipendenteButtonPressed() {
        try {
            controllaDatiDipendente();
            MostraAlert.mostraAlertImpiegatoInserito();
            //funzione per tornare al menu precedente
        }
        catch (NoValidEventDataException e) {
            MostraAlert.mostraAlertErroreInserimentoEvento(e.getMessagge());
        }
        catch( Exception e){
            e.printStackTrace();
            MostraAlert.mostraAlertErroreInserimentoEvento("Errore Inserimento Dipendente");
        }

    }

    /* Dovrà verificare che il dipendente non è già nel DB
    private void controlla() throws NoValidEventDataException {
    }*/

    private boolean controllaDatiDipendente() throws NoValidEventDataException, Exception {
        /***
         * Da implementare MANSIONE, IBAN
         ****/

        // Controllo nome dipendente: Diverso da NULL
        String nomeDipendente = nomeDipendenteTextField.getText();
        if (nomeDipendente == null || nomeDipendente.equals(""))
            throw new NoValidEventDataException("Nome non inserito");

        // Controllo cognome dipendente: Diverso da NULL
        String cognomeDipendente = cognomeDipendenteTextField.getText();
        if (cognomeDipendente == null || cognomeDipendente.equals(""))
            throw new NoValidEventDataException("Cognome non inserito");

        // Controllo data di nascita: Diverso da NULL
        LocalDate dataNascita = dataNascitaDipendenteDatePicker.getValue();
        if (dataNascita == null)
            throw new NoValidEventDataException("Data non inserita");

        // Controllo codice fiscale: Diverso da NULL e lenght!=16
        // Si potrebbe implementare un controllo più accurato per verificare che tutti i caratteri siano plausibili
        String codiceFiscale = codFiscaleDipendenteTextField.getText();
        if (codiceFiscale == null || codiceFiscale.equals("") || codiceFiscale.length() != 16)
            throw new NoValidEventDataException("Codice Fiscale non valido");

        //Controllo telefono
        //Da implementare
        String telefono = telefonoDipendenteTextField.getText();

        //Controllo email
        //Da implementare
        String email = emailDipendenteTextField.getText();

        //Controllo stipendio Diverso da NULL e >0 e che deve essere un Double
        Float stipendio = Float.valueOf(stipendioDipendenteTextField.getText());
        if (stipendio == null || stipendio <= 0.00)
            throw new NoValidEventDataException("Stipendio non valido");

        //Controllo username: Diverso da NULL
        String username = usernameDipendenteTextField.getText();
        if (username == null || username.equals(""))
            throw new NoValidEventDataException("Username non inserito");

        //Controllo password: Diverso da NULL
        String password = passwordDipendentePasswordField.getText();
        if (password == null || password.equals(""))
            throw new NoValidEventDataException("Password non inserita");

        //Controllo Mansione
        MansioneEnum  mansione = mansioneDipendenteComboBox.getValue();
        if (mansione == null) throw new NoValidEventDataException("Inserire una mansione");

        //Controllo IBAN
        //Da implementare
        String iban = ibanDipendenteTextField.getText();

        //Creazione oggetto impiegato
        Impiegato impiegato = new Impiegato(nomeDipendente, cognomeDipendente, dataNascita, codiceFiscale,
                username, password, LocalDate.now(), stipendio, mansione, telefono, iban, email, 0);
        ImpiegatoDAO impiegatoDAO = new ImpiegatoDAOImp(impiegato);


        impiegatoDAO.inserisciImpiegato();


        return true;
    }
}
