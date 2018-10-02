
package DB;

import Model.*;
import com.sun.org.apache.xml.internal.security.Init;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestoreQueryCerca {//query generica per cercare tutti gli elementi appena apre la schermata

    public List<Cliente> eseguiQueryRicercaClienti(String username) throws SQLException {
        ArrayList<Cliente> listaclienti = new ArrayList<>();
        ResultSet resultSet = null;
        String selectSql = null;
        String queryWhere = null;


        Connection connection = UtilityDB.getConnessioneDB();
        PreparedStatement preparedStatement = null;
        selectSql = "SELECT * FROM CLIENTE NATURAL JOIN PERSONA";
        //{0}
        if (!username.equals("")) {
            queryWhere = " WHERE USERNAME LIKE '%?%' ";
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
        } else
            preparedStatement = connection.prepareStatement(selectSql);
        resultSet = preparedStatement.executeQuery();
        //{1}


        while (resultSet.next()) {
            String username1 = (resultSet.getString("USERNAME"));
            String nome = (resultSet.getString("NOME"));
            String cognome = (resultSet.getString("COGNOME"));
            String indirizzo = (resultSet.getString("INDIRIZZO"));
            String email = (resultSet.getString("EMAIL"));
            String cf = (resultSet.getString("CODICE_FISCALE"));
            LocalDate dataNascita = (resultSet.getDate("DATA_NASCITA").toLocalDate());
            Float spesaTot = (resultSet.getFloat("SPESA_TOT "));
            Float spesaCarta = (resultSet.getFloat("SPESA_CARTA"));
            int n_bigietti = (resultSet.getInt("NUM_BIGLIETTI"));
            int id = (resultSet.getInt("ID"));

            Cliente rigaCliente = new Cliente(nome, cognome, cf, username1, indirizzo, email, dataNascita, spesaTot, spesaCarta, n_bigietti, id);
            listaclienti.add(rigaCliente);

        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return listaclienti;

    }

    public List<Impiegato> eseguiQueryRicercaImpiegato(String nome, String cognome, LocalDate datanascita) throws SQLException {
        List<Impiegato> listaImpiegato = new ArrayList<>();
        ResultSet resultSet = null;
        String selectsql1 = null;
        String queryWhere = null;


        Connection connection = UtilityDB.getConnessioneDB();
        PreparedStatement preparedStatement = null;
        String selectSql = "SELECT * FROM IMPIGATO NATURAL JOIN PERSONA";
        //{1,2,3}
        if (!nome.equals("") && !cognome.equals("") && !(datanascita == null)) {
            queryWhere = " WHERE NOME LIKE '%?%' AND COGNOME=? AND DATA_NASCITA=?";
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cognome);
            preparedStatement.setDate(3, Date.valueOf(datanascita));
            resultSet = preparedStatement.executeQuery();
            //{1,2}

        } else if (!nome.equals("") && !cognome.equals("") && (datanascita == null)) {
            queryWhere = " WHERE NOME LIKE '%?%' AND COGNOME=? ";
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cognome);
            resultSet = preparedStatement.executeQuery();
        }
        //{1,3}
        else if (!nome.equals("") && cognome.equals("") && !(datanascita == null)) {
            queryWhere = " WHERE NOME LIKE '%?%' AND DATA_NASCITA=?";
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, nome);
            preparedStatement.setDate(2, Date.valueOf(datanascita));
            resultSet = preparedStatement.executeQuery();
        }
        //{2,3}
        else if (nome.equals("") && !cognome.equals("") && !(datanascita == null)) {
            queryWhere = " WHERE COGNOME LIKE '%?%' AND DATA_NASCITA=?";
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, cognome);
            preparedStatement.setDate(2, Date.valueOf(datanascita));
            resultSet = preparedStatement.executeQuery();
        }
        //{1}
        else if (!nome.equals("") && cognome.equals("") && (datanascita == null)) {
            queryWhere = " WHERE NOME LIKE '%?%' ";
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, nome);
            resultSet = preparedStatement.executeQuery();
        }
        //{2}
        else if (nome.equals("") && !cognome.equals("") && (datanascita == null)) {
            queryWhere = "WHERE COGNOME LIKE '%?%' ";
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, cognome);
            resultSet = preparedStatement.executeQuery();
        }
        //{3}
        else if (nome.equals("") && cognome.equals("") && !(datanascita == null)) {
            queryWhere = " WHERE  DATA_NASCITA=?";
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setDate(1, Date.valueOf(datanascita));
            resultSet = preparedStatement.executeQuery();
        } else {
            preparedStatement = connection.prepareStatement(selectSql);
            resultSet = preparedStatement.executeQuery();
        }

        while (resultSet.next()) {
            String nome1 = (resultSet.getString("NOME"));
            String cognome1 = (resultSet.getString("COGNOME"));
            LocalDate dataNascita = (resultSet.getDate("DATA_NASCITA").toLocalDate());
            String CF = (resultSet.getString("CODICE_FISCALE"));
            String username = (resultSet.getString("USERNAME"));
            String password = (resultSet.getString("PASSWORD"));
            LocalDate dataAssunzione = (resultSet.getDate("DATA_ASSUNZIONE").toLocalDate());
            Float stipendio = (resultSet.getFloat("STIPENDIO"));
            String amministratore = (resultSet.getString("ADMIN"));
            String telefono = (resultSet.getString("TELEFONO"));
            String iban = (resultSet.getString("IBAN"));
            String email = (resultSet.getString("EMAIL"));
            int id = (resultSet.getInt("ID"));


            Impiegato rigaImpiegato = new Impiegato(nome1, cognome1, dataNascita, CF, username,
                    password, dataAssunzione, stipendio, amministratore, telefono, iban, email, id);
            listaImpiegato.add(rigaImpiegato);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return listaImpiegato;


    }

    public List<Cliente> eseguiQueryRicercaClienti() throws SQLException{
        List<Cliente> listaClienti = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = UtilityDB.getConnessioneDB();
        PreparedStatement preparedStatement = null;
        String selectSql = " SELECT * FROM IMPIGATO NATURAL JOIN PERSONA ";
        preparedStatement = connection.prepareStatement(selectSql);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String username1 = (resultSet.getString("USERNAME"));
            String nome = (resultSet.getString("NOME"));
            String cognome = (resultSet.getString("COGNOME"));
            String indirizzo = (resultSet.getString("INDIRIZZO"));
            String email = (resultSet.getString("EMAIL"));
            String cf = (resultSet.getString("CODICE_FISCALE"));
            LocalDate dataNascita = (resultSet.getDate("DATA_NASCITA").toLocalDate());
            Float spesaTot = (resultSet.getFloat("SPESA_TOT "));
            Float spesaCarta = (resultSet.getFloat("SPESA_CARTA"));
            int n_bigietti = (resultSet.getInt("NUM_BIGLIETTI"));
            int id = (resultSet.getInt("ID"));

        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return listaClienti;
    }

    public List<Evento> eseguiQueryRicercaEventi() throws SQLException {

        String sql = " SELECT * FROM EVENTO ";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        List<Evento> listaEventi = new ArrayList<>();

        connection = UtilityDB.getConnessioneDB();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            LuogoEnum luogoEvento = (LuogoEnum.valueOf(resultSet.getString("LUOGO")));
            LocalDate date = (resultSet.getDate("DATA").toLocalDate());
            String nome = (resultSet.getString("NOME"));
            LuogoEnum luogoEnum = (LuogoEnum.valueOf(resultSet.getString("LUOGO")));
            Float prezzo = (resultSet.getFloat("PREZZO"));
            String descrizione = (resultSet.getString("DESCRIZIONE"));
            TipologiaEnum tipologia = (TipologiaEnum.valueOf(resultSet.getString("TIPOLOGIA")));
            String genere = (resultSet.getString("GENERE"));
            int id = (resultSet.getInt("ID"));
            Set<String> partecipantiEvento = new HashSet<>();
            partecipantiEvento = eseguiQueryRicercaPartecipantiEvento(id);
            Evento rigaEvento = new Evento(luogoEvento, descrizione, prezzo, tipologia, nome, date, genere, partecipantiEvento);
            rigaEvento.setIdEvento(id);
            listaEventi.add(rigaEvento);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return listaEventi;
    }

    private Set<String> eseguiQueryRicercaPartecipantiEvento(int id) throws SQLException {

        Set<String> setPartecipanti = new HashSet<>();
        String query = " SELECT PARTECIPANTE FROM PARTECIPANTI_EVENTO WHERE ID_EVENTO = ? ";
        PreparedStatement preparedStatement = UtilityDB.getConnessioneDB().prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) setPartecipanti.add(resultSet.getString(1));

        System.out.println("  Partecipanti" + setPartecipanti);

        UtilityDB.closeDB(preparedStatement);

        return setPartecipanti;

    }

    public List<Evento> eseguiQueryRicercaEventi(String nomeEvento, LuogoEnum luogoEvento, LocalDate dataEvento) throws SQLException {
        List<Evento> listaEventi = new ArrayList<>();
        ResultSet resultSet = null;
        String luogo = null;
        if (luogoEvento != null) {
            luogo = luogoEvento.name();
        }
        String selectSql = null;
        String queryWhere = null;


        Connection connection = UtilityDB.getConnessioneDB();
        PreparedStatement preparedStatement = null;
        // Create tutti i risultati in una tabella
        selectSql = "SELECT * FROM EVENTO";
        //{1,2,3}
        if ((!nomeEvento.equals("")) && !(luogo == null) && !(dataEvento == null)) {
            queryWhere = " WHERE NOME LIKE '%?%' AND LUOGO=? AND DATA=? ";
            System.out.println(queryWhere);
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, nomeEvento);
            preparedStatement.setString(2, luogo);
            preparedStatement.setDate(3, Date.valueOf(dataEvento));
            resultSet = preparedStatement.executeQuery();

        }
        //{1,2}
        else if ((!nomeEvento.equals("")) && (!(luogo == null)) && (dataEvento == null)) {

            queryWhere = " WHERE NOME LIKE '%?%' AND LUOGO=? ";
            System.out.println(queryWhere);
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, nomeEvento);
            preparedStatement.setString(2, luogo);
            resultSet = preparedStatement.executeQuery();
        }
        //{1,3}
        else if ((!nomeEvento.equals("")) && ((luogo == null)) && !(dataEvento == null)) {
            queryWhere = " WHERE NOME LIKE '%?%' AND DATA=? ";
            System.out.println(queryWhere);
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, nomeEvento);
            preparedStatement.setDate(2, Date.valueOf(dataEvento));
            resultSet = preparedStatement.executeQuery();
        }

        //{2,3}
        else if ((nomeEvento.equals("")) && (!(luogo == null)) && !(dataEvento == null)) {
            queryWhere = " WHERE LUOGO = ? AND DATA = ? ";
            System.out.println(queryWhere);
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, luogo);
            preparedStatement.setDate(2, Date.valueOf(dataEvento));
            resultSet = preparedStatement.executeQuery();
        }
        //{1}
        else if ((!nomeEvento.equals("")) && ((luogo == null)) && (dataEvento == null)) {
            queryWhere = " WHERE NOME LIKE '%?%' ";
            System.out.println(queryWhere);
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, nomeEvento);
            resultSet = preparedStatement.executeQuery();

        }
        //{2}
        else if ((nomeEvento.equals("")) && (!(luogo == null)) && (dataEvento == null)) {
            queryWhere = " WHERE LUOGO = ?";
            System.out.println(queryWhere);
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setString(1, luogo);
            resultSet = preparedStatement.executeQuery();
        }
        //{3}
        else if ((nomeEvento.equals("")) && ((luogo == null)) && !(dataEvento == null)) {
            queryWhere = " WHERE DATA = ?";
            System.out.println(queryWhere);
            preparedStatement = connection.prepareStatement(selectSql + queryWhere);
            preparedStatement.setDate(1, Date.valueOf(dataEvento));
            resultSet = preparedStatement.executeQuery();
        } else {
            preparedStatement = connection.prepareStatement(selectSql);
            resultSet = preparedStatement.executeQuery();
        }

        System.out.println(resultSet.isBeforeFirst());

        while (resultSet.next()) {

            LocalDate date = (resultSet.getDate("DATA").toLocalDate());
            String nome = (resultSet.getString("NOME"));
            LuogoEnum luogoEnum = (LuogoEnum.valueOf(resultSet.getString("LUOGO")));
            Float prezzo = (resultSet.getFloat("PREZZO"));
            String descrizione = (resultSet.getString("DESCRIZIONE"));
            TipologiaEnum tipologia = (TipologiaEnum.valueOf(resultSet.getString("TIPOLOGIA")));
            String genere = (resultSet.getString("GENERE"));
            int id = (resultSet.getInt("ID"));
            Set<String> partecipantiEvento = new HashSet<>();
            partecipantiEvento = eseguiQueryRicercaPartecipantiEvento(id);
            Evento rigaEvento = new Evento(luogoEnum, descrizione, prezzo, tipologia, nome, date, genere, partecipantiEvento);
            rigaEvento.setIdEvento(id);
            listaEventi.add(rigaEvento);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return listaEventi;
    }

}
