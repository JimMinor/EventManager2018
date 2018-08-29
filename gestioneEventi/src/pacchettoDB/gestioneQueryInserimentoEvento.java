package pacchettoDB;

import pacchettoEntita.Evento;

import java.sql.*;

public abstract class gestioneQueryInserimentoEvento {


    private  Evento eventoDaInserire;
    private  int idEventoInserito;

    public void setEventoDaInserire(Evento eventoDaInserire){this.eventoDaInserire=eventoDaInserire;}
    public int getIdEventoInserito(){return this.idEventoInserito;}
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
        callInserisciEvento.setString(3,eventoDaInserire.getLuogoEvento().toString().toUpperCase());//Gia' UppCase
        callInserisciEvento.setDate(4,Date.valueOf(eventoDaInserire.getDataEvento()));//Converto LocalDate in Date.sql
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



    public void inserisciAttributiEventoMusicale() throws SQLException {

    }
}
