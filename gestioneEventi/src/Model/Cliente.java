package Model;

public class Cliente extends Persona implements Comparable<Cliente> {

    private String username;
    private String sesso;
    private String indirizzo;
    private String mail;


    public Cliente(String nome, String cognome, String CF, String username, String sesso, String indirizzo, String mail) {
        super(nome, cognome, CF);
        this.username = username;
        this.indirizzo = indirizzo;
        this.sesso = sesso;
        this.mail = mail;

    }

    @Override
    public int compareTo(Cliente altro){
        return altro.username.compareTo(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object altro){
        if(altro==this) return true;
        if(altro==null || altro.getClass()!=getClass())return false;
        Cliente c = (Cliente) altro;
        return c.getCF() == getCF();
    }
}