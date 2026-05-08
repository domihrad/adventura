package cz.vse.adventura.logika;

public class PrikazVylecit implements IPrikaz {

    private static final String NAZEV = "vyléčit";
    private HerniPlan plan;

    public PrikazVylecit(HerniPlan plan)
    {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry)
    {
        if (parametry.length == 0)
        {
            return "Pro výléčení je třeba lektvar.";
        }

        String nazevVeci = parametry[0];
        Batoh batoh = plan.getBatoh();
        Hrdina hrdina = plan.getHrdina();

        if (!batoh.jeVecVBatohu(nazevVeci))
        {
            return "Věc '" + nazevVeci + "' nemáš u sebe.";
        }

        if (nazevVeci.equals("lektvar"))
        {
            try
            {
                Vec lektvarLeceni = batoh.getVec(nazevVeci);
                batoh.odeberVec(nazevVeci);
                hrdina.setZivoty(hrdina.getZivoty() + lektvarLeceni.getPridaniZivotu());

                return "Máš teď: " + hrdina.getZivoty();
            }
            catch (Exception e)
            {
                return "Věc nešlo použít k vyléčení: " + e.getMessage();
            }
        }
        else
        {
            return "Věc '" + nazevVeci + " ti nepomohla.";
        }
    }

    @Override
    public String getNazev()
    {
        return NAZEV;
    }
}