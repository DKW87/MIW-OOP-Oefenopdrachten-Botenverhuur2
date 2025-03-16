package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Verhuur {

    // attributen

    private Klant klant;
    private List<Boot> boten;
    private LocalDate startDatum;
    private int aantalDagen;

    // constructors

    public Verhuur(Klant klant, LocalDate datum, int aantalDagen) {
        this.klant = klant;
        this.startDatum = datum;
        this.aantalDagen = aantalDagen;
        this.boten = new ArrayList<>();
    }

    // methoden

    public void voegBootToe (Boot boot) {

        if(magVerhuurd(boot)){
            this.boten.add(boot);
        }
        else {
            System.out.printf("%sMag niet verhuurd worden aan %s! Het toevoegen is mislukt.\n", boot, klant);
        }
    }

    public double berekenHuurBedrag() {
        double huurprijs = 0;

        for (Boot boot : boten) {
            huurprijs += (aantalDagen * boot.berekenHuurprijs());
        }

        return huurprijs;
    }

    private boolean magVerhuurd(Boot boot) {
        boolean magVerhuurdWorden = false;

        if (boot.isVaarbewijsPlichtig()) {
            if (klant.isVaarVaardig()){
                magVerhuurdWorden = true;
            }
        }
        else if (!boot.isVaarbewijsPlichtig()) {
            magVerhuurdWorden = true;
        }

        return magVerhuurdWorden;
    }

    @Override
    public String toString() {
        StringBuilder builderResultaat = new StringBuilder();

        Collections.sort(boten);
        if (boten.isEmpty()) {
            builderResultaat.append(String.format("De verhuur aan %s op %s is mislukt, geen boten toegevoegd.", klant, startDatum));
        }
        else {
            builderResultaat.append(String.format("De verhuur aan %s van %s tot %s kost %.2f euro: %n", klant, startDatum, startDatum.plusDays(aantalDagen),berekenHuurBedrag()));
            for (Boot boot : boten) {
                builderResultaat.append(boot);
            }
        }

        return builderResultaat.toString();
    }

    // getters en setters

}
