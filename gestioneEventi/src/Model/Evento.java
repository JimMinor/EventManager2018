package Model;


import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Evento implements Comparable<Evento> {

    private LuogoEnum luogoEvento;
    private int capienzaMassima;
    private String Descrizione;
    private float prezzoBiglietto;
    private TipologiaEnum tipologiaEvento;
    private String nome;
    private CittaEnum citta;
    private LocalDate dataEvento;
    private int idEvento;

    public Evento(LuogoEnum luogoEvento, String descrizione,
                  float prezzoBiglietto, TipologiaEnum tipologiaEvento,
                  String nome, LocalDate dataEvento) {

        idEvento=0;// Viene gestito nel DB
        this.luogoEvento = luogoEvento;
        this.capienzaMassima = luogoEvento.getNumPosti();
        Descrizione = descrizione;
        this.prezzoBiglietto = prezzoBiglietto;
        this.tipologiaEvento = tipologiaEvento;
        this.nome = nome;
        this.citta = luogoEvento.getCittaLuogo();
        this.dataEvento = dataEvento;
    }

    /*********************
     *  Getters          *
     *********************
     */
    public String getNome() {
        return nome;
    }

    public CittaEnum getCitta() {
        return citta;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public LuogoEnum getLuogoEvento() {
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

    public TipologiaEnum getTipologiaEvento() {
        return tipologiaEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }


    /**
     *  Due Eventi verrano considerati uguali secondo equals se e solo se
     *  Data e Luogo dell'evento sono uguali.
     * @param other Oggetto da confrontare
     * @return
     */
    @Override
    public boolean equals(Object other){
        if (other == null || other.getClass()!=getClass()) return false;
        if(other==this) return true;
        Evento e = (Evento)other;
        if(e.getDataEvento()==this.getDataEvento() && e.getLuogoEvento()==this.getLuogoEvento())
            return true;
        return false;
    }

    /** L'ordine naturale da seguire per eventi
     *  sara' la loro data
     * @param e
     * @return
     */
    @Override
    public int compareTo(Evento e){ return e.dataEvento.compareTo(e.dataEvento); }

    @Override
    public String toString(){
        return "Nome Evento: "+ nome +" Data:  "+ dataEvento+" Luogo: "+ luogoEvento;
    }




}