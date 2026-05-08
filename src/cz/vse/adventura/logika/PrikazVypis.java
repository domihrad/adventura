package cz.vse.adventura.logika;

public class PrikazVypis implements IPrikaz
{

    private static final String NAZEV = "vypiš";
    private HerniPlan plan;

    public PrikazVypis(HerniPlan plan)
    {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry)
    {
        if (parametry.length == 0)
        {
            return "Zadej batoh nebo prostor";
        }

        String coVypisat = parametry[0];

        if (coVypisat.equals("prostor"))
        {
            return plan.getAktualniProstor().dlouhyPopis();
        }

        if (coVypisat.equals("batoh"))
        {
            return plan.getBatoh().getObsah();
        }

        return coVypisat + "' neznám. Můžeš vypsat 'batoh' nebo 'prostor'.";
    }

    @Override
    public String getNazev()
    {
        return NAZEV;
    }
}