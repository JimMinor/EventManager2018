package pacchettoDB;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class esecuzioneQueryEvento {
    public int eseguiQueryInserimentoEventoSpecifico(PreparedStatement preparedStatement)throws SQLException {
        int ris=preparedStatement.executeUpdate();
        utilityDB.closePreparedStaement(preparedStatement);
        return ris;
    }
    public int eseguiCallInserisciEventoGenerico(CallableStatement callableStatement)throws SQLException{
        callableStatement.executeUpdate();
        int ris= callableStatement.getInt(1);
        utilityDB.closeCallableStatement(callableStatement);
        return ris;
    }
    public void eseguiQueryInserisciPartecipantiEventoSportivo(List<String> partecipanti) {}

}
