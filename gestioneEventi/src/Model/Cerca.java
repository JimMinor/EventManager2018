package Model;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Cerca {
    public void modifica_tableview (TableView tabella, ObservableList data){
        tabella.setItems(data);
    }
}
