package cz.vse.adventura.logika;

import java.util.Map;

public class HerniPlan {

    private Prostor aktualniProstor;
    private Batoh batoh;
    private Drak drakSmak;
    private Hrdina hrdina;
    private int zakladniSilaUtoku = 2;

    public HerniPlan()
    {
        this.batoh = Batoh.instance();
        this.batoh.smazVeciVBatohu();
        this.hrdina = new Hrdina("Hrdina", 3, zakladniSilaUtoku);
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
        doupe.setVychod(zbrojnice);


        drakSmak = new Drak("Šmak", 5, 2);

        aktualniProstor = vchod;
        Vec lektvatZivota = FactoryVeci.vytvorVec("vec", "lektvar", true, 1, 2);
        Vec koste = FactoryVeci.vytvorVec("zbran", "koště", true, 1, 3);

        doupe.pridejDraka(drakSmak);
        aktualniProstor.pridejVec(koste);
        aktualniProstor.pridejVec(lektvatZivota);
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
        setNejsilnejsiZbran(vec);
        return aktualniProstor.odeberVec(nazevVeci);
    }

    public void odeberVec(String nazevVeci) throws Exception
    {
        Vec vec = batoh.getVec(nazevVeci);
        batoh.odeberVec(nazevVeci);
        odstranSiluUtoku();
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

    public void setNejsilnejsiZbran(Vec danaVec)
    {
        if(danaVec instanceof Zbran)
        {
            Zbran zvolenaZbran = (Zbran) danaVec;
            if(zvolenaZbran.getDmg() > hrdina.getSilaUtoku())
            {
                hrdina.setSilaUtoku(zvolenaZbran.getDmg());
                System.out.println("Nová zbraň : " + zvolenaZbran.getNazev() + ", nová síla útoku: " + hrdina.getSilaUtoku());
            }
        }
    }
    public void odstranSiluUtoku()
    {
        Vec nejsilnejsiVec = null;
        hrdina.setSilaUtoku(zakladniSilaUtoku);
        Map<String, Vec> veci = batoh.getVeciVBatohu();
        for (Vec vec : veci.values())
        {
            if(vec instanceof Zbran)
            {
                Zbran zvolenaZbran = (Zbran) vec;
                if(zvolenaZbran.getDmg() > hrdina.getSilaUtoku())
                {
                    hrdina.setSilaUtoku(zvolenaZbran.getDmg());
                }
            }
        }
        if(nejsilnejsiVec == null)
        {
            System.out.println("Nejsilnejsi zbran jsou tvoje ruce s útokem: " + hrdina.getSilaUtoku());
        }
        else
        {
            System.out.println("Nejsilnější zbraň je " + nejsilnejsiVec.getNazev() + " s útokem: " + hrdina.getSilaUtoku());
        }
    }
}