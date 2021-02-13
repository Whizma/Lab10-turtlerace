import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

    public static void main(String[] args) {
	RaceWindow w = new RaceWindow();
	int a = 0;
	ArrayList<RaceTurtle> winnerList = new ArrayList<RaceTurtle>();
	int contestants = 8;

	// skapa åtta slumpmässiga sköldpaddor och lagra dessa i en arraylist.
	// kapplöpningen ska ske i samma racewindow
	ArrayList<RaceTurtle> turtleList = new ArrayList<RaceTurtle>();

	if (turtleList.size() < contestants) {
	    for (int i = 0; i < contestants; i++) {
		Random rand = new Random();
		int randomTurtle = rand.nextInt(3);
		if (randomTurtle == 0) {
		    DizzyTurtle dT = new DizzyTurtle(w, i + 1);
		    turtleList.add(dT);
		}

		else if (randomTurtle == 1) {
		    AbsentMindedTurtle amT = new AbsentMindedTurtle(w, i + 1);
		    turtleList.add(amT);
		}

		else {
		    MoleTurtle mT = new MoleTurtle(w, i + 1);
		    turtleList.add(mT);
		}
		System.out.println(turtleList.get(i).toString());
	    }
	    for (int f = 0; f < turtleList.size(); f++) {
		while (turtleList.get(f).getX() < RaceWindow.X_END_POS) {

		    for (int i = 0; i < turtleList.size(); i++) {

			if (turtleList.get(i).getX() < RaceWindow.X_END_POS) {
			    turtleList.get(i).raceStep();
			    RaceWindow.delay(5);
			}

			int turtlePos = turtleList.get(i).getX();
			if (turtlePos >= RaceWindow.X_END_POS && a < 3) {
			    winnerList.add(turtleList.get(i));
			    turtleList.remove(i);
			    a++;

			}

		    }

		}
	    }
	    int b = 1;
	    System.out.println();
	    for (RaceTurtle t : winnerList) {
		System.out.println("På plats " + b + ": " + t.toString());
		b++;
	    }
	}
    }
}