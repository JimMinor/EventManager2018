package pacchettoEntita;

import sun.util.resources.LocaleData;

import java.time.*;
import java.util.*;

public class Impiegato extends  Persona {

    private String username;
    private String password;
    private LocalDate dataAssunzione;
    private float stipendio;
    private String email;
    private long telefono;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public float getStipendio() {
        return stipendio;
    }

    public String getEmail() {
        return email;
    }

    public long getTelefono() {
        return telefono;
    }

    public Impiegato(String nome, String cognome, String CF, LocalDate dataNascita){super(nome, cognome, CF,dataNascita);}
    public Impiegato(String nome, String cognome, String CF, LocalDate dataNascita,
                     String username, String password, LocalDate dataAssunzione,
                     float stipendio,String email,Long telefono) {
        super(nome, cognome, CF,dataNascita);
        this.username = username;
        this.password = password;
        this.dataAssunzione = dataAssunzione;
        this.stipendio = stipendio;
        this.email=email;
        this.telefono=telefono;
    }
}
