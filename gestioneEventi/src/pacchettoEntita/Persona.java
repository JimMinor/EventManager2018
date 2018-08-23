package pacchettoEntita;

import sun.util.resources.LocaleData;

public abstract class Persona {

    private String nome;
    private String cognome;
    private LocaleData dataNascita;
    private String CF;

    public Persona(String nome, String cognome, String CF) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
    }
}
