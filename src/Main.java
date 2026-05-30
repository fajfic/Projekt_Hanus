import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("Program spuštěn.");
        EvidencePujcovny evidence = new EvidencePujcovny();

        // --- Ukázková vozidla ---

        // Osobní auta
        evidence.pridejVozidlo(new OsobniAuto("Škoda", "1AB 1234", 800, 5));
        evidence.pridejVozidlo(new OsobniAuto("Volkswagen", "2CD 5678", 1000, 7)); // > 5 míst → +500
        evidence.pridejVozidlo(new OsobniAuto("Ford", "3EF 9012", 750, 4));

        // Dodávky
        evidence.pridejVozidlo(new Dodavka("Mercedes", "4GH 3456", 1200, 10));
        evidence.pridejVozidlo(new Dodavka("Renault", "5IJ 7890", 1400, 15));  // > 12 m3 → +1000
        evidence.pridejVozidlo(new Dodavka("Iveco", "6KL 1234", 1100, 8));

        // Motocykly
        evidence.pridejVozidlo(new Motocykl("Honda", "7MN 5678", 500, 600));
        evidence.pridejVozidlo(new Motocykl("Yamaha", "8OP 9012", 700, 900));   // > 700 cm3 → +700
        evidence.pridejVozidlo(new Motocykl("Kawasaki", "9QR 3456", 650, 400));

        // --- Ukázkoví zákazníci ---
        evidence.pridejZakaznika(new Zakaznik("Jan Novák", "Z001"));
        evidence.pridejZakaznika(new Zakaznik("Marie Svobodová", "Z002"));

        // --- Hlavní menu ---
        Scanner sc= new Scanner(System.in);
        int volba=0;

        while (volba != 1) {
            System.out.println("\n========== PŮJČOVNA VOZIDEL ==========");
            System.out.println("1 - Konec programu");
            System.out.println("2 - Přidat zákazníka");
            System.out.println("3 - Vytvořit výpůjčku");
            System.out.println("4 - Vypsat všechna vozidla");
            System.out.println("5 - Vypsat dostupná vozidla");
            System.out.println("6 - Vypsat všechny zákazníky");
            System.out.println("7 - Vypsat všechny výpůjčky");
            System.out.println("8 - Vypsat celkový příjem");
            System.out.println("9 - Vypsat nejdražší výpůjčku");


            try {
                volba = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                logger.warning("Neplatná volba, zadejte číslo.");
                continue;
            }

            System.out.println();

            switch (volba) {
                case 1:
                    logger.info("Program ukončen.");
                    System.out.println("Nashledanou!");
                    break;
                case 2:
                    System.out.print("Jméno zákazníka: ");
                    String jmeno = sc.nextLine().trim();
                    System.out.print("ID zákazníka: ");
                    String id = sc.nextLine().trim();
                    evidence.pridejZakaznika(new Zakaznik(jmeno, id));
                    break;
                case 3:
                    evidence.vytvorVypujcku(sc);
                    break;
                case 4:
                    evidence.vypisVsechnaVozidla();
                    break;
                case 5:
                    evidence.vypisDostupnaVozidla();
                    break;
                case 6:
                    evidence.vypisVsechnyZakazniky();
                    break;
                case 7:
                    evidence.vypisVsechnyVypujcky();
                    break;
                case 8:
                    evidence.vypisCelkovyPrijem();
                    break;
                case 9:
                    evidence.vypisNejdrazsiVypujcku();
                    break;
                default:
                    System.out.println("Neplatná volba.");
            }
        }

        sc.close();
    }
}