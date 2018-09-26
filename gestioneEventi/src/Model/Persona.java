package Model;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocaleData getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocaleData dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }
}
