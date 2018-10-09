package View;

import javafx.scene.control.Alert;


public class MostraAlert {

    public static void mostraAlertLogin() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText("Utente e password non corretti!");
        alert.showAndWait();
    }

    public static void mostraAlertErroreDB() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText("Errore di connessione!");

        alert.showAndWait();

    }

    public static void mostraAlertErroreInserimentoDati(String messagge) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dati Errati");
        alert.setHeaderText(null);
        alert.setContentText(messagge);
        alert.showAndWait();
    }
    public static void mostraAlertEventoInserito(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successo");
        alert.setContentText("L'evento e' stato inserito con successo");
        alert.showAndWait();
    }

    public static void mostraAlertImpiegatoInserito(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successo");
        alert.setContentText("L'impiegato e' stato inserito con successo");
        alert.showAndWait();
    }

    public static void mostraAlertAddettoEliminato() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successo");
        alert.setContentText("L'addetto e' stato eliminato con successo");
        alert.showAndWait();
    }
}
