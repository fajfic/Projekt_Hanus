public abstract class DopravniProstredek {
    protected String vyrobce;
    protected String spz;
    protected double cenaZaDen;
    protected boolean dostupny;

    public DopravniProstredek(String vyrobce, String spz, double cenaZaDen) {
        this.vyrobce = vyrobce;
        this.spz = spz;
        this.cenaZaDen = cenaZaDen;
        this.dostupny = true;
    }

    public String getVyrobce() {
        return vyrobce;
    }

    public void setVyrobce(String vyrobce) {
        this.vyrobce = vyrobce;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public double getCenaZaDen() {
        return cenaZaDen;
    }

    public void setCenaZaDen(double cenaZaDen) {
        this.cenaZaDen = cenaZaDen;
    }

    public boolean isDostupny() {
        return dostupny;
    }

    public void setDostupny(boolean dostupny) {
        this.dostupny = dostupny;
    }

    public void vypisInfo(){
        System.out.println("  Výrobce: " + vyrobce + " | SPZ: " + spz + " | Cena/den: " + cenaZaDen + " Kč" + " | Dostupný: " + (dostupny ? "Ano" : "Ne"));
    }

    public abstract double vypoctiCenu(int pocetDni);
}
