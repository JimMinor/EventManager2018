package Model;

public enum LuogoEnum {

    SANCARLO(CittaEnum.NAPOLI,30000),
    PALAPARTENOPE(CittaEnum.NAPOLI,3000),
    DIANA(CittaEnum.NAPOLI, 2000),
    SANPAOLO(CittaEnum.NAPOLI, 60000),
    PALALOTTOMATICA(CittaEnum.ROMA, 3000),
    OLIMPICO(CittaEnum.ROMA, 50000),
    EXDOAGANA(CittaEnum.ROMA, 400),
    MEDIOLANUMFORUM(CittaEnum.MILANO, 2000),
    SANSIRO(CittaEnum.NAPOLI, 70000),
    MAGAZZINIGENERALI(CittaEnum.MILANO,2500),
    ARENADIVERONA(CittaEnum.VERONA, 5000);

    private CittaEnum cittaLuogo;
    private int numPosti;

    LuogoEnum(CittaEnum cittaLuogo, int numPosti){
        this.cittaLuogo=cittaLuogo;
        this.numPosti=numPosti;
    }

    public CittaEnum getCittaLuogo() {
        return cittaLuogo;
    }

    public int getNumPosti() {
        return numPosti;
    }
}
