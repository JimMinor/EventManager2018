package Model;

import java.time.LocalDate;

public class Cliente extends Persona implements Comparable<Cliente> {

    private String username;
    private String sesso;
    private String indirizzo;
    private String mail;
    private Float spesaTot;
    private Float spesaCarta;
    private int numBiglietti;
    private int id;


    public Cliente(String nome, String cognome, String CF, String username, String indirizzo, String mail, LocalDate dataNascita, Float spesaTot, Float spesaCarta,int numBiglietti,int id ) {
        super(nome, cognome, dataNascita,CF);
        this.username = username;
        this.indirizzo = indirizzo;
        this.mail = mail;
        this.spesaTot=spesaTot;
        this.numBiglietti=numBiglietti;
        this.spesaCarta=spesaCarta;
        this.id=id;

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