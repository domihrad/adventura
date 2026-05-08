package cz.vse.adventura;
import cz.vse.adventura.logika.Hra;
import cz.vse.adventura.logika.IHra;
import cz.vse.adventura.uiText.TextoveRozhrani;

public class Start
{
    static void main(String[] args)
    {
        IHra hra = new Hra();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        ui.hraj();

    }
}
