package Model;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.prefs.Preferences;

public  class Evento implements Comparable<Evento> {

    private LuogoEnum luogoEvento;
    private int capienzaMassima;
    private String Descrizione;
    private Float prezzoBiglietto;
    private TipologiaEnum tipologiaEvento;
    private String nome;
    private CittaEnum citta;
    private LocalDate dataEvento;
    private int idEvento;
    private String genereEvento;
    private Set<String> partecipantiEvento;


    public Evento (){}

    public Evento(LuogoEnum luogoEvento, String descrizione,
                  Float prezzoBiglietto, TipologiaEnum tipologiaEvento,
                  String nome, LocalDate dataEvento, String genereEvento, Set<String> partecipantiEvento) {

        idEvento=0;// Viene gestito nel DB
        this.luogoEvento = luogoEvento;
        this.capienzaMassima = luogoEvento.getNumPosti();
        Descrizione = descrizione;
        this.prezzoBiglietto = prezzoBiglietto;
        this.tipologiaEvento = tipologiaEvento;
        this.nome = nome;
        this.citta = luogoEvento.getCittaLuogo();
        this.dataEvento = dataEvento;
        this.genereEvento=genereEvento;
        this.partecipantiEvento=partecipantiEvento;

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

    public Float getPrezzoBiglietto() {
        return prezzoBiglietto;
    }

    public TipologiaEnum getTipologiaEvento() {
        return tipologiaEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    /*********************
     *  Setters         *
     *********************
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public void setLuogoEvento(LuogoEnum luogoEvento) {
        this.luogoEvento = luogoEvento;
    }

    public void setCapienzaMassima(int capienzaMassima) {
        this.capienzaMassima = capienzaMassima;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public void setPrezzoBiglietto(Float prezzoBiglietto) {
        this.prezzoBiglietto = prezzoBiglietto;
    }

    public void setTipologiaEvento(TipologiaEnum tipologiaEvento) {
        this.tipologiaEvento = tipologiaEvento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(CittaEnum citta) {
        this.citta = citta;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getGenereEvento() {
        return genereEvento;
    }

    public void setGenereEvento(String genereEvento) {
        this.genereEvento = genereEvento;
    }

    public Set<String> getPartecipantiEvento() {
        return partecipantiEvento;
    }

    public void setPartecipantiEvento(Set<String> partecipantiEvento) {
        this.partecipantiEvento = partecipantiEvento;
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