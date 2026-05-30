import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class EvidencePujcovny {

    private static final Logger logger = Logger.getLogger(EvidencePujcovny.class.getName());

    private ArrayList<DopravniProstredek> vozidla;
    private ArrayList<Zakaznik> zakaznici;
    private ArrayList<Vypujcka> vypujcky;

    public EvidencePujcovny() {
        vozidla   = new ArrayList<>();
        zakaznici = new ArrayList<>();
        vypujcky  = new ArrayList<>();
    }

    // Přidá vozidlo do seznamu
    public void pridejVozidlo(DopravniProstredek v) {
        vozidla.add(v);
    }

    // Přidá zákazníka, kontroluje unikátnost ID
    public void pridejZakaznika(Zakaznik z) {
        for (Zakaznik existujici : zakaznici) {
            if (existujici.getIdZakaznika().equalsIgnoreCase(z.getIdZakaznika())) {
                System.out.println("  Zákazník s ID " + z.getIdZakaznika() + " už existuje.");
                logger.warning("Pokus o přidání duplicitního zákazníka: " + z.getIdZakaznika());
                return;
            }
        }
        zakaznici.add(z);
        logger.info("Přidán zákazník: " + z.getJmeno() + " (ID: " + z.getIdZakaznika() + ")");
        System.out.println("Zákazník " + z.getJmeno() + " byl přidán.");
    }

    // Výpis všech vozidel – polymorfismus přes vypisInfo()
    public void vypisVsechnaVozidla() {
        System.out.println("--- Všechna vozidla ---");
        for (DopravniProstredek v : vozidla) {
            v.vypisInfo(); // každý typ vypíše svoji verzi
        }
    }

    // Výpis pouze dostupných vozidel
    public void vypisDostupnaVozidla() {
        System.out.println("--- Dostupná vozidla ---");
        boolean nalezeno = false;
        for (DopravniProstredek v : vozidla) {
            if (v.isDostupny()) {
                v.vypisInfo();
                nalezeno = true;
            }
        }
        if (!nalezeno) {
            System.out.println("Žádné dostupné vozidlo.");
        }
    }

    // Výpis všech zákazníků
    public void vypisVsechnyZakazniky() {
        System.out.println("--- Zákazníci ---");
        for (Zakaznik z : zakaznici) {
            z.vypisInfo();
        }
    }

    // Vytvoření výpůjčky pomocí Scanneru
    public void vytvorVypujcku(Scanner sc) {
        System.out.print("Zadejte ID zákazníka: ");
        String idZ = sc.nextLine().trim();

        Zakaznik nalezenyZakaznik = null;
        for (Zakaznik z : zakaznici) {
            if (z.getIdZakaznika().equalsIgnoreCase(idZ)) {
                nalezenyZakaznik = z;
                break;
            }
        }

        if (nalezenyZakaznik == null) {
            System.out.println("Zákazník s tímto ID neexistuje.");
            return;
        }

        System.out.print("Zadejte SPZ vozidla: ");
        String spz = sc.nextLine().trim();

        DopravniProstredek nalezeneVozidlo = null;
        for (DopravniProstredek v : vozidla) {
            if (v.getSpz().equalsIgnoreCase(spz)) {
                nalezeneVozidlo = v;
                break;
            }
        }

        if (nalezeneVozidlo == null) {
            System.out.println("Vozidlo s touto SPZ neexistuje.");
            return;
        }

        System.out.print("Zadejte počet dní: ");
        int pocetDni;
        try {
            pocetDni = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Neplatný počet dní.");
            return;
        }

        if (!nalezeneVozidlo.isDostupny()) {
            logger.warning("Pokus o výpůjčku nedostupného vozidla: " + spz);
        }

        Vypujcka v = new Vypujcka(nalezenyZakaznik, nalezeneVozidlo, pocetDni);
        if (v.isPlatna()) {
            vypujcky.add(v);
            logger.info("Vytvořena výpůjčka: zákazník " + nalezenyZakaznik.getIdZakaznika()
                    + ", SPZ " + spz + ", " + pocetDni + " dní");
            System.out.println("Výpůjčka úspěšně vytvořena. Cena: " + v.celkovaCena() + " Kč");
        }
    }

    // Výpis všech výpůjček
    public void vypisVsechnyVypujcky() {
        System.out.println("--- Výpůjčky ---");
        if (vypujcky.isEmpty()) {
            System.out.println("Žádné výpůjčky.");
            return;
        }
        for (Vypujcka v : vypujcky) {
            v.vypisInfo();
        }
    }

    // Celkový příjem ze všech výpůjček
    public void vypisCelkovyPrijem() {
        double celkem = 0;
        for (Vypujcka v : vypujcky) {
            celkem += v.celkovaCena();
        }
        System.out.println("--- Celkový příjem: "+celkem+ " Kč ---");
    }

    // Nejdražší výpůjčka
    public void vypisNejdrazsiVypujcku() {
        if (vypujcky.isEmpty()) {
            System.out.println("Žádné výpůjčky.");
            return;
        }
        Vypujcka nejdrazsi = vypujcky.get(0);
        for (Vypujcka v : vypujcky) {
            if (v.celkovaCena() > nejdrazsi.celkovaCena()) {
                nejdrazsi = v;
            }
        }
        System.out.println("--- Nejdražší výpůjčka ---");
        nejdrazsi.vypisInfo();
    }
}
