public class Dodavka extends DopravniProstredek{
    private double objemNakladovehoProstoru;

    public Dodavka(String vyrobce, String spz, double cenaZaDen, double objemNakladovehoProstoru) {
        super(vyrobce, spz, cenaZaDen);
        this.objemNakladovehoProstoru = objemNakladovehoProstoru;
    }

    @Override
    public double vypoctiCenu(int pocetDni) {
        double cena = pocetDni * cenaZaDen;
        if (objemNakladovehoProstoru > 12) {
            cena += 1000; // poplatek za velkou dodávku
        }
        return cena;
    }
    @Override
    public void vypisInfo(){
        System.out.println("  [Dodávka] Výrobce: " + vyrobce + " | SPZ: " + spz + " | Objem: " + objemNakladovehoProstoru + " m3" + " | Cena/den: " + cenaZaDen + " Kč" + " | Dostupný: " + (dostupny ? "Ano" : "Ne"));

    }

    public double getObjemNakladovehoProstoru() {
        return objemNakladovehoProstoru;
    }

    public void setObjemNakladovehoProstoru(double objemNakladovehoProstoru) {
        this.objemNakladovehoProstoru = objemNakladovehoProstoru;
    }
}
