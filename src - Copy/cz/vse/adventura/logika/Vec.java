package cz.vse.adventura.logika;

public class Vec
{
    private String nazev;
    private boolean prenositelna;
    private int hmotnost;
    private int pridaniZivotu;

    public Vec(String nazev, boolean prenositelna, int hmotnost, int pocetZivotuProPridani)
    {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
        this.hmotnost = hmotnost;
        this.pridaniZivotu = pocetZivotuProPridani;
    }

    public String getNazev()
    {
        return nazev;
    }

    public void setNazev(String nazev)
    {
        this.nazev = nazev;
    }

    public boolean isPrenositelna()
    {
        return prenositelna;
    }

    public void setPrenositelna(boolean prenositelna)
    {
        this.prenositelna = prenositelna;
    }

    public int getHmotnost()
    {
        return hmotnost;
    }

    public void setHmotnost(int hmotnost)
    {
        this.hmotnost = hmotnost;
    }

    public int getPridaniZivotu()
    {
        return pridaniZivotu;
    }

    public void setPridaniZivotu(int pridaniZivotu)
    {
        this.pridaniZivotu = pridaniZivotu;
    }
}
