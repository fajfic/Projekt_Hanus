public class OsobniAuto extends DopravniProstredek{
    private int pocetMist;

    public OsobniAuto(String vyrobce, String spz, double cenaZaDen, int pocetMist) {
        super(vyrobce, spz, cenaZaDen);
        this.pocetMist = pocetMist;
    }

    @Override
    public double vypoctiCenu(int pocetDni) {
        double cena = pocetDni * cenaZaDen;
        if(pocetMist > 5){
            cena += 500;
        }
        return cena;
    }

    @Override
    public void vypisInfo(){
        System.out.println("  [Osobní auto] Výrobce: " + vyrobce + " | SPZ: " + spz + " | Místa: " + pocetMist+ " | Cena/den: " +cenaZaDen + " Kč" + " | Dostupný: " + (dostupny ? "Ano" : "Ne"));
    }

    public int getPocetMist() {
        return pocetMist;
    }

    public void setPocetMist(int pocetMist) {
        this.pocetMist = pocetMist;
    }
}
