package Model;

public enum LuogoEnum {

    SANCARLO(CittaEnum.NAPOLI,30000),
    PALAPARTENOPE(CittaEnum.NAPOLI,3000);

    private CittaEnum cittaLuogo;
    private int numPosti;

    private LuogoEnum(CittaEnum cittaLuogo, int numPosti){
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
