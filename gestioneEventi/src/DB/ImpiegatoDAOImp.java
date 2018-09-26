package DB;

import Model.Impiegato;

import java.sql.SQLException;

public class ImpiegatoDAOImp implements ImpiegatoDAO {

    private Impiegato impiegatoDaInserire;

    public ImpiegatoDAOImp(){}

    public ImpiegatoDAOImp(Impiegato impiegatoDaInserire) {
        this.impiegatoDaInserire = impiegatoDaInserire;
    }

    @Override
    public boolean inserisciImpiegato(Impiegato impiegatoDaInserire)  {
        return true;
    }

    @Override
    public boolean eliminaImpiegato(Impiegato impiegatoDaInserire)  {
        return true;
    }



}
