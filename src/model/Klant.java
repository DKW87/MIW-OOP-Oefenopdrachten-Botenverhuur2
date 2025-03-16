package model;

public class Klant {

    // attributen

    private String naam;
    private String emailadres;
    private boolean vaarVaardigheid;

    // constructors

    public Klant(){
        this("onbekend");
    }

    public Klant (String naam) {
        this(naam, "onbekend", false);
    }

    public Klant(String naam, String emailadres, boolean vaardigheid) {
        this.naam = naam;
        this.emailadres = emailadres;
        this.vaarVaardigheid = vaardigheid;
    }

    // methoden

    public boolean isVaarVaardig(){
        return vaarVaardigheid;
    }

    @Override
    public String toString() {
        return "Klant " + naam;
    }

    // getters en setters

}
