package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GestoreQueryCerca {//query generica per cercare tutti gli elementi appena apre la schermata

    public ResultSet cerca(String tabella) {

        // Connect to database
        //non ho capito com si fa xD

        try {
            Connection connection = UtilityDB.getConnessioneDB();
            // Create tutti i risultati in una tabella
            String selectSql = "SELECT * " +
                    "FROM " + tabella;


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
}
