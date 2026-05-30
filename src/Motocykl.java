public class Motocykl extends  DopravniProstredek {
    private int objemMotoru;

    public Motocykl(String vyrobce, String spz, double cenaZaDen, int objemMotoru) {
        super(vyrobce, spz, cenaZaDen);
        this.objemMotoru = objemMotoru;
    }

    public int getObjemMotoru() {
        return objemMotoru;
    }

    public void setObjemMotoru(int objemMotoru) {
        this.objemMotoru = objemMotoru;
    }

    @Override
    public double vypoctiCenu(int pocetDni) {
        double cena = pocetDni * cenaZaDen;
        if (objemMotoru > 700) {
            cena += 700; // poplatek za silný motocykl
        }
        return cena;
    }

    @Override
    public void vypisInfo() {
        System.out.println("  [Motocykl] Výrobce: " + vyrobce + " | SPZ: " + spz + " | Objem motoru: " + objemMotoru + " cm3" + " | Cena/den: " + cenaZaDen + " Kč" + " | Dostupný: " + (dostupny ? "Ano" : "Ne"));
    }
}

