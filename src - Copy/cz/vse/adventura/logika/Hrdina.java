package cz.vse.adventura.logika;

public class Hrdina extends Postava
{
    private int zivoty;

    public Hrdina(String jmeno, int zivoty, int silaUtoku)
    {

        super(jmeno, silaUtoku);
        this.zivoty = zivoty;
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