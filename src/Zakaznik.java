public class Zakaznik {

    private String jmeno;
    private String idZakaznika;

    public Zakaznik(String jmeno, String idZakaznika) {
        this.jmeno = jmeno;
        this.idZakaznika = idZakaznika;
    }

    public String getIdZakaznika(){
        return idZakaznika;
    }
    public String getJmeno(){
        return jmeno;
    }

    public void vypisInfo() {
        System.out.println("  Zákazník: " + jmeno + " | ID: " + idZakaznika);
    }
}