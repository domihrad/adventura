package cz.vse.adventura.logika;

public class PrikazRestart implements IPrikaz {

    private static final String NAZEV = "restart";
    private Hra hra;

    public PrikazRestart(Hra hra)
    {
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry)
    {
        hra.restartujHru();
        return "Hra byla restartována!\n\n\n" + hra.vratUvitani();
    }

    @Override
    public String getNazev()
    {
        return NAZEV;
    }
}