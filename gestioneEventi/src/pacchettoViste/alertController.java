package pacchettoViste;

import javafx.scene.control.Alert;

public class alertController {

    public static void mostraAlertLogin(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText("Utente e password non corretti!");

        alert.showAndWait();
    }
}