package Model;

import sun.util.resources.LocaleData;

import java.time.LocalDate;

public class Addetto extends  Persona {

    private LocalDate dataAssunzione;
    private Float stipendio;
    private String email;
    private String telefono;
    private int id;
    private String iban;

    public Addetto () {
        super();
    }

    public Addetto(String nome, String cognome, LocalDate dataNascita,
                   String CF, LocalDate dataAssunzione,
                   Float stipendio, String telefono, String iban, String email, int id) {
        super(nome, cognome, dataNascita, CF);
        this.dataAssunzione = dataAssunzione;
        this.stipendio = stipendio;
        this.telefono = telefono;
        this.iban = iban;
        this.email = email;
        this.id = id;
    }

    //GETTERS



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

    public int getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    // SETTERS



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

    @Override
    public String toString() {
        return "Addetto{" +
                "dataAssunzione=" + dataAssunzione +
                ", stipendio=" + stipendio +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", id=" + id +
                ", iban='" + iban + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }


}
