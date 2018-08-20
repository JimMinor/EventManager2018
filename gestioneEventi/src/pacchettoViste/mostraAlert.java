package pacchettoViste;

import javafx.scene.control.Alert;

public  class mostraAlert {

    public static void mostraAlertLogin(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText("Utente e password non corretti!");

        alert.showAndWait();
    }
    public static void mostraAlertErroreDB(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText("Errore di connessione!");

        alert.showAndWait();

    }
}
