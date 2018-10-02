package Model;

import sun.util.resources.LocaleData;

import java.time.LocalDate;

public class Impiegato extends  Persona {

    /***
     * Da implementare TIPO CONTRATTO, MANSIONE, IBAN
     ****/
    private String username;
    private String password;
    private LocalDate dataAssunzione;
    private Float stipendio;
    private String email;
    private String telefono;
    private String amministratore;
    private int id;
    private String iban;

    public Impiegato () {
        super();
    }

    public Impiegato(String nome, String cognome, LocalDate dataNascita,
                     String CF, String username, String password, LocalDate dataAssunzione,
                     Float stipendio, String amministratore, String telefono, String iban, String email, int id) {
        super(nome, cognome, dataNascita, CF);
        this.username = username;
        this.password = password;
        this.dataAssunzione = dataAssunzione;
        this.stipendio = stipendio;
        this.telefono = telefono;
        this.amministratore = amministratore;
        this.iban = iban;
        this.email = email;
        this.id = id;
    }

    //GETTERS
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public Float getStipendio() {
        return stipendio;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getAmministratore() {
        return amministratore;
    }

    public int getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    // SETTERS

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public void setStipendio(Float stipendio) {
        this.stipendio = stipendio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setAmministratore(String amministratore) {
        this.amministratore = amministratore;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }


    }
