public class Vypujcka {

    private Zakaznik zakaznik;
    private DopravniProstredek prostredek;
    private int pocetDni;
    private boolean platna; // false pokud vozidlo nebylo dostupné

    public Vypujcka(Zakaznik zakaznik, DopravniProstredek prostredek, int pocetDni) {
        this.zakaznik = zakaznik;
        this.prostredek = prostredek;
        this.pocetDni = pocetDni;

        if (prostredek.isDostupny()) {
            prostredek.setDostupny(false);
            this.platna = true;
        } else {
            System.out.println("  CHYBA: Vozidlo " + prostredek.getSpz() + " není dostupné!");
            this.platna = false;
        }
    }

    public boolean isPlatna(){
        return platna;
    }
    public Zakaznik getZakaznik(){
        return zakaznik;
    }
    public DopravniProstredek getProstredek(){
        return prostredek;
    }

    public double celkovaCena() {
        return prostredek.vypoctiCenu(pocetDni);
    }

    public void vypisInfo() {
        if (!platna) {
            System.out.println("  [NEPLATNÁ výpůjčka – vozidlo nebylo dostupné]");
            return;
        }
        System.out.println("  Zákazník: " + zakaznik.getJmeno() + " | SPZ: " + prostredek.getSpz() + " | Počet dní: " + pocetDni + " | Celkem: " + celkovaCena() + " Kč");
    }
}