package cz.vse.adventura.logika;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Batoh
{
    private int maximalniKapacita = 2;
    private int maximalniNosnost = 3;
    private Map<String, Vec> veci = new HashMap<>();
    private static Batoh instance;
    /* Domácí úkol - singleton

     */
    public static Batoh instance()
    {
        if(instance == null)
        {
            instance = new Batoh();
        }
        return instance;
    }

    public void smazVeciVBatohu()
    {
        veci.clear();
    }

    public boolean jeVecVBatohu(String nazev)
    {
        return veci.containsKey(nazev);
    }

    public Vec getVec(String nazev) throws Exception
    {
        if (!jeVecVBatohu(nazev))
        {
            throw new Exception("Batohu se vec nenachazi");
        }
        return veci.get(nazev);
    }

    public Vec odeberVec(String nazev) throws Exception
    {
        if(!jeVecVBatohu(nazev))
        {
            throw new Exception("Batohu se vec nenachazi");
        }
        return veci.remove(nazev);
    }

    private int getHmotnost()
    {
        int hmotnost = 0;
        for(Vec vec : veci.values())
        {
            hmotnost = hmotnost + vec.getHmotnost();
        }
        return hmotnost;

    }

    public Vec pridejVec(Vec vec) throws Exception
    {
        if(jeVecVBatohu(vec.getNazev()))
        {
            throw new Exception("Tato věc v batohu již je");
        }
        if(maximalniKapacita < veci.size() + 1)
        {
            throw new Exception("maximalni kapacita je prekrocena");
        }
        if(maximalniNosnost < getHmotnost() + vec.getHmotnost())
        {
            throw new Exception("Nosnost batohu nesmi bzt prekrocena");
        }
        return veci.put(vec.getNazev(), vec);
    }

    public String getObsah()
    {
        if (veci.isEmpty())
        {
            return "Batoh je prázdný.";
        }
        String seznam = "V batohu máš:";
        for (String nazev : veci.keySet())
        {
            seznam +=  nazev + " ";
        }
        return seznam;
    }

    public Map<String, Vec> getVeciVBatohu()
    {
        return veci;
    }
}
