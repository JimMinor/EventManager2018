package pacchettoDB;

import pacchettoEntita.Evento;
import pacchettoEntita.eventoMusicale;
import pacchettoEntita.eventoSportivo;

import java.sql.*;

public class eventoDB implements  eventoDAO {

    @Override
    public boolean eliminaEvento(Evento e) {
        return false;
    }
    @Override
    public boolean inserisciEvento(Evento e) {

        if(e==null) return false;

        try{
            if(inserisciEventoGenerico(e)) {
                //Inserisce poi i dati della propria tipologia
                if(e instanceof eventoSportivo) return inserisciEventoSportivo((eventoSportivo)e);
                if(e instanceof  eventoMusicale) return inserisciEventoMusicale((eventoMusicale)e);
            }

        }catch(SQLException sqlE){
            // mostraAlert.mostraErroreInserimento.
            sqlE.printStackTrace();
            return false;
        }
         return false;
    }
    public boolean inserisciEventoGenerico(Evento e) throws SQLException{
        if(e==null)return false;

        Connection connection = connessioneDB.getConnessioneDB();
        String query ="INSERT INTO EVENTO VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // SETUP QUERY
        preparedStatement.setInt(1,0);
        preparedStatement.setDate(2, Date.valueOf(e.getDataEvento()));
        preparedStatement.setString(3,e.getDescrizione());
        preparedStatement.setString(4, e.getLuogoEvento().name());
        preparedStatement.setString(5,e.getNome());
        preparedStatement.setFloat(6,e.getPrezzoBiglietto());
        preparedStatement.setString(7,e.getTipologiaEvento().name());

        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){
            new connessioneDB().chiudiConnessione(connection,preparedStatement,rs);
            return true;
        }
      return false;
    }
    public boolean inserisciEventoSportivo(eventoSportivo e) throws SQLException{
        if(e==null) return false;
        // Connessione al DB e init della query
        Connection connection = connessioneDB.getConnessioneDB();
        String query = "INSERT INTO EVENTO_SPORTIVO VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        //SETUP QUERY
        preparedStatement.setInt(1,0);
        preparedStatement.setString(2,e.getPartecipanti()[0]);
        preparedStatement.setString(3,e.getPartecipanti()[1]);
        preparedStatement.setString(4,e.getSport().name());

        ResultSet rs= preparedStatement.executeQuery();

        if(rs.next()){
            new connessioneDB().chiudiConnessione(connection,preparedStatement,rs);
            return true;
        }
        return false;
    }
    public boolean inserisciEventoMusicale(eventoMusicale e) throws SQLException{
        if(e==null) return false;
        //Connessione al DB e init della query
        Connection connection = connessioneDB.getConnessioneDB();
        String query = "INSERT INTO EVENTO_MUSICALE VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        //SETUP QUERY
        preparedStatement.setInt(1,0);
        preparedStatement.setString(2,e.getArtisti().get(0));//TODO: cambiare table Evento_Musicale?

        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){
            new connessioneDB().chiudiConnessione(connection,preparedStatement,rs);
            return true;
        }

        return false;
    }

}
