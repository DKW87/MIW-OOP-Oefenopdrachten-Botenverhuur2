package model;

public class Zeilboot extends Boot {

    // attributen



    // constructors

    public Zeilboot(String naam, int lengte) {
        super(naam, lengte);
    }

    // methoden

    @Override
    public boolean isVaarbewijsPlichtig(){
        final int GRENS_LENGTE = 15;

        if (this.getLengte() > GRENS_LENGTE) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public double berekenHuurprijs() {
        final int GRENS_LENGTE = 7;
        final double PRIJS_KORTE_BOOT = 40.0;
        final double PRIJS_LANGE_BOOT = 70.0;

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

        builderResultaat.append(super.toString().replace("Boot","Zeilboot"));
        builderResultaat.append(String.format("\n\tVaarbewijs vereist: %s%n\tHuurprijs: %.2f euro per dag\n", vaarbewijsVereist, this.berekenHuurprijs()));

        return builderResultaat.toString();
    }

    // getters en setters

}
