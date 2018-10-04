package Model;

import java.time.LocalDate;

public class Cliente extends Persona implements Comparable<Cliente> {

    private String username;
    private String password;
    private String mail;
    private Float spesaTot;
    private Float spesaCarta;
    private int numBiglietti;
    private int id;
    private String telefono;



    public Cliente(){
        super();
    }

    public Cliente(String cf,int id,String username,String password,String mail,String telefono,Float spesaTot,Float spesaCarta,int numBiglietti,String nome,String cognome,LocalDate dataNascita) {
        super(nome, cognome, dataNascita,cf);
        this.username = username;
        this.password=password;
        this.mail = mail;
        this.spesaTot=spesaTot;
        this.numBiglietti=numBiglietti;
        this.spesaCarta=spesaCarta;
        this.id=id;
        this.telefono=telefono;

    }

    @Override
    public int compareTo(Cliente altro){
        return altro.username.compareTo(username);
    }

    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public Float getSpesaTot() {
        return spesaTot;
    }

    public Float getSpesaCarta() {
        return spesaCarta;
    }

    public int getNumBiglietti() {
        return numBiglietti;
    }

    public int getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public boolean equals(Object altro){
        if(altro==this) return true;
        if(altro==null || altro.getClass()!=getClass())return false;
        Cliente c = (Cliente) altro;
        return c.getCF() == getCF();
    }
}