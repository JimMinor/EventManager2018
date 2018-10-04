package Control;

@FunctionalInterface
/**
 * Questa Interface ci serve per riconoscere
 * i controller dei file FXMLView, in modo che
 * tutte le classi controller che implementano questa
 * interfaccia, possono
 */
public interface ControlledStage {

    void setCambiaStage(CambiaStage cambiaStage);

}
