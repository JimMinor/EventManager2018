package Model;

public class Clienti extends Persona {
    private String username;
    private String sesso;
    private String indirizzo;
    private String mail;


    public Clienti(String nome, String cognome, String CF, String username, String sesso, String indirizzo, String mail) {
        super(nome, cognome, CF);
        this.username = username;
        this.indirizzo = indirizzo;
        this.sesso = sesso;
        this.mail = mail;

    }
}