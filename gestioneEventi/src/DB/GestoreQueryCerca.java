
package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;

public class GestoreQueryCerca {//query generica per cercare tutti gli elementi appena apre la schermata


    public ResultSet cerca(String tabella,String colonnaTW1 ,String colonnaTW2 , String colonnaTW3, String attributo1 ,String attributo2 , Date attributo3 ) throws SQLException{

        // Connect to database
        //non ho capito com si fa xD

        try {
            Connection connection = UtilityDB.getConnessioneDB();
            // Create tutti i risultati in una tabella
            String selectSql="";

            //(1)
            if (attributo1!=null && attributo2==null && attributo3==null) {
                selectSql = "SELECT " + colonnaTW1 + "," + colonnaTW2 + "," + colonnaTW3 +
                        " FROM " + tabella +
                        " WHERE " + colonnaTW1 + "=" + attributo1 + ";";
            }

            //(2)
            else if (attributo1==null && attributo2!=null && attributo3==null) {
                selectSql = "SELECT " + colonnaTW1 + "," + colonnaTW2 + "," + colonnaTW3 +
                        " FROM " + tabella +
                        " WHERE " + colonnaTW2 + "=" + attributo2 + ";";
            }

            //(3)
            else if (attributo1==null && attributo2==null && attributo3!=null) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(attributo3);
                selectSql = "SELECT " + colonnaTW1 + "," + colonnaTW2 + "," + colonnaTW3 +
                        " FROM " + tabella +
                        " WHERE DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
            }

            //(1,2)
            else if (attributo1!=null && attributo2!=null && attributo3==null) {
                selectSql = "SELECT " + colonnaTW1 + "," + colonnaTW2 + "," + colonnaTW3 +
                        " FROM " + tabella +
                        " WHERE " + colonnaTW1 + "=" + attributo1 + " AND " + colonnaTW2 + "=" + attributo2 + ";";
            }

            //(1,3)
            else if (attributo1!=null && attributo2==null && attributo3!=null) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(attributo3);
                selectSql = "SELECT " + colonnaTW1 + "," + colonnaTW2 + "," + colonnaTW3 +
                        " FROM " + tabella +
                        " WHERE " + colonnaTW1 + "=" + attributo1 + " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
            }

            //(2,3)
            else if (attributo1==null && attributo2!=null && attributo3!=null) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(attributo3);
                selectSql = "SELECT " + colonnaTW1 + "," + colonnaTW2 + "," + colonnaTW3 +
                        " FROM " + tabella +
                        " WHERE " + colonnaTW2 + "=" + attributo2 + " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
            }

            //(1,2,3)
            else if (attributo1!=null && attributo2!=null && attributo3!=null) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(attributo3);
                selectSql = "SELECT " + colonnaTW1 + "," + colonnaTW2 + "," + colonnaTW3 +
                        " FROM " + tabella +
                        " WHERE " + colonnaTW1 + "=" + attributo1 + " AND "+ colonnaTW2 + "=" + attributo2 + " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
            }


            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(selectSql)) {

                connection.close();
                return rS;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void getAllInfo(TableView tabella,String nomeTabella,String colonnaTW1 ,String colonnaTW2 , String colonnaTW3, String attributo1 ,String attributo2 , Date attributo3 ,ObservableList data) {
        Statement st = null;
        ResultSet rs;
        String driver = "org.h2.Driver";

        try {


            rs = cerca(nomeTabella,colonnaTW1,colonnaTW2,colonnaTW3,attributo1,attributo2,attributo3);
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
            // CATCH QUALCOSA
        }
    }


}

