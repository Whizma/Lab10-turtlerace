import java.util.Random;

/* DizzyTurtle, som beskriver en yr tävlingssköldpadda, som vinglar när den skall ta sig
framåt. När dessa sköldpaddor skapas ska graden av yrsel (från 1 till 5) anges, och deras
förmåga att hålla kursen skall bestämmas av yrselgraden. Du behöver inte göra någon
avancerad simulering av yrseln, men en sköldpadda med högre yrselgrad bör vingla mer
än en mindre yr sköldpadda. */

public class DizzyTurtle extends RaceTurtle {
    private int dizzyness;

    public DizzyTurtle(RaceWindow w, int nbr) {
	super(w, nbr);
	penDown();
	left(270);
	this.dizzyness = dizzynessRandomizer();

    }

    public int dizzynessRandomizer() {
	Random rand = new Random();
	int dizzyness = rand.nextInt(5) + 1;
	return dizzyness;

    }

    public int randomDirection() {
	Random rand = new Random();
	rand.nextInt(2);
	return rand.nextInt(2);

    }

    /**
     * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett slumptal
     * (heltal) mellan 1 och 6.
     */

    public void raceStep() {
	turnNorth();
	left(270);
	int dizzyDirection = 5 * dizzyness;
	if (randomDirection() == 0) {
	    left(dizzyDirection);
	    super.raceStep();
	}
	else {
	    left(-dizzyDirection);
		super.raceStep();
	}
    }

    /**
     * Returnerar en läsbar representation av denna DizzyTurtle, på formen "Nummer
     * x" där x är sköldpaddans startnummer.
     */

    public String toString() {

	return super.toString() + " - " + getClass().getSimpleName() + " (Yrsel: " + dizzyness + ")";
    }
}