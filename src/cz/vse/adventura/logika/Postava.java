package cz.vse.adventura.logika;

public class Postava
{
    private String jmeno;
    private int silaUtoku;

    public Postava(String jmeno, int silaUtoku)
    {
        this.jmeno = jmeno;
        this.silaUtoku = silaUtoku;
    }

    public String getJmeno()
    {
        return jmeno;
    }

    public int getSilaUtoku()
    {
        return silaUtoku;
    }

    public void setSilaUtoku(int silaUtoku)
    {
        this.silaUtoku = silaUtoku;
    }
}
