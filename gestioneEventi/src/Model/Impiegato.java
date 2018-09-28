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


    public Impiegato(String nome, String cognome, LocalDate dataNascita,
                     String CF, String username, String password, LocalDate dataAssunzione,
                     Float stipendio, String amministratore,String telefono,String iban,String email,int id) {
        super(nome, cognome, dataNascita, CF);
        this.username = username;
        this.password = password;
        this.dataAssunzione = dataAssunzione;
        this.stipendio = stipendio;
        this.telefono = telefono;
        this.amministratore=amministratore;

        this.iban=iban;
        this.email=email;
        this.id=id;
    }
}
