package pacchettoEntita;


import sun.util.resources.LocaleData;

import java.time.LocalDate;

public abstract class Evento {

    private Enum<luogoEnum> luogoEvento;
    private int capienzaMassima;
    private String Descrizione;
    private float prezzoBiglietto;
    private Enum<tipologiaEnum> tipologiaEvento;
    private String nome;
    private Enum<cittaEnum> citta;
    private LocalDate dataEvento;

    public Evento(luogoEnum luogoEvento, String descrizione, float prezzoBiglietto, Enum<tipologiaEnum> tipologiaEvento, String nome, LocalDate dataEvento) {

        this.luogoEvento = luogoEvento;
        this.capienzaMassima = luogoEvento.getNumPosti();
        Descrizione = descrizione;
        this.prezzoBiglietto = prezzoBiglietto;
        this.tipologiaEvento = tipologiaEvento;
        this.nome = nome;
        this.citta = (luogoEvento).getCittaLuogo();
        this.dataEvento = dataEvento;
    }

    /*********************
     *  Getters          *
     *********************
     */
    public String getNome() {
        return nome;
    }

    public Enum<cittaEnum> getCitta() {
        return citta;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public Enum<luogoEnum> getLuogoEvento() {
        return luogoEvento;
    }

    public int getCapienzaMassima() {
        return capienzaMassima;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public float getPrezzoBiglietto() {
        return prezzoBiglietto;
    }

    public Enum<tipologiaEnum> getTipologiaEvento() {
        return tipologiaEvento;
    }



}