package pacchettoDB;

import oracle.jdbc.proxy.annotation.Pre;
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
        try{if(!inserisciEventoGenerico(e))throw new SQLException();}catch(SQLException sqlE){
            // mostraAlert.mostraErroreInserimento.
            sqlE.printStackTrace();
            }
         return false;
    }
    public boolean inserisciEventoGenerico(Evento e) throws SQLException{
        if(e==null)return false;
        String query ="INSERT INTO EVENTO VALUES(?,?,?,?,?,?,?)";
        //Inserisco l'evento generico
        if(setEseguiQueryEventoGenerico(query,e)) return inserisciEventoSpecifico(e);
        return false;
        }
    public boolean inserisciEventoSpecifico(Evento e) throws SQLException{
        if(e==null)return false;
        if(e instanceof eventoMusicale) return inserisciEventoMusicale((eventoMusicale)e);
        if(e instanceof  eventoSportivo)return inserisciEventoSportivo((eventoSportivo)e);
        return false;
    }
    public boolean inserisciEventoSportivo(eventoSportivo e) throws SQLException{
        if(e==null) return false;
        String query = "INSERT INTO EVENTO_SPORTIVO VALUES (?,?,?,?)";
        return setEseguiQueryEventoSportivo(query,e);

    }
    public boolean inserisciEventoMusicale(eventoMusicale e) throws SQLException{
        if(e==null) return false;

        String query = "INSERT INTO EVENTO_MUSICALE VALUES(?,?)";
        return setEseguiQueryEventoMusicale(query,e);

    }
    public boolean setEseguiQueryEventoGenerico(String query,Evento e) throws SQLException{

        PreparedStatement preparedStatement = connessioneDB.getConnessioneDB().prepareStatement(query);
        // SETUP QUERY
        preparedStatement.setInt(1,0);
        preparedStatement.setDate(2, Date.valueOf(e.getDataEvento()));
        preparedStatement.setString(3,e.getDescrizione());
        preparedStatement.setString(4, e.getLuogoEvento().name());
        preparedStatement.setString(5,e.getNome());
        preparedStatement.setFloat(6,e.getPrezzoBiglietto());
        preparedStatement.setString(7,e.getTipologiaEvento().name());
        if(eseguiChiudiQuery(preparedStatement)>0)return true;
        return false;
    }
    public boolean setEseguiQueryEventoSportivo(String query,eventoSportivo e) throws SQLException{
        PreparedStatement preparedStatement = connessioneDB.getConnessioneDB().prepareStatement(query);
        //SETUP QUERY
        preparedStatement.setInt(1,0);
        preparedStatement.setString(2,e.getPartecipanti()[0]);
        preparedStatement.setString(3,e.getPartecipanti()[1]);
        preparedStatement.setString(4,e.getSport().name());
        if(eseguiChiudiQuery(preparedStatement)>0)return true;
        return false;
    }
    public boolean setEseguiQueryEventoMusicale(String query,eventoMusicale e)throws  SQLException{
        PreparedStatement preparedStatement = connessioneDB.getConnessioneDB().prepareStatement(query);
        //SETUP QUERY
        preparedStatement.setInt(1,0);
        preparedStatement.setString(2,e.getArtisti().get(0));//TODO: cambiare table Evento_Musicale?
        if(eseguiChiudiQuery(preparedStatement)>0)return true;
        return false;
    }
    public int eseguiChiudiQuery(PreparedStatement preparedStatement)throws SQLException{
         int ris=preparedStatement.executeUpdate();
         preparedStatement.close();
         return ris;

    }





}
