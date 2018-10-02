package View;

import DB.ImpiegatoDAO;
import DB.ImpiegatoDAOImp;
import Model.Impiegato;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import static Controller.ControlloSintassi.controllaSintassiCF;
import static Controller.ControlloSintassi.controllaSintassiEmail;
import static Controller.ControlloSintassi.controllaSintassiIban;

public class InserisciDipedenteControllerView implements Initializable {

    @FXML private AnchorPane formInserisciDipedente;
    @FXML private TextField nomeDipendenteTextField;
    @FXML private TextField cognomeDipendenteTextField;
    @FXML private DatePicker dataNascitaDipendenteDatePicker;
    @FXML private TextField codFiscaleDipendenteTextField;
    @FXML private Button inserisciDipendenteButton;
    @FXML private TextField stipendioDipendenteTextField;
    @FXML private TextField telefonoDipendenteTextField;
    @FXML private TextField emailDipendenteTextField;
    @FXML private TextField ibanDipendenteTextField;
    @FXML private Button annullaDipendenteButton;
    @FXML private ComboBox mansioneDipendenteComboBox;
    @FXML private TextField usernameDipendenteTextField;
    @FXML private PasswordField passwordDipendentePasswordField;

    public String operazione="pulisci";

    //lista mansioni
    ObservableList<String> list = FXCollections.observableArrayList("Amministratore","Operatore");


    public ObservableList<String> getList() {
        return list;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mansioneDipendenteComboBox.setItems(list);

        //Forza l'inserimento di valori numerici nel campo "Telefono"
        telefonoDipendenteTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    telefonoDipendenteTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        //Forza l'inserimento di valori float nel campo "Stipendio"
        stipendioDipendenteTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d\\.\\d")) {
                    stipendioDipendenteTextField.setText(newValue.replaceAll("[^\\d\\.\\d]", ""));
                }
            }
        });

        //Forza l'inserimento di caratteri maiuscoli nel campo "Codice Fiscale"
        codFiscaleDipendenteTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    codFiscaleDipendenteTextField.setText(newValue.toUpperCase());
                }
            }
        });

        //Forza l'inserimento di caratteri maiuscoli nel campo "IBAN"
        ibanDipendenteTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    ibanDipendenteTextField.setText(newValue.toUpperCase());
                }
            }
        });
    }



    public void annullaDipendenteButtonPressed(ActionEvent actionEvent) {
        tastoAnnullaInserisciDipendenti(operazione);
    }

    public void tastoAnnullaInserisciDipendenti(String operazione){
        if (operazione=="pulisci") {
            nomeDipendenteTextField.clear();
            cognomeDipendenteTextField.clear();
            codFiscaleDipendenteTextField.clear();
            dataNascitaDipendenteDatePicker.setValue(null);
            stipendioDipendenteTextField.clear();
            telefonoDipendenteTextField.clear();
            emailDipendenteTextField.clear();
            ibanDipendenteTextField.clear();
        }else {
          //  new CambiaView(formInserisciDipedente).caricaFormDaRisorsa(formInserisciDipedente, "cercaDipendentiPane.fxml");
        }
    }

    @FXML
    public void inserisciDipendenteButtonPressed() {
        try {
            controllaDatiDipendente();
            //controlla();
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

        // Controllo nome dipendente: Diverso da NULL
        String nomeDipendente = nomeDipendenteTextField.getText();
        if (nomeDipendente.equals(""))
            throw new NoValidEventDataException("Nome non inserito");

        // Controllo cognome dipendente: Diverso da NULL
        String cognomeDipendente = cognomeDipendenteTextField.getText();
        if (cognomeDipendente.equals(""))
            throw new NoValidEventDataException("Cognome non inserito");

        // Controllo data di nascita: Diverso da NULL
        LocalDate dataNascita = dataNascitaDipendenteDatePicker.getValue();
        if (dataNascita == null)
            throw new NoValidEventDataException("Data non inserita");

        // Controllo codice fiscale: lenght = 16 e controllo regex
        String codiceFiscale = codFiscaleDipendenteTextField.getText();
        if (codiceFiscale.length() != 16 || !controllaSintassiCF(codiceFiscale))
            throw new NoValidEventDataException("Codice Fiscale non valido");

        //Controllo telefono
        String telefono = telefonoDipendenteTextField.getText();
        if (telefono.equals("") || telefono.length() < 9)
            throw new NoValidEventDataException("Telefono non valido");

        //Controllo email: controllo regex
        String email = emailDipendenteTextField.getText();
        if (!controllaSintassiEmail(email))
            throw new NoValidEventDataException("Email non valida");

        //Controllo IBAN
        String iban = ibanDipendenteTextField.getText();
        if (iban.length() != 27 || !controllaSintassiIban(iban))
            throw new NoValidEventDataException("IBAN non valido");

        //Controllo Mansione != NULL
        String  mansione;
        if (mansioneDipendenteComboBox.getValue() == null)
            throw new NoValidEventDataException("Inserire una mansione");
        else
            mansione = mansioneDipendenteComboBox.getValue().toString();

        //Controllo stipendio Diverso da NULL (non è necessario controllo segno perché l'input è limitato)
        Float stipendio;
        if (stipendioDipendenteTextField.getText().equals(""))
            throw new NoValidEventDataException("Stipendio non valido");
        else
            stipendio = Float.valueOf(stipendioDipendenteTextField.getText());

        //Controllo username: Diverso da NULL
        String username = usernameDipendenteTextField.getText();
        if (username.equals(""))
            throw new NoValidEventDataException("Username non inserito");

        //Controllo password: Diverso da NULL
        String password = passwordDipendentePasswordField.getText();
        if (password.equals(""))
            throw new NoValidEventDataException("Password non inserita");



        //Creazione oggetto impiegato
        Impiegato impiegato = new Impiegato(nomeDipendente, cognomeDipendente, dataNascita, codiceFiscale,
                username, password, LocalDate.now(), stipendio, mansione, telefono, iban, email, 0);
        ImpiegatoDAO impiegatoDAO = new ImpiegatoDAOImp(impiegato);


        impiegatoDAO.inserisciImpiegato();


        return true;
    }
}
