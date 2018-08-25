package pacchettoDB;


import pacchettoEntita.Evento;
import pacchettoEntita.eventoMusicale;
import pacchettoEntita.eventoSportivo;
import java.sql.*;

/** Questa classe si occupa di inserire gli eventi
 *  in un DataBase Relazionale
 */
public class inserisciEventoDB implements inserisciEventoDAO {


    private Connection connection;
    private setQueryInserisciEventoSportivo setQueryInserisciEventoSportivo;
    public inserisciEventoDB(){
        this.connection=utilityDB.getConnessioneDB();
    }
    public Connection setConnection(){return  this.connection=utilityDB.getConnessioneDB();}

    /**************************************
     *              METODI
     * ************************************/
    @Override
    /****************************************
     *  Inserimento Eventi                  *
     ****************************************
     */
    public boolean inserisciEvento(Evento e) {
        if(e==null) return false;
        try{
            new setQueryInserisciEvento().setCallInserisciEvento(connection,e );}catch(Exception sqlE){
            // mostraAlert.mostraErroreInserimento.
            sqlE.printStackTrace();
            }
            utilityDB.closeConnection(this.connection);
         return false;
    }
    public boolean inserisciEventoSpecifico(Evento e,int id) throws SQLException,NullPointerException{
        if(e==null)return false;
        if(e instanceof eventoMusicale)  inserisciEventoMusicale((eventoMusicale)e,id);
        if(e instanceof  eventoSportivo) inserisciEventoSportivo((eventoSportivo)e,id);
        return false;
    }
    public void inserisciEventoSportivo(eventoSportivo e,int id) throws SQLException, NullPointerException{
        if(e==null) throw new NullPointerException();
       setQueryInserisciEventoSportivo.preparaEseguiQueryInserimentoEventoSportivo(connection,e,id);
       setQueryInserisciEventoSportivo.preparaEseguiQueryInserimentoPartecipantiEventoSportivo(connection,e.getPartecipanti(),id);
    }
    public void inserisciEventoMusicale(eventoMusicale e,int id) throws SQLException,NullPointerException{
        if(e==null) throw new NullPointerException();
        new setQueryInserisciEventoMusicale().preparaEseguiQueryInserisciEventoMusicale(connection.prepareStatement("INSERT INTO EVENTO_MUSICALE VALUES(?,?)"),e,id);

    }










}
