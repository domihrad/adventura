package cz.vse.adventura.logika;

import java.util.*;
import java.util.stream.Collectors;

public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;
    private Map<String, Vec> veci;
    private Set<Drak> drakSmak = new HashSet<>();

    public Prostor(String nazev, String popis)
    {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashSet<>();
        this.veci = new HashMap<>();
    }

    public boolean jeVecVProstoru(String nazevVeci)
    {
        return veci.containsKey(nazevVeci);
    }

    public Vec getVec(String nazevVeci)
    {
        return veci.get(nazevVeci);
    }

    public Vec pridejVec(Vec vec)
    {
        if (jeVecVProstoru(vec.getNazev()))
        {
            return getVec(vec.getNazev());
        }
        veci.put(vec.getNazev(), vec);
        return vec;
    }

    public void pridejDraka(Drak drak)
    {
        drakSmak.add(drak);
    }

    public Vec odeberVec(String nazevVeci)
    {
        return veci.remove(nazevVeci);
    }

    public void setVychod(Prostor vedlejsi)
    {
        vychody.add(vedlejsi);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Prostor))
        {
            return false;
        }
        Prostor druhy = (Prostor) o;
        return (java.util.Objects.equals(this.nazev, druhy.nazev));
    }

    @Override
    public int hashCode()
    {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    public String getNazev()
    {
        return nazev;
    }

    public String dlouhyPopis() {
        String zakladniPopis = "Nacházíš se v " + popis + "\n"
                + popisVychodu() + "\n"
                + popisVeci();

        String drakuvPopis = popisDraka();
        if (!drakuvPopis.isEmpty())
        {
            zakladniPopis += "\n" + drakuvPopis;
        }

        return zakladniPopis;
    }

    private String popisVychodu()
    {
        String vracenyText = "východy:";
        for (Prostor sousedni : vychody)
        {
            vracenyText += " " + sousedni.getNazev();
        }
        return vracenyText;
    }

    private String popisVeci()
    {
        String vracenyText = "veci:";
        for (Vec vec : veci.values()) {
            vracenyText += " " + vec.getNazev();
        }
        return vracenyText;
    }

    private String popisDraka()
    {
        if (drakSmak.isEmpty()) {
            return "";
        }


        String vracenyText = "Pozor! V místnosti s tebou je drak:";

        for (Drak drak : drakSmak)
        {
            vracenyText = vracenyText + " " + drak.getJmeno() + " (životů: " + drak.getZivoty() + ")";
        }
        return vracenyText;
    }

    public Prostor vratSousedniProstor(String nazevSouseda)
    {
        List<Prostor> hledaneProstory =
                vychody.stream()
                        .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                        .collect(Collectors.toList());

        if (hledaneProstory.isEmpty())
        {
            return null;
        }
        else
        {
            return hledaneProstory.get(0);
        }
    }

    public Collection<Prostor> getVychody()
    {
        return Collections.unmodifiableCollection(vychody);
    }
}