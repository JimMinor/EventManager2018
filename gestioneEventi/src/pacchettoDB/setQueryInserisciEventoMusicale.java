package pacchettoDB;

import pacchettoEntita.eventoMusicale;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class setQueryInserisciEventoMusicale {
    public void preparaEseguiQueryInserisciEventoMusicale(PreparedStatement preparedStatement, eventoMusicale e, int id)throws SQLException {
        preparedStatement.setInt(1,id);
        new esecuzioneQueryEvento().eseguiQueryInserimentoEventoSpecifico(preparedStatement);
    }
}
