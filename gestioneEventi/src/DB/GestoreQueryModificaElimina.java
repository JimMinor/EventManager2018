package DB;

import Model.Evento;
import Model.LuogoEnum;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;

public class GestoreQueryModificaElimina {

    public void eseguiQueryModificaEvento(int evendoID, LocalDate data, LuogoEnum luogo)throws SQLException {

            String query = " UPDATE EVENTO SET DATA = ? , LUOGO = ? WHERE ID = ? ";
            PreparedStatement preparedStatement = UtilityDB.getConnessioneDB().prepareStatement(query);
            preparedStatement.setDate(1, Date.valueOf(data));
            preparedStatement.setString(2,luogo.name());
            preparedStatement.setInt(3,evendoID);
            preparedStatement.executeUpdate();
            UtilityDB.closeDB(preparedStatement);


    }

    public void eseguiQueryEliminaEvento(Evento eventoDaEliminare) throws SQLException {

            eseguiQueryEliminaPartecipantiEvento(eventoDaEliminare);
            String query = " DELETE FROM EVENTO WHERE ID = ? ";
            PreparedStatement preparedStatement = UtilityDB.getConnessioneDB().prepareStatement(query);
            preparedStatement.setInt(1,eventoDaEliminare.getIdEvento());
            preparedStatement.executeUpdate();
            UtilityDB.closeDB(preparedStatement);
    }

    private void eseguiQueryEliminaPartecipantiEvento(Evento eventoDaEliminare) throws SQLException {

            String query = " DELETE FROM PARTECIPANTI_EVENTO WHERE ID_EVENTO = ? ";
            PreparedStatement preparedStatement = UtilityDB.getConnessioneDB().prepareStatement(query);

            for(String partecipante : eventoDaEliminare.getPartecipantiEvento() )
            {
                preparedStatement.setInt(1,eventoDaEliminare.getIdEvento());
                preparedStatement.execute();
            }
    }


}
