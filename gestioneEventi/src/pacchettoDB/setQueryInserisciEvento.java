package pacchettoDB;

import pacchettoEntita.Evento;

import java.sql.*;

public class setQueryInserisciEvento {
       public void setCallInserisciEvento(Connection connection, Evento e) throws SQLException {
        CallableStatement callableStatement=connection.prepareCall("{?= call ins_evento(?,?,?,?,?,?)}");
        setParametriCallInserisciEvento(connection,callableStatement,e); }


    public void setParametriCallInserisciEvento(Connection connection, CallableStatement callableStatement, Evento e) throws SQLException {
        callableStatement.registerOutParameter(1,Types.INTEGER);
        callableStatement.setString(2,e.getNome());
        callableStatement.setString(3,e.getLuogoEvento().toString().toUpperCase());//Gia' UppCase
        callableStatement.setDate(4,Date.valueOf(e.getDataEvento()));//Converto LocalDate in Date.sql
        callableStatement.setFloat(5,e.getPrezzoBiglietto());
        callableStatement.setString(6,e.getDescrizione());
        callableStatement.setString(7,e.getTipologiaEvento().name());//Gia' UppCase
         new esecuzioneQueryEvento().eseguiCallInserisciEventoGenerico(callableStatement);
        //inserisciEventoSpecifico(e,eseguiCallInserisciEventoGenerico(callableStatement));//Esegue e ritorna l'id dell'evento
    }
}
