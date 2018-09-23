package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestoreQueryCerca {//query generica per cercare tutti gli elementi appena apre la schermata


    public ResultSet cerca(String tabella,String attributo1,String attributo2, String attributo3) {

        // Connect to database
        //non ho capito com si fa xD

        try {
            Connection connection = UtilityDB.getConnessioneDB();
             // Create tutti i risultati in una tabella
            String selectSql = "SELECT  " + attributo1 +","+attributo2+","+attributo3+
                    "FROM " + tabella+";";


            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(selectSql)) {

                connection.close();
                return rS;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ResultSet cerca1attributo(String tabella) {


        try {
            Connection connection = UtilityDB.getConnessioneDB();
            // Create tutti i risultati in una tabella
            String selectSql = "SELECT * " +
                    "FROM " + tabella+";";


            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(selectSql)) {

                connection.close();
                return rS;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void getAllInfo(String Nometabella,String attributo1,String attributo2, String attributo3, TableView tabella ,ObservableList data) {
        Statement st = null;
        ResultSet rs;
        String driver = "org.h2.Driver";

        try {


            rs = cerca(Nometabella,attributo1,attributo2,attributo3);
            while (rs.next()) {
                ObservableList row = FXCollections.observableArrayList();

                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.add(rs.getString(i));
                    System.out.println(row);
                }

                data.add(row);

            }
            tabella.setItems(data);

        } catch (Exception e ) {
            // CATCH SOMETHING
        }
    }

}

