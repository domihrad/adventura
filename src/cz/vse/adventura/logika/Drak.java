package cz.vse.adventura.logika;
public class Drak extends Postava
{
    private boolean jeZivy;
    private int zivoty;

    public Drak(String jmeno, int zivoty, int silaUtoku)
    {
        super(jmeno, silaUtoku);
        this.zivoty = zivoty;
        this.jeZivy = true;
    }

    public boolean jeZivy()
    {
        return jeZivy;
    }

    public void setJeZivy(boolean stav)
    {
        this.jeZivy = stav;
    }

    public int getZivoty()
    {
        return zivoty;
    }

    public void setZivoty(int zivoty)
    {
        this.zivoty = zivoty;
    }
}