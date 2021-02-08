import java.util.ArrayList;

public class TurtleRace {

    public static void main(String[] args) {
	RaceWindow w = new RaceWindow();
	int a = 0;
	ArrayList<RaceTurtle> winnerList = new ArrayList<RaceTurtle>();

	// skapa åtta sköldpaddor och lagra dessa i en arraylist.
	// kapplöpningen ska ske i samma racewindow
	ArrayList<RaceTurtle> turtleList = new ArrayList<RaceTurtle>();
	for (int i = 0; i < 8; i++) {
	    RaceTurtle rc = new RaceTurtle(w, i + 1);
	    turtleList.add(rc);

	}
	for (int f = 0; f < turtleList.size(); f++) {
	    while (turtleList.get(f).getX() < RaceWindow.X_END_POS) {

		for (int i = 0; i < turtleList.size(); i++) {

		    turtleList.get(i).raceStep();
		    RaceWindow.delay(5);
		    int turtlePos = turtleList.get(i).getX();
		    if (turtlePos > RaceWindow.X_END_POS && a <3) {
			winnerList.add(turtleList.get(i));
			turtleList.remove(i);
			a++;
		    }

		}

	    }

	    }
	    int b = 1;
	    for (RaceTurtle t : winnerList) {
		System.out.println("På plats " + b + ": " + t.toString());
		b++;
	}
    }
}