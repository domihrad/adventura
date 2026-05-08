package cz.vse.adventura.logika;

public class PrikazSeber implements IPrikaz
{
    private static final String NAZEV = "seber";
    private HerniPlan plan;

    public PrikazSeber(HerniPlan plan)
    {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry)
    {
        if (parametry.length == 0)
        {
            return "Nevim co sebrat";
        }

        String nazevVeci = parametry[0];

        try
        {

            plan.SeberVec(nazevVeci);
            return "Věc " + nazevVeci + " byla sebrána";
        }
        catch (Exception e)
        {
            return "Vec neslo sebrat " + e.getMessage();
        }


    }

    @Override
    public String getNazev()
    {
        return NAZEV;
    }

}
