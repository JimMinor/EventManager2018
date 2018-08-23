package pacchettoDB;

import pacchettoEntita.Impiegato;

import java.sql.*;
import java.sql.Date;
import java.util.*;
public class impiegatoDB implements impiegatoDAO {


    public boolean inserisciPersona(Impiegato impiegato) {

        if(impiegato==null)return false;

        Connection connection = connessioneDB.getConnessioneDB();
        String queryPersona = "INSERT INTO PERSONA VALUES (?,?,?,?)";

        try {
                PreparedStatement statement = connection.prepareStatement(queryPersona);
                // SETUP QUERY
                statement.setString(1, impiegato.getCF());
                statement.setString(2, impiegato.getNome());
                statement.setString(3, impiegato.getCognome());
                statement.setDate(4, Date.valueOf(impiegato.getDataNascita()));

                ResultSet rs = statement.executeQuery();

                if(rs.next()){
                    new connessioneDB().chiudiConnessione(connection,statement,rs);
                    return true;
                }

        } catch (Exception e) {
            //mostraAlert.mostraErroreInserimento();
            e.printStackTrace();
            return false;
        }
        return false;
    }
    @Override
    public boolean inserisciImpiegatoBackOffice(Impiegato impiegato) {
       if(impiegato==null)return false;

       if(inserisciPersona(impiegato)){

           Connection connection = connessioneDB.getConnessioneDB();
           try {
               String query = "INSERT INTO IMPIEGATO VALUES (?,?,?,?,?,?,?,?)";
               PreparedStatement statement = connection.prepareStatement(query);
              //SETUP QUERY
               statement.setInt(1, 1);
               statement.setString(2, impiegato.getCF());
               statement.setString(3, impiegato.getUsername());
               statement.setString(4, impiegato.getPassword());
               statement.setDate(5, Date.valueOf(impiegato.getDataAssunzione()));
               statement.setFloat(6,impiegato.getStipendio());
               statement.setString(7,impiegato.getEmail());
               statement.setLong(8,impiegato.getTelefono());

               ResultSet rs = statement.executeQuery();
               if(rs.next()){
                   new connessioneDB().chiudiConnessione(connection,statement,rs);
                   return true;

               }

           }
           catch(Exception e){
               // mostraAlert.mostraErroreInserimento()
               e.printStackTrace();
               return false;
           }
       }
     return false;
    }

    @Override
    public boolean eliminaImpiegatoBackOffice(Impiegato i) {
        return false;
    }
  }
