package pacchettoDB;

        import pacchettoEntita.eventoMusicale;

        import java.sql.PreparedStatement;
        import java.sql.SQLException;

public class gestioneQueryInserimentoEventoMusicale extends  gestioneQueryInserimentoEvento{

    private eventoMusicale eventoMusicaleDaInserire;

    public gestioneQueryInserimentoEventoMusicale(eventoMusicale eventoMusicaleDaInserire) {
        this.eventoMusicaleDaInserire = eventoMusicaleDaInserire;
        setEventoDaInserire(eventoMusicaleDaInserire);
    }

    @Override
    public void eseguiEPreparaQueryInserimentoEvento() throws SQLException {
        super.eseguiEPreparaQueryInserimentoEvento();
        inserisciAttributiEventoMusicale();

    }

    private void inserisciAttributiEventoMusicale() throws  SQLException{eseguiEPreparaQueryInserimentoEventoMusicale();}

    private void eseguiEPreparaQueryInserimentoEventoMusicale() throws SQLException {
        PreparedStatement queryEventoMusicale = preparaQueryInserimentoEventoMusicale();

    }

    private PreparedStatement preparaQueryInserimentoEventoMusicale() throws  SQLException {
        PreparedStatement queryDaEseguire = preparaQueryDaEseguire("INSERT INTO EVENTO_MUSICALE VALUES (?,?");
        queryDaEseguire.setInt(1,getIdEventoInserito());
        //queryDaEseguire.setString(2,eventoMusicaleDaInserire.getArtisti());
        return queryDaEseguire;

    }


}
