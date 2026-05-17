package cz.vse.adventura.logika;

/* Domácí úkol

 */
public class Zbran extends Vec
{
    private int dmg;

    public Zbran(String nazev, boolean prenositelna, int hmotnost, int dmg)
    {
        super(nazev, prenositelna, hmotnost, 0);
        this.dmg = dmg;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}
