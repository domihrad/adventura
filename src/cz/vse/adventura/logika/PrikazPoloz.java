package cz.vse.adventura.logika;

public class PrikazPoloz implements IPrikaz
{
    private static final String NAZEV = "polož";
    private HerniPlan plan;

    public PrikazPoloz(HerniPlan plan)
    {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry)
    {
        if (parametry.length == 0)
        {
            return "Nevim co odebrat";
        }
        String nazevVeci = parametry[0];

        try
        {

            plan.odeberVec(nazevVeci);
            return "Věc " + nazevVeci + " byla odebrána";
        }
        catch (Exception e)
        {
            return "Vec neslo odebrat " + e.getMessage();
        }
    }
    @Override
    public String getNazev()
    {
        return NAZEV;
    }

}