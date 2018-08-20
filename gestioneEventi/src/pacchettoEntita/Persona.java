package pacchettoEntita;

public abstract class Persona {

    private String nome;
    private String cognome;
    private String CF;

    public Persona(String nome, String cognome, String CF) {
        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
    }
}
