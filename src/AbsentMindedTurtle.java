import java.util.Random;

/*AbsentMindedTurtle, som är en tankspridd sköldpadda. Graden av tankspriddhet anges i
procent när sköldpaddan skapas, och sannolikheten att en tankspridd sköldpadda skall gå
framåt bestäms av tankspriddhetsgraden. Exempel: en tankspriddhetsgrad på 34 procent
ska medföra att sköldpaddan i 34 procent av fallen glömmer att ta sitt steg. */

public class AbsentMindedTurtle extends RaceTurtle {
    private int absentness;
    private int randomness;

    public AbsentMindedTurtle(RaceWindow w, int nbr) {
	super(w, nbr);
	penDown();
	this.absentness = absentRandomizer();
    }

    public int absentRandomizer() {
	Random rand = new Random();
	int randomness = rand.nextInt(101);
	return randomness;

    }

    public int randomCompare() {
	Random rand = new Random();
	int randomCompare = rand.nextInt(101);
	return randomCompare;
    }

    /**
     * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett slumptal
     * (heltal) mellan 1 och 6.
     */

    public void raceStep() {
	randomCompare();
	if (absentness < randomCompare()) {
	    super.raceStep();
	}

    }

    /**
     * Returnerar en läsbar representation av denna AbsentMindedTurtle, på formen
     * "Nummer x" där x är sköldpaddans startnummer.
     */

    public String toString() {
	return super.toString() + " - " + getClass().getSimpleName() + " (" + absentness + "% frånvarande)";

    }
}