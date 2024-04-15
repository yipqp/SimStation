package src.randomwalk;
import src.mvc.*;
import src.simstation.*;

class Drunk extends Agent {

    public Drunk() {
        super();
        heading = Heading.random();
    }

    public Drunk(String name) {
        super(name);
        heading = Heading.random();
    }

    public synchronized void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}

