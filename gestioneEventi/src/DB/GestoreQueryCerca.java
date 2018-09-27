
package DB;

import Model.Cliente;
import Model.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GestoreQueryCerca {//query generica per cercare tutti gli elementi appena apre la schermata

    public ArrayList<Cliente> cercaCliente(String username){
        ArrayList<Cliente> clienti =new ArrayList<Cliente>();
        Cliente row=null;
        try {
            Connection connection = UtilityDB.getConnessioneDB();
            // Create tutti i risultati in una tabella
            String selectSql =String.format("SELECT * FROM CLIENTE NATURAL JOIN PERSONA ") ;
            //{0}
            if (!username.equals("")) {
                selectSql += "WHERE CLIENTE.USERNAME ='"+username+"'";
            }
            //{1}

            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(selectSql)) {

                connection.close();
                while (rS.next()) {
                 row.setUsername(rS.getString("USERNAME"));
                 row.setNome(rS.getString("NOME"));
                 row.setCognome(rS.getString("COGNOME"));
                 row.setIndirizzo(rS.getString("INDIRIZZO"));
                 row.setMail(rS.getString("EMAIL"));
                 row.setCF(rS.getString("CODICE_FISCALE"));
                 clienti.add(row);
                }
                return clienti;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ResultSet cercaImpiegato (String nome, String cognome , Date datanascita){
        try {
            Connection connection = UtilityDB.getConnessioneDB();
            // Create tutti i risultati in una tabella
            String selectSql = "SELECT NOME , COGNOME , CODICE_FISCALE FROM IMPIGATO NATURAL JOIN PERSONA";
            //{1,2,3}
            if (!nome.equals("") && !cognome.equals("") && !datanascita.equals(null)) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(datanascita);
                selectSql += " WHERE " + "NOME" + "='" + nome+"'" + " AND " + "COGNOME" + "='" + cognome+"'" + " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";

                //{1,2}

            }else if (!nome.equals("") && !cognome.equals("") && datanascita.equals(null)) {
                selectSql +=" WHERE " + "NOME" + "='" + nome+"'" + " AND "+ "COGNOME" + "='" + cognome+"'" + ";";
            }
            //{1,3}
            else if (!nome.equals("") && cognome.equals("") && !datanascita.equals(null)) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(datanascita);
                selectSql += " WHERE " + "NOME" + "='" + nome+"'" + " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
            }
            //{2,3}
            else if (nome.equals("") && !cognome.equals("") && !datanascita.equals(null)) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(datanascita);
                selectSql += " WHERE " + "COGNOME" + "='" + cognome+"'" + " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
            }
            //{1}
            else if (!nome.equals("") && cognome.equals("") && datanascita.equals(null)) {

                selectSql += " WHERE " + "NOME" + "='" + nome+"'";
            }
            //{2}
            else if (nome.equals("") && !cognome.equals("") && datanascita.equals(null)) {

                selectSql += " WHERE " + "COGNOME" + "='" + cognome+"'" ;
            }
            //{3}
            else if (nome.equals("") && cognome.equals("") && !datanascita.equals(null)) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(datanascita);
                selectSql += " WHERE " + " DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
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

    public List<Evento> cercaEvento (String nomeevento, String luogo , Date dataevento){
        List<Evento> evento =new ArrayList<Evento>();
        Evento row=null;
        try {
            Connection connection = UtilityDB.getConnessioneDB();
            // Create tutti i risultati in una tabella
            String selectSql="SELECT * FROM EVENTO";
            //{1,2,3}
            if (!nomeevento.equals("") && !luogo.equals("") && !dataevento.equals(null)) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(dataevento);
                selectSql += " WHERE " + "NOME" + "='" + nomeevento+"'" + " AND " + "LUOGO" + "='" + luogo+"'" + " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy')";

                //{1,2}

            }else if (!nomeevento.equals("") && !luogo.equals("") && dataevento.equals(null)) {
                selectSql +=" WHERE " + "NOME" + "='" + nomeevento+"'" + " AND "+ "LUOGO" + "='" + luogo + "'";
            }
            //{1,3}
            else if (!nomeevento.equals("") && luogo.equals("") && !dataevento.equals(null)) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(dataevento);
                selectSql +=" WHERE " + "NOME" + "='" + nomeevento +"'"+ " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
            }
            //{2,3}
            else if (nomeevento.equals("") && !luogo.equals("") && !dataevento.equals(null)) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(dataevento);
                selectSql +=" WHERE "+ "LUOGO" + "='" + luogo+"'" + " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
            }
            //{1}
            else if (!nomeevento.equals("") && luogo.equals("") && dataevento.equals(null)) {

                selectSql +=" WHERE " + "NOME" + "=" + nomeevento +" ;";
            }
            //{2}
            else if (nomeevento.equals("") && !luogo.equals("") && dataevento.equals(null)) {

                selectSql +=" WHERE " + "LUOGO" + "=" + luogo + ";";
            }
            //{3}
            else if (nomeevento.equals("") && luogo.equals("") && !dataevento.equals(null)) {
                Format formatter = new SimpleDateFormat("dd-MM-yy");
                String dataRicerca = formatter.format(dataevento);
                selectSql +=" WHERE " + "NOME" + "=" + nomeevento + " AND "+ "LUOGO" + "=" + luogo + " AND DATA=TO_DATE('" + dataRicerca + "','dd-MM-yy');";
            }
            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(selectSql)) {
                connection.close();
                while(rS.next()){
                 enumerazione è inccompatibile   row.setCitta(rS.getString("CITTA").name());
                    row.setCapienzaMassima(rS.getInt("CAPIENZA_EVENTO" ));
                    row.setDataEvento(rS.getDate("DATA" ).toLocalDate());
                    row.setNome(rS.getString("NOME" ));
                    row.setLuogoEvento(rS.getString("LUOGO" ).name());
                    row.setPrezzoBiglietto(rS.getFloat("PREZZO" ));
                    row.setDescrizione(rS.getString("DESCRIZIONE" ));
                    row.setGenereEvento(rS.getString("TIPOLOGIA" ));
                    row.setIdEvento(rS.getInt("ID"));
                    //non sono sicuro row.setPartecipantiEvento();
                    // Questa informazione è in un altra tabella,
                    // Possiamo settarlo a null e stica'

                    evento.add(row);

                }

                return evento;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

/*
    public void getAllInfo(TableView tabella,String nomeTabella,String colonnaTW1 ,String colonnaTW2 , String colonnaTW3, String attributo1 ,String attributo2 , Date attributo3 ,ObservableList data) {
        Statement st = null;
        ResultSet rs;
        String driver = "org.h2.Driver";

        try {


            //rs = cerca(nomeTabella,colonnaTW1,colonnaTW2,colonnaTW3,attributo1,attributo2,attributo3);
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
*/

}
