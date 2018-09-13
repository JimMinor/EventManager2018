package Controller;

@FunctionalInterface
/**
 * Questa Interface ci serve per riconoscere
 * i controller dei file FXML, in modo che
 * tutte le classi controller che implementano questa
 * interfaccia, possono
 */
public interface ControlledStage {

    public void setCambiaStage(CambiaStage cambiaStage);

}
