package cz.vse.adventura.uiText;


import java.io.*;
import java.util.Scanner;

import cz.vse.adventura.logika.IHra;

public class TextoveRozhrani {
    private IHra hra;

    public TextoveRozhrani(IHra hra) {
        this.hra = hra;
    }

    public void hraj()
    {
        System.out.println(hra.vratUvitani());

        while (!hra.konecHry())
        {
            String radek = prectiString();

            System.out.println(hra.zpracujPrikaz(radek));
        }

        System.out.println(hra.vratEpilog());
    }



    public void hrajZeSouboru (String nazevSouboru)
    {
        try (
                BufferedReader cteni = new BufferedReader(new FileReader(nazevSouboru));
                PrintWriter zapis = new PrintWriter(new FileWriter("vystup.txt"))
        )
        {
            System.out.println(hra.vratUvitani());
            zapis.println(hra.vratUvitani());

            for (String radek = cteni.readLine(); radek != null && !hra.konecHry(); radek = cteni.readLine())
            {
                System.out.println("> " + radek);
                zapis.println("> " + radek);

                String vystup = hra.zpracujPrikaz(radek);

                System.out.println(vystup);
                zapis.println(vystup);
            }

            System.out.println(hra.vratEpilog());
            zapis.println(hra.vratEpilog());

        } catch (FileNotFoundException e)
        {
            File file = new File(nazevSouboru);
            System.out.println("Soubor nebyl nalezen!\nProhledávaná cesta byla: " + file.getAbsolutePath());
        }
        catch (IOException e)
        {
            System.out.println("Nelze hrát hru ze souboru, něco se pokazilo: " + e.getMessage());
        }
    }

    private String prectiString()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextLine();
    }

}
