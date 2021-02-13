import java.util.Random;

/* MoleTurtle, som beskriver en ”mullvadssköldpadda”, d.v.s. en tävlande sköldpadda som
då och då går under jorden (genom att lyfta pennan slumpmässigt). */

public class MoleTurtle extends RaceTurtle {

    public MoleTurtle(RaceWindow w, int nbr) {
	super(w, nbr);
	penDown();
	turnNorth();
	left(270);
	
    }

    /**
     * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett slumptal
     * (heltal) mellan 1 och 6. Slumpmässigt gräver sköldpaddan ned sig under marken
     */

    public void raceStep() {
	penDown();
	if (tunnelRandomizer() == 0) {
	    penUp();
	}
	super.raceStep();
	

    }
    
    public int tunnelRandomizer() {
	Random rand = new Random();
	int randomness = rand.nextInt(2);
	return randomness;
	
    }


    /**
     * Returnerar en läsbar representation av denna MoleTurtle, på formen "Nummer x"
     * där x är sköldpaddans startnummer.
     */

    public String toString() {
	return super.toString() + " - " + getClass().getSimpleName();
    }

}