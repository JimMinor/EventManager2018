package pacchettoDB;

import pacchettoEntita.Evento;
import pacchettoEntita.eventoMusicale;
import pacchettoEntita.eventoSportivo;

import java.sql.*;
import java.util.List;

public class setQueryInserisciEventoSportivo {


    public void preparaEseguiQueryInserimentoEventoSportivo(Connection connection, eventoSportivo e, int id) throws SQLException{

        PreparedStatement preparedStatement = setPreparedStatementQuery
                ("INSERT INTO EVENTO_SPORTIVO VALUES (?,?)",connection);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(4,e.getSport().name());
        esecuzioneQueryEvento eseguiQueryEvento=new esecuzioneQueryEvento();
        eseguiQueryEvento.eseguiQueryInserimentoEventoSpecifico(preparedStatement);
        eseguiQueryEvento.eseguiQueryInserisciPartecipantiEventoSportivo(e.getPartecipanti());

    }
    public void preparaEseguiQueryInserimentoPartecipantiEventoSportivo(Connection connection, List<String> partecipanti, int id)throws SQLException,NullPointerException{

        for(String s : partecipanti){
            //Cerca Artista-> se non esiste lo crea
            //se esiste crea l'istanza
        }

    }
    public int setQueryRicercaAtleta(String query){return 0;}
    public PreparedStatement setPreparedStatementQuery(String query,Connection connection)throws SQLException{
        return connection.prepareStatement(query);
    }

}
