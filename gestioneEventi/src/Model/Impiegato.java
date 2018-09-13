package Model;

import sun.util.resources.LocaleData;

public class Impiegato extends  Persona {

    private String username;
    private String password;
    private LocaleData dataAssunzione;
    private float stipendio;
    private String email;
    private long telefono;


    public Impiegato(String nome, String cognome, String CF, String username, String password, LocaleData dataAssunzione, float stipendio) {
        super(nome, cognome, CF);
        this.username = username;
        this.password = password;
        this.dataAssunzione = dataAssunzione;
        this.stipendio = stipendio;
    }
}
