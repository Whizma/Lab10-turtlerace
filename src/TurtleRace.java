import java.util.ArrayList;

public class TurtleRace {

    public static void main(String[] args) {
	RaceWindow w = new RaceWindow();

	// skapa åtta sköldpaddor och lagra dessa i en arraylist.
	// kapplöpningen ska ske i samma racewindow
	ArrayList<RaceTurtle> turtleList = new ArrayList<RaceTurtle>();
	for (int i = 0; i < 8; i++) {
	    RaceTurtle rc = new RaceTurtle(w, i + 1);
	    turtleList.add(rc);

	}
	
	while (turtleList.get(0).getX() < RaceWindow.X_END_POS) {

	    for (int i = 0; i < turtleList.size(); i++) {

		turtleList.get(i).raceStep();
		RaceWindow.delay(10);

	    }

	}
    }
}