package DB;

import Model.Impiegato;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

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
    public Collection<Impiegato> cercaImpiegato(String nome, String cognome, LocalDate dataNascita) throws Exception {
        return null;
    }

    @Override
    public boolean eliminaImpiegato(Impiegato impiegatoDaInserire)  {
        return true;
    }



}
