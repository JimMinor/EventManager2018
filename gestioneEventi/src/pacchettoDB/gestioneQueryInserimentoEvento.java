package pacchettoDB;

import jdk.nashorn.internal.codegen.CompilerConstants;
import pacchettoEntita.Evento;

import java.sql.*;

public class gestioneQueryInserimentoEvento {


    private final Evento eventoDaInserire;

    public gestioneQueryInserimentoEvento(Evento eventoDainserire){
        this.eventoDaInserire=eventoDainserire;
    }
    public int inserimentoEventoGenerico() throws SQLException,NullPointerException{
        return eseguiQueryInserimentoGenerico(preparaQueryInserimentoGenerico());
    }

    private CallableStatement preparaQueryInserimentoGenerico() throws SQLException{
        Connection connection=utilityDB.getConnessioneDB();
        CallableStatement callInserisciEvento = connection.prepareCall("{?= call ins_evento(?,?,?,?,?,?)}");
        setParementriCallInserimentoEvento(callInserisciEvento);
        utilityDB.closeConnection(connection);
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

    private int eseguiQueryInserimentoGenerico(CallableStatement callInsericiEvento)throws SQLException{
        callInsericiEvento.executeUpdate();
        int ris= callInsericiEvento.getInt(1);
        utilityDB.closeCallableStatement(callInsericiEvento);
        return ris;
    }


}
