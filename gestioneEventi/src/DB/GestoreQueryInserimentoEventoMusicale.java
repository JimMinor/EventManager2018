package DB;

        import Model.EventoMusicale;

        import java.sql.PreparedStatement;
        import java.sql.SQLException;
        import java.util.HashMap;
        import java.util.Map;
        /**
         *
         * Questa Classe si occupata di gestire tutti gli aspetti necessari,
         * per creare->preparare->settare la query per l'inserimento
         * di un evento  musicale, per in infine inseririla nel DB
         * *
         */
public class GestoreQueryInserimentoEventoMusicale extends GestoreQueryInserimentoEvento<EventoMusicale> {


    public GestoreQueryInserimentoEventoMusicale(EventoMusicale e){ super(e);}

    @Override
    public void eseguiEPreparaQueryInserimentoEvento() throws SQLException {
        super.eseguiEPreparaQueryInserimentoEvento();
        inserisciAttributiEventoSpecifico();

    }

    @Override
    public void inserisciAttributiEventoSpecifico() throws  SQLException{
        eseguiEPreparaQueryInserimentoEventoSpecifico();}

    @Override
    public void eseguiEPreparaQueryInserimentoEventoSpecifico() throws SQLException {
        PreparedStatement queryEventoMusicale = preparaQueryInserimentoEventoSpecifico();
        eseguiUpdate(queryEventoMusicale);
        inserisciPartecipantiEvento(creaMapQueryEventoSpecifico(),getEventoDaInserire().getArtisti());
        UtilityDB.closeDB(queryEventoMusicale);

    }

    @Override
    public Map<Integer,String> creaMapQueryEventoSpecifico() {
        Map<Integer,String> nuovaMappa= new HashMap<Integer,String>();
        //Query che deve essere eseguita per prima
        nuovaMappa.put(1,"SELECT * FROM ARTISTA WHERE NOME_ARTISTA=?");
        //Query che deve essere eseguita per seconda
        nuovaMappa.put(2,"INSERT INTO ARTISTA VALUES(?)");
        //Query per inserire i partecipanti, per ultima
        nuovaMappa.put(3,"INSERT INTO ARTISTI_EVENTO_MUSICALE VALUES(?,?)");
        return nuovaMappa;
    }

    @Override
    public PreparedStatement preparaQueryInserimentoEventoSpecifico() throws  SQLException {
        PreparedStatement queryDaEseguire = preparaQueryDaEseguire("INSERT INTO EVENTO_MUSICALE VALUES (?,?)");
        queryDaEseguire.setInt(1,getIdEventoInserito());
        queryDaEseguire.setString(2,getEventoDaInserire().getGenere().name());
        return queryDaEseguire;

    }


}
