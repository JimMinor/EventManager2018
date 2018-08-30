package pacchettoDB;

import pacchettoEntita.Evento;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Map;
import java.util.List;

public abstract class gestioneQueryInserimentoEvento {


    private  Evento eventoDaInserire;
    private  int idEventoInserito;

    public void setEventoDaInserire(Evento eventoDaInserire){this.eventoDaInserire=eventoDaInserire;}
    public int getIdEventoInserito(){return this.idEventoInserito;}


    /** INSERIMENTO ATTRIBUTI GENERICI EVENTO */
    public void eseguiEPreparaQueryInserimentoEvento() throws SQLException{
        CallableStatement callInserisciEvento=preparaQueryInserimentoGenerico();
        idEventoInserito=eseguiCallInserimentoEventoGenerico(callInserisciEvento);
        utilityDB.closeCallableStatement(callInserisciEvento);
    }

    private CallableStatement preparaQueryInserimentoGenerico() throws SQLException{
        Connection connection=utilityDB.getConnessioneDB();
        CallableStatement callInserisciEvento = connection.prepareCall("{?= call ins_evento(?,?,?,?,?,?)}");
        setParementriCallInserimentoEvento(callInserisciEvento);
        return callInserisciEvento;
    }

    private void setParementriCallInserimentoEvento(CallableStatement callInserisciEvento) throws SQLException{
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
        utilityDB.closeCallableStatement(callInsericiEvento);
        return ris;
    }

    /**************************************
     * INSERIMENTO PARTECIPANTI EVENTO
     * Questo vale per gli Eventi:
     * Sportivi->Atleti/Team
     * Musicale->Artisti
     * *************************************
     */
    public void inserisciPartecipantiEvento(Map<Integer,String> queryInserimentoPartecipanti,List<String> partecipanti) throws SQLException{

        PreparedStatement queryEventoSportivoPartecipanti=null;
        ResultSet risultato=null;
        for(String partecipante : partecipanti){//Per ogni atleta nella lista
            risultato=verificaPartecipante(queryInserimentoPartecipanti.get(1),partecipante);
            if(!risultato.isBeforeFirst()) inserisciPartecipante(queryInserimentoPartecipanti.get(2),partecipante);//Nessun Risultato
            queryEventoSportivoPartecipanti= prepaQueryDaEseguireInserimentoPartecipantiEvento(queryInserimentoPartecipanti.get(3),partecipante);
            eseguiUpdate(queryEventoSportivoPartecipanti);
        }
        utilityDB.closeDB(queryEventoSportivoPartecipanti);
        utilityDB.closeResultSet(risultato);
    }

    private PreparedStatement prepaQueryDaEseguireInserimentoPartecipantiEvento(String query,String atleta) throws SQLException{
        PreparedStatement queryDaEseguire=preparaQueryDaEseguire(query);
        queryDaEseguire.setInt(1,getIdEventoInserito());
        queryDaEseguire.setString(2,atleta);
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
    //Metodi utili per le sottoclassi
    public ResultSet eseguiQuery(PreparedStatement queryDaEseguire)throws SQLException{ return queryDaEseguire.executeQuery(); }
    public int eseguiUpdate(PreparedStatement queryDaEseguire)throws SQLException{return queryDaEseguire.executeUpdate();}
    public PreparedStatement preparaQueryDaEseguire(String query)throws SQLException{
        Connection connection=utilityDB.getConnessioneDB();
        PreparedStatement queryDaEseguire = connection.prepareCall(query);
        return queryDaEseguire;
    }

}
