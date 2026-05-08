package cz.vse.adventura.logika;

public class HerniPlan {

    private Prostor aktualniProstor;
    private Batoh batoh;
    private Drak drakSmak;
    private Hrdina hrdina;

    public HerniPlan()
    {
        this.batoh = new Batoh();
        this.hrdina = new Hrdina("Hrdina", 3, 2);
        zalozProstoryHry();
    }

    private void zalozProstoryHry()
    {
        Prostor vchod = new Prostor("vchod", "Hlavní vchod do hradu.");
        Prostor zbrojnice = new Prostor("zbrojnice", "Toto je místo se zbraněmi");
        Prostor zalar = new Prostor("žalár", "Místnost kde lidi byli zavřeni.");
        Prostor vez = new Prostor("věž", "Místnost se schody do věže.");
        Prostor jidelna = new Prostor("jídelna", "Místnost s jídlem.");
        Prostor kaple = new Prostor("kaple", "Křesťanská mistnost.");
        Prostor trun = new Prostor("trůn", "Místnost s královským trůnem");
        Prostor loze = new Prostor("lóže", "Místnost na spaní.");

        Prostor doupe = new Prostor("doupě", "Místnost s drakem.");
        Prostor poklad = new Prostor("poklad", "Zde je poklad.");

        vchod.setVychod(zbrojnice);
        zbrojnice.setVychod(doupe);

        drakSmak = new Drak("Šmak", 5, 2);

        aktualniProstor = vchod;
        Vec koste = new Vec("koste", true, 1, 0);

        doupe.pridejDraka(drakSmak);
        aktualniProstor.pridejVec(koste);
    }

    public Prostor getAktualniProstor()
    {
        return aktualniProstor;
    }

    public Hrdina getHrdina()
    {
        return hrdina;
    }

    public Drak getDrakSmak()
    {
        return drakSmak;
    }

    public Vec SeberVec(String nazevVeci) throws Exception
    {
        Vec vec = aktualniProstor.getVec(nazevVeci);
        batoh.pridejVec(vec);
        return aktualniProstor.odeberVec(nazevVeci);
    }

    public void odeberVec(String nazevVeci) throws Exception
    {
        Vec vec = batoh.getVec(nazevVeci);
        batoh.odeberVec(nazevVeci);
        aktualniProstor.pridejVec(vec);
    }

    public Batoh getBatoh()
    {
        return batoh;
    }

    public void setAktualniProstor(Prostor prostor)
    {
        aktualniProstor = prostor;
    }
}