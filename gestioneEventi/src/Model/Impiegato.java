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
    private MansioneEnum amministratore;
    private int id;
    private String iban;


    public Impiegato(String nome, String cognome, LocalDate dataNascita,
                     String CF, String username, String password, LocalDate dataAssunzione,
                     Float stipendio, MansioneEnum amministratore, String telefono, String iban, String email, int id) {
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

    public MansioneEnum getAmministratore() {
        return amministratore;
    }

    public int getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }
}
