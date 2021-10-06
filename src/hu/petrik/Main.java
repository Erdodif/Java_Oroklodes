package hu.petrik;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem adja meg a rekeszének maximális teherbírását:");
        int maxTeher = sc.nextInt();
        Rekesz rekesz = new Rekesz(maxTeher);
        boolean megFer = true;
        try {
            FileReader fr = new FileReader("palackok.txt");
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            megFer = true;
            while (sor != null && megFer) {
                int meret = rekesz.getPalackok().size();
                String[] tartalom = sor.split(";");
                switch (tartalom.length) {
                    case 4:
                        rekesz.uj_palack(new VisszavalthatoPalack(
                                tartalom[0],
                                Integer.parseInt(tartalom[1]),
                                Integer.parseInt(tartalom[2]),
                                Integer.parseInt(tartalom[3])));
                        break;
                    case 3:
                        rekesz.uj_palack(new VisszavalthatoPalack(
                                tartalom[0],
                                Integer.parseInt(tartalom[1]),
                                Integer.parseInt(tartalom[2])));
                        break;
                    default:
                        rekesz.uj_palack(new Palack(
                                tartalom[0],
                                Integer.parseInt(tartalom[1])));
                        break;
                }
                megFer = meret < rekesz.getPalackok().size();
                sor = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Hiba: " + e);
        }
        System.out.println("Palackok (" + rekesz.getPalackok().size() + " db):");
        for (Palack palack : rekesz.getPalackok()) {
            System.out.println(palack.toString());
        }
        if (!megFer) {
            System.out.println("A rekesz megtelt, volt olyan palack, ami nem került bele. Szerezzen nagyobb rekeszt...");
        } else {
            System.out.println("A rekeszbe elfért az összes palack, szép munka!");
        }
        System.out.print("A rekeszért " + rekesz.osszes_penz() + " forint szerezhető");
        if (rekesz.osszes_penz() > 1000) {
            System.out.println(", szép fizetés!");
        } else {
            System.out.println(".");
        }
    }
}

