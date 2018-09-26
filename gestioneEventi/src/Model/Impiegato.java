package Model;

import sun.util.resources.LocaleData;

import java.time.LocalDate;

public class Impiegato extends  Persona {

    /***
     * Da implementare TIPO CONTRATTO, MANSIONE, IBAN
     ****/
    private String username;
    private String password;
    private LocalDate dataNascita;
    private LocalDate dataAssunzione;
    private float stipendio;
    private String email;
    private long telefono;


    public Impiegato(String nome, String cognome, LocalDate dataNascita, String CF, String username, String password, LocalDate dataAssunzione, float stipendio) {
        super(nome, cognome, dataNascita, CF);
        this.username = username;
        this.password = password;
        this.dataAssunzione = dataAssunzione;
        this.stipendio = stipendio;
    }
}
