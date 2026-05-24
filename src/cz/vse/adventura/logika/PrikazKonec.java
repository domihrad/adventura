package cz.vse.adventura.logika;

/**
 *  Třída PrikazKonec implementuje pro hru příkaz konec.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 *  
 */

public class PrikazKonec implements IPrikaz {

    private static final String NAZEV = "konec";

    private Hra hra;

    public PrikazKonec(Hra hra)
    {
        this.hra = hra;
    }


    @Override
    public String provedPrikaz(String... parametry)
    {
        if (parametry.length > 0)
        {
            return "Ukončit co? Nechápu, proč jste zadal druhé slovo.";
        }
        else
        {
            hra.setKonecHry(true);
            return "Hra ukončena příkazem konec";
        }
    }
    @Override
    public String getNazev()
    {
        return NAZEV;
    }
}
