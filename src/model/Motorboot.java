package model;

public class Motorboot extends Boot {

    // attributen

    private int maxSnelheid;

    // constructors

    public Motorboot(String naam, int lengte, int maxSnelheid){
        super(naam, lengte);
        this.maxSnelheid = maxSnelheid;
    }

    // methoden

    @Override
    public boolean isVaarbewijsPlichtig(){
        final int GRENS_LENGTE = 15;
        final int GRENS_SNELHEID = 20;

        if (this.getLengte() > GRENS_LENGTE || this.maxSnelheid > GRENS_SNELHEID) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public double berekenHuurprijs() {
        final int GRENS_LENGTE = 10;
        final double PRIJS_KORTE_BOOT = 60.0;
        final double PRIJS_LANGE_BOOT = 90.0;

        if (this.getLengte() < GRENS_LENGTE) {
            return PRIJS_KORTE_BOOT;
        }
        else {
            return PRIJS_LANGE_BOOT;
        }
    }

    @Override
    public String toString() {
        String vaarbewijsVereist;
        StringBuilder builderResultaat = new StringBuilder();

        if (this.isVaarbewijsPlichtig()) {
            vaarbewijsVereist = "Ja";
        }
        else {
            vaarbewijsVereist = "Nee";
        }

        builderResultaat.append(super.toString().replace("Boot","Motorboot"));
        builderResultaat.append(String.format("\n\tVaarbewijs vereist: %s%n\tHuurprijs: %.2f euro per dag\n", vaarbewijsVereist, this.berekenHuurprijs()));

        return builderResultaat.toString();
    }

    // getters en setters

}
