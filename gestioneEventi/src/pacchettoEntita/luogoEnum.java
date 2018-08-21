package pacchettoEntita;
import jdk.nashorn.internal.ir.EmptyNode;

import java.util.*;
import java.util.*;

public enum luogoEnum {

    SANCARLO(cittaEnum.NAPOLI,30000),
    PALAPARTENOPE(cittaEnum.NAPOLI,3000);


    private Enum<cittaEnum> cittaLuogo;
    private int numPosti;

    private luogoEnum (Enum<cittaEnum> cittaLuogo,int numPosti){
        this.cittaLuogo=cittaLuogo;
        this.numPosti=numPosti;
    }

    public Enum<cittaEnum> getCittaLuogo() {
        return cittaLuogo;
    }

    public int getNumPosti() {
        return numPosti;
    }
}
