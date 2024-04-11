package src.randomwalk;
import src.mvc.*;
import src.simstation.*;
import java.awt.*;
import java.util.Iterator;

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
        System.out.println("Name: " + getName() + ": (" + xc + ", " + yc + ")");
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}

