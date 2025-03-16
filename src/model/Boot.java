package model;

public abstract class Boot implements VrijVerhuurbaar, Comparable<Boot> {

    // attributen

    private static int lastId;
    private final int id;
    private String naam;
    private int lengte;

    // constructors

    protected Boot(String naam, int lengte) {
        this.naam = naam;
        this.setLengte(lengte);
        lastId++;
        id = lastId;
    }

    // methoden

    public abstract double berekenHuurprijs();

    @Override
    public int compareTo(Boot andereBoot) {
        return this.naam.compareTo(andereBoot.naam);
    }

    @Override
    public String toString() {
        return "Boot " + id + " met " + naam;
    }

    // getters en setters

    public void setLengte(int lengte) {
        final int NUL = 0;
        final int DEFAULTWAARDE_LENGTE = 5;

        if (lengte > NUL) {
            this.lengte = lengte;
        }
        else {
            System.out.printf("%d is een negatief getal. Invoer moet positief zijn! Lengte op %d meter gezet.%n", lengte, DEFAULTWAARDE_LENGTE);
            this.lengte = DEFAULTWAARDE_LENGTE;
        }
    }

    public int getLengte() {
        return lengte;
    }
}
