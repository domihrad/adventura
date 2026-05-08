package cz.vse.adventura.logika;

public class PrikazJdi implements IPrikaz
{
    private static final String NAZEV = "jdi";
    private HerniPlan plan;

    public PrikazJdi(HerniPlan plan)
    {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry)
    {
        if (parametry.length == 0)
        {
            return "Kam mám jít? Musíš zadat jméno východu.";
        }

        String smer = parametry[0];

        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null)
        {
            return "Tudy se nedá jít.";
        }
        else
        {
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis();
        }
    }
    @Override
    public String getNazev()
    {
        return NAZEV;
    }

}
