package cz.vse.adventura.logika;

public class PrikazVylecit implements IPrikaz
{

    private static final String NAZEV = "vyléčit";
    private HerniPlan plan;

    @Override
    public String provedPrikaz(String... parametry)
    {
        if (parametry.length == 0)
        {
            return "Nevim s čím se mám uzdravit.";
        }

        String nazevVeci = parametry[0];

        try
        {

            plan.SeberVec(nazevVeci);

            return "Věc " + nazevVeci + " byla sebrána";
        }
        catch (Exception e)
        {
            return "Vec neslo použít " + e.getMessage();
        }


    }

    @Override
    public String getNazev()
    {
        return NAZEV;
    }
}
