package cz.vse.adventura.logika;

public class PrikazZautoc implements IPrikaz {

    private static final String NAZEV = "útok";
    private Hra hra;

    public PrikazZautoc(Hra hra)
    {
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry)
    {
        HerniPlan plan = hra.getHerniPlan();
        Prostor aktualniProstorHrdiny = plan.getAktualniProstor();
        Hrdina hrdina = plan.getHrdina();

        if (!aktualniProstorHrdiny.getNazev().equals("doupě"))
        {
            return "Na nikoho zde nemůžes zaútočit.";
        }

        Drak drak = plan.getDrakSmak();
        if (drak == null || drak.getZivoty() <= 0)
        {
            return "Drak je mrtvý.";
        }

        StringBuilder vypis = new StringBuilder();


        int poskozeniDrakovi = hrdina.getSilaUtoku();
        drak.setZivoty(drak.getZivoty() - poskozeniDrakovi);
        vypis.append("Ubral si drakovi: ").append(poskozeniDrakovi).append(" životy.\n");
        vypis.append("Šmak počet životů: " + drak.getZivoty() + "\n");

        if (drak.getZivoty() <= 0)
        {
            vypis.append("Drak je mrtvý");
            return vypis.toString();
        }
        if (drak.getZivoty() == 1)
        {
            vypis.append("Šmakovi zbývá ").append(drak.getZivoty()).append(" život.\n\n");
        }
        else
        {
            vypis.append("Šmakovi zbývá ").append(drak.getZivoty()).append(" životů.\n\n");
        }


        int poskozeniHrdinovi = drak.getSilaUtoku();
        hrdina.setZivoty(hrdina.getZivoty() - poskozeniHrdinovi);
        vypis.append("Drak Šmak ti ubral: ").append(poskozeniHrdinovi).append(" životů.\n");

        if (hrdina.getZivoty() <= 0)
        {
            vypis.append("Konec hry! Prohrál si . . . ");
            hra.setKonecHry(true);
        }
        else
        {
            if (hrdina.getZivoty() == 1)
            {
                vypis.append("Zbývá ti ").append(hrdina.getZivoty()).append(" život.\n\n");
            }
            else
            {
                vypis.append("Zbývá ti ").append(hrdina.getZivoty()).append(" životů.\n\n");
            }
        }

        return vypis.toString();
    }

    @Override
    public String getNazev()
    {
        return NAZEV;
    }
}