package DB;

import Model.LuogoEnum;
import com.sun.istack.internal.NotNull;
import Model.Evento;

import javax.rmi.CORBA.Util;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public  class GestoreQueryInserimentoEvento {

    private  Evento eventoDaInserire;

    private  int idEventoInserito;

    public Evento getEventoDaInserire() {
        return eventoDaInserire;
    }

    public GestoreQueryInserimentoEvento(){}

    public GestoreQueryInserimentoEvento(Evento eventoDaInserire){this.eventoDaInserire=eventoDaInserire;}

    public void setEventoDaInserire(Evento eventoDaInserire){this.eventoDaInserire=eventoDaInserire;}

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
        inserisciPartecipantiEvento();
        UtilityDB.closeCallableStatement(callInserisciEvento);
    }

    private CallableStatement preparaQueryInserimentoGenerico() throws SQLException{
        Connection connection=UtilityDB.getConnessioneDB();
        CallableStatement callInserisciEvento = connection.prepareCall("{?= call ins_evento(?,?,?,?,?,?,?,?,?)}");
        setParementriCallInserimentoEvento(callInserisciEvento);
        return callInserisciEvento;
    }

    private void setParementriCallInserimentoEvento(@NotNull  CallableStatement callInserisciEvento) throws SQLException{
        callInserisciEvento.registerOutParameter(1,Types.INTEGER);
        callInserisciEvento.setString(2,eventoDaInserire.getNome());
        callInserisciEvento.setString(3,eventoDaInserire.getLuogoEvento().name());
        callInserisciEvento.setDate(4,Date.valueOf(eventoDaInserire.getDataEvento()));//Converto LocalDate in sql.Date
        callInserisciEvento.setFloat(5,eventoDaInserire.getPrezzoBiglietto());
        callInserisciEvento.setString(6,eventoDaInserire.getDescrizione());
        callInserisciEvento.setString(7,eventoDaInserire.getTipologiaEvento().name());
        callInserisciEvento.setString(8,eventoDaInserire.getCitta().name());
        callInserisciEvento.setInt(9,eventoDaInserire.getCapienzaMassima());
        callInserisciEvento.setString(10,eventoDaInserire.getGenereEvento());
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
    public void inserisciPartecipantiEvento() throws  SQLException{
        String queryInserimentoPartecipanti = "INSERT INTO PARTECIPANTI_EVENTO VALUES(?,?)";
        Set<String> partecipanti = eventoDaInserire.getPartecipantiEvento();
        PreparedStatement preparedStatementInserimentoPartecipante=null;
        for(String partecipante : partecipanti){
            preparedStatementInserimentoPartecipante = preparaQueryInserimentoPartecipanti(queryInserimentoPartecipanti,partecipante);
            eseguiQuery(preparedStatementInserimentoPartecipante);
            UtilityDB.closeDB(preparedStatementInserimentoPartecipante);
        }
    }

    private PreparedStatement preparaQueryInserimentoPartecipanti(String queryInserimentoPartecipanti, String partecipante)throws SQLException{
        PreparedStatement preparedStatement=UtilityDB.getConnessioneDB().prepareStatement(queryInserimentoPartecipanti);
        preparedStatement.setInt(1,idEventoInserito);
        preparedStatement.setString(2,partecipante);
        return preparedStatement;
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

    public boolean cercaEventoDB(LocalDate data, LuogoEnum luogo) throws SQLException{
        PreparedStatement preparedStatement = UtilityDB.getConnessioneDB().prepareStatement("SELECT * FROM EVENTO WHERE " +
                "data=? AND luogo=?");
        preparedStatement.setDate(1,Date.valueOf(data));
        preparedStatement.setString(2,luogo.name());
        ResultSet rs = eseguiQuery(preparedStatement);
        return rs.isBeforeFirst();


    }

}
