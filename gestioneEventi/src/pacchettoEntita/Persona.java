package pacchettoEntita;

import sun.util.resources.LocaleData;

import java.time.*;

public abstract class Persona {

    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String CF;

    public Persona(String nome, String cognome, String CF,LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.dataNascita=dataNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getCF() {
        return CF;
    }
}
