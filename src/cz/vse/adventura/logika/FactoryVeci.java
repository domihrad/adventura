package cz.vse.adventura.logika;

public class FactoryVeci
{

    public static Vec vytvorVec(String typ, String nazev, boolean prenositelna, int hmotnost, int vlastnost)
    {
        if (typ.equals("zbran"))
        {

            return new Zbran(nazev, prenositelna, hmotnost, vlastnost);
        }
        return new Vec(nazev, prenositelna, hmotnost, vlastnost);
    }
}