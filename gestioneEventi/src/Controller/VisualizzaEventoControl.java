package Controller;

import ControllerView.CercaEventoControllerView;
import Model.CercaEventiModel;

public class VisualizzaEventoControl {

    private CercaEventiModel cercaEventiModel;
    private CercaEventoControllerView cercaEventoControllerView;

    public VisualizzaEventoControl (CercaEventiModel cercaEventoModel,
                                    CercaEventoControllerView cercaEventoControllerView){
        this.cercaEventiModel=cercaEventoModel;
        this.cercaEventoControllerView=cercaEventoControllerView;

    }


}
