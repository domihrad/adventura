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
            if(sousedniProstor.getNazev().equals("poklad"))
            {
                Drak drak = plan.getDrakSmak();
                if(drak != null && drak.getZivoty() > 0)
                {
                    return "Cestu ti blokuje Šmak! Musíš zabít draka, abys mohl jít dál k pokladu.";
                }
            }

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
