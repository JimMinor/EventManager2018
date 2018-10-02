package Model;

import sun.util.resources.LocaleData;

import java.time.LocalDate;

public abstract class Persona {

    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String CF;


    public Persona (){}

    public Persona(String nome, String cognome, String CF) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
    }
	
	public Persona(String nome, String cognome, LocalDate dataNascita, String CF) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }
}
