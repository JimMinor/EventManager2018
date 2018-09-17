package DB;

import com.sun.istack.internal.NotNull;
import Model.Evento;

import java.sql.*;
import java.util.Map;
import java.util.Set;

public abstract class GestoreQueryInserimentoEvento<T extends Evento> {

    private  T  eventoDaInserire;
    private  int idEventoInserito;

    public T getEventoDaInserire() {
        return eventoDaInserire;
    }

    public GestoreQueryInserimentoEvento(T eventoDaInserire){this.eventoDaInserire=eventoDaInserire;}
    public void setEventoDaInserire(T eventoDaInserire){this.eventoDaInserire=eventoDaInserire;}
    public int getIdEventoInserito(){return this.idEventoInserito;}


    /***************************************
     * METODI CONCRETI,
     *
     * INSERIMENTO DATI EVENTO GENERICO DB
     *
     * *************************************/
    public void eseguiEPreparaQueryInserimentoEvento() throws SQLException{
        CallableStatement callInserisciEvento=preparaQueryInserimentoGenerico();
        idEventoInserito=eseguiCallInserimentoEventoGenerico(callInserisciEvento);

        UtilityDB.closeCallableStatement(callInserisciEvento);
    }

    private CallableStatement preparaQueryInserimentoGenerico() throws SQLException{
        Connection connection=UtilityDB.getConnessioneDB();
        CallableStatement callInserisciEvento = connection.prepareCall("{?= call ins_evento(?,?,?,?,?,?)}");
        setParementriCallInserimentoEvento(callInserisciEvento);
        return callInserisciEvento;
    }

    private void setParementriCallInserimentoEvento(@NotNull  CallableStatement callInserisciEvento) throws SQLException{
        callInserisciEvento.registerOutParameter(1,Types.INTEGER);
        callInserisciEvento.setString(2,eventoDaInserire.getNome());
        callInserisciEvento.setString(3,eventoDaInserire.getLuogoEvento().name());//Gia' UppCase
        callInserisciEvento.setDate(4,Date.valueOf(eventoDaInserire.getDataEvento()));//Converto LocalDate in sql.Date
        callInserisciEvento.setFloat(5,eventoDaInserire.getPrezzoBiglietto());
        callInserisciEvento.setString(6,eventoDaInserire.getDescrizione());
        callInserisciEvento.setString(7,eventoDaInserire.getTipologiaEvento().name());//Gi' UppCase
    }

    private int eseguiCallInserimentoEventoGenerico(CallableStatement callInsericiEvento)throws SQLException{
        callInsericiEvento.executeUpdate();
        int ris= callInsericiEvento.getInt(1);
        UtilityDB.closeCallableStatement(callInsericiEvento);
        return ris;
    }

    /**************************************
     * INSERIMENTO PARTECIPANTI EVENTO
     * Questo vale per gli Eventi:
     * Sportivi->Atleti/Team
     * Musicale->Artisti
     * Teatrale->Compagnia Teatrale,Artisti
     * *************************************
     */
    public void inserisciPartecipantiEvento(Map<Integer,String> queryInserimentoPartecipanti,Set<String> partecipanti) throws  SQLException{

        PreparedStatement queryEventoSportivoPartecipanti=null;
        ResultSet risultato=null;
        for(String partecipante : partecipanti){//Per ogni atleta nella lista
            risultato=verificaPartecipante(queryInserimentoPartecipanti.get(1),partecipante);
            if(!risultato.isBeforeFirst()) inserisciPartecipante(queryInserimentoPartecipanti.get(2),partecipante);//Nessun Risultato
            queryEventoSportivoPartecipanti= prepaQueryDaEseguireInserimentoPartecipantiEvento(queryInserimentoPartecipanti.get(3),partecipante);
            eseguiUpdate(queryEventoSportivoPartecipanti);
        }
        UtilityDB.closeDB(queryEventoSportivoPartecipanti);
        UtilityDB.closeResultSet(risultato);
    }

    private PreparedStatement prepaQueryDaEseguireInserimentoPartecipantiEvento(String query,String partecipante) throws SQLException{
        PreparedStatement queryDaEseguire=preparaQueryDaEseguire(query);
        queryDaEseguire.setInt(1,getIdEventoInserito());
        queryDaEseguire.setString(2,partecipante);
        return queryDaEseguire;
    }

    private ResultSet verificaPartecipante(String query,String partecipante)throws  SQLException {
        PreparedStatement queryDaEseguire = preparaQueryDaEseguire(query);
        queryDaEseguire.setString(1,partecipante);
        return eseguiQuery(queryDaEseguire);
    }

    private void inserisciPartecipante(String query,String partecipante) throws SQLException{
        eseguiQuery((prepaQueryDaEseguireInserisciPartecipante(query,partecipante)));
    }

    private PreparedStatement prepaQueryDaEseguireInserisciPartecipante(String query, String partecipante) throws SQLException{
        PreparedStatement queryDaEseguire=preparaQueryDaEseguire(query);
        queryDaEseguire.setString(1,partecipante);
        return queryDaEseguire;
    }

    /** METODI DI UTILITA' */
    public ResultSet eseguiQuery(PreparedStatement queryDaEseguire)throws SQLException{ return queryDaEseguire.executeQuery(); }
    public int eseguiUpdate(PreparedStatement queryDaEseguire)throws SQLException{return queryDaEseguire.executeUpdate();}
    public PreparedStatement preparaQueryDaEseguire(String query)throws SQLException{
        Connection connection=UtilityDB.getConnessioneDB();
        PreparedStatement queryDaEseguire = connection.prepareCall(query);
        return queryDaEseguire;
    }

    /** METODI ABSTRACT */
    public abstract void inserisciAttributiEventoSpecifico()throws SQLException;
    public abstract Map<Integer,String> creaMapQueryEventoSpecifico()throws SQLException;
    public abstract void eseguiEPreparaQueryInserimentoEventoSpecifico()throws SQLException;
    public abstract PreparedStatement preparaQueryInserimentoEventoSpecifico()throws SQLException;
}
