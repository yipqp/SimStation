package src.flocking;
import src.mvc.*;
import src.simstation.*;

public class Bird extends Agent {

    protected int speed;
    public Bird() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }

    public Bird(String name) {
        super(name);
        xc = Utilities.rng.nextInt(445);
        yc = Utilities.rng.nextInt(445);
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }

    public synchronized void update() {
        Agent n = this.world.getNeighbor(this, 10);
        if (n != null) {
            this.heading = n.getHeading();
            this.speed = ((Bird) n).speed;
        }
        move(speed);
    }
}
