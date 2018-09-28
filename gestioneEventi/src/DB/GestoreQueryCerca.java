
package DB;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import javax.print.DocFlavor;
import javax.xml.transform.Result;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestoreQueryCerca {//query generica per cercare tutti gli elementi appena apre la schermata

    public List<Cliente> cercaCliente(String username){
        ArrayList<Cliente> listaclienti =new ArrayList<>();
        ResultSet resultSet=null;
        String selectSql=null;
        String queryWhere=null;

        try {
            Connection connection = UtilityDB.getConnessioneDB();
            PreparedStatement preparedStatement=null;
            selectSql="SELECT * FROM CLIENTE";
            //{0}
            if (!username.equals("")) {
                queryWhere=" WHERE USERNAME = ? ";
                preparedStatement = connection.prepareStatement(selectSql+queryWhere);
                preparedStatement.setString(1,username);
                resultSet = preparedStatement.executeQuery();
            }else
                preparedStatement = connection.prepareStatement(selectSql);
            resultSet = preparedStatement.executeQuery();
            //{1}


                while (resultSet.next()) {
                    String username1=(resultSet.getString("USERNAME"));
                    String nome=(resultSet.getString("NOME"));
                    String cognome=(resultSet.getString("COGNOME"));
                    String indirizzo =(resultSet.getString("INDIRIZZO"));
                    String email =(resultSet.getString("EMAIL"));
                    String cf=(resultSet.getString("CODICE_FISCALE"));
                    Cliente rigaCliente=new Cliente(nome,cognome,cf,username1,"",indirizzo,email);//cosa facciamo con il sesso non è meglio mettere data di nascita e calcoliamo l'età
                    listaclienti.add(rigaCliente)   ;
//che poi dobbiamo aggiungere il totale speso e i biglietti acquistati ?
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return listaclienti;



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaclienti;
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


    public List<Evento> cercaEvento(){

        String sql = " SELECT * FROM EVENTO ";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        List<Evento> listaEventi = new ArrayList<>();
        try {
            connection = UtilityDB.getConnessioneDB();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("rs");
                LuogoEnum luogoEvento = (LuogoEnum.valueOf(resultSet.getString("LUOGO")));
                LocalDate date = (resultSet.getDate("DATA").toLocalDate());
                String nome = (resultSet.getString("NOME"));
                LuogoEnum luogoEnum = (LuogoEnum.valueOf(resultSet.getString("LUOGO")));
                Float prezzo = (resultSet.getFloat("PREZZO"));
                String descrizione = (resultSet.getString("DESCRIZIONE"));
                TipologiaEnum tipologia = (TipologiaEnum.valueOf(resultSet.getString("TIPOLOGIA")));
                String genere = (resultSet.getString("GENERE"));
                int id = (resultSet.getInt("ID"));
                Evento rigaEvento = new Evento(luogoEvento, descrizione, prezzo, tipologia, nome, date, genere, null);
                //non sono sicuro row.setPartecipantiEvento();
                // Questa informazione è in un altra tabella,
                // Possiamo settarlo a null e stica'
                System.out.println(rigaEvento);
                listaEventi.add(rigaEvento);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
            return listaEventi;
        }
        catch( SQLException e){
            e.printStackTrace();
        }


        return listaEventi;

    }
    public List<Evento> cercaEvento (String nomeEvento, LuogoEnum luogoEvento , LocalDate dataEvento){
        List<Evento> listaEventi = new ArrayList<>();
        ResultSet resultSet=null;
        String luogo=null;
        if(luogoEvento!=null) {
             luogo = luogoEvento.name();
        }
        String selectSql=null;
        String queryWhere=null;

        try {
            Connection connection = UtilityDB.getConnessioneDB();
            PreparedStatement preparedStatement=null;
            // Create tutti i risultati in una tabella
             selectSql="SELECT * FROM EVENTO";
            //{1,2,3}
            if (( !nomeEvento.equals("")) && !(luogo==null ) && !(dataEvento==null)){
                queryWhere = " WHERE NOME=? AND LUOGO=? AND DATA=? ";
                System.out.println(queryWhere);
                preparedStatement = connection.prepareStatement(selectSql+queryWhere);
                preparedStatement.setString(1,nomeEvento);
                preparedStatement.setString(2,luogo);
                preparedStatement.setDate(3,Date.valueOf(dataEvento));
                resultSet = preparedStatement.executeQuery();

            }
            //{1,2}
            else if (( !nomeEvento.equals("")) && (!(luogo==null ) ) && (dataEvento==null)){

                queryWhere = " WHERE NOME=? AND LUOGO=? ";
                System.out.println(queryWhere);
                preparedStatement = connection.prepareStatement(selectSql+queryWhere);
                preparedStatement.setString(1,nomeEvento);
                preparedStatement.setString(2,luogo);
                resultSet = preparedStatement.executeQuery();
            }
            //{1,3}
            else if (( !nomeEvento.equals("")) && ((luogo==null ) ) && !(dataEvento==null)){
                queryWhere = " WHERE NOME =? AND DATA=? ";
                System.out.println(queryWhere);
                preparedStatement = connection.prepareStatement(selectSql+queryWhere);
                preparedStatement.setString(1,nomeEvento);
                preparedStatement.setDate(2,Date.valueOf(dataEvento));
                resultSet = preparedStatement.executeQuery();
            }

            //{2,3}
            else if (( nomeEvento.equals("")) && (!(luogo==null ) ) && !(dataEvento==null)) {
                queryWhere = " WHERE LUOGO = ? AND DATA = ? ";
                System.out.println(queryWhere);
                preparedStatement = connection.prepareStatement(selectSql+queryWhere);
                preparedStatement.setString(1,luogo);
                preparedStatement.setDate(2,Date.valueOf(dataEvento));
                resultSet = preparedStatement.executeQuery();
            }
            //{1}
            else if (( !nomeEvento.equals("")) && ((luogo==null ) ) && (dataEvento==null)) {
                queryWhere = " WHERE NOME = ? ";
                System.out.println(queryWhere);
                preparedStatement = connection.prepareStatement(selectSql+queryWhere);
                preparedStatement.setString(1,nomeEvento);
                resultSet = preparedStatement.executeQuery();

            }
            //{2}
            else if (((nomeEvento==null) || nomeEvento.equals("")) && (!(luogo==null )) && (dataEvento==null)) {
                queryWhere= " WHERE LUOGO = ?";
                System.out.println(queryWhere);
                preparedStatement = connection.prepareStatement(selectSql+queryWhere);
                preparedStatement.setString(1,luogo);
                resultSet = preparedStatement.executeQuery();
            }
            //{3}
            else if (((nomeEvento==null) || nomeEvento.equals("")) && ((luogo==null )) && !(dataEvento==null)) {
                queryWhere = " WHERE DATA = ?";
                System.out.println(queryWhere);
                preparedStatement = connection.prepareStatement(selectSql+queryWhere);
                preparedStatement.setDate(1,Date.valueOf(dataEvento));
                resultSet = preparedStatement.executeQuery();
            }
            else {
                preparedStatement = connection.prepareStatement(selectSql);
                resultSet = preparedStatement.executeQuery();
            }

            System.out.println(resultSet.isBeforeFirst());

            while(resultSet.next()){
                System.out.println("rs");
                   LocalDate date=(resultSet.getDate("DATA" ).toLocalDate());
                    String nome=(resultSet.getString("NOME" ));
                    LuogoEnum luogoEnum=(LuogoEnum.valueOf(resultSet.getString("LUOGO" )));
                    Float prezzo =(resultSet.getFloat("PREZZO" ));
                    String descrizione = (resultSet.getString("DESCRIZIONE" ));
                    TipologiaEnum tipologia =(TipologiaEnum.valueOf(resultSet.getString("TIPOLOGIA" )));
                    String genere = (resultSet.getString("GENERE"));
                    int id=(resultSet.getInt("ID"));
                    Evento rigaEvento = new Evento(luogoEvento,descrizione,prezzo,tipologia,nome,dataEvento,genere,null);
                    //non sono sicuro row.setPartecipantiEvento();
                    // Questa informazione è in un altra tabella,
                    // Possiamo settarlo a null e stica'
                    System.out.println(rigaEvento);
                    listaEventi.add(rigaEvento);
            }

                resultSet.close();
                preparedStatement.close();
                connection.close();
                return listaEventi;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEventi;

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
