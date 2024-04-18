package src.plague;
import src.mvc.Utilities;
import src.simstation.*;

import java.util.Random;

public class Host extends Agent{
    public boolean infected = false;
    public Host() {
        super();
        heading = Heading.random();
        xc = Utilities.rng.nextInt(445);
        yc = Utilities.rng.nextInt(445);
    }

    public Host(String name) {
        super(name);
        heading = Heading.random();
        xc = Utilities.rng.nextInt(445);
        yc = Utilities.rng.nextInt(445);
    }

    public Host(String name, Boolean infected) {
        super(name);
        heading = Heading.random();
        this.infected = infected;
        xc = Utilities.rng.nextInt(445);
        yc = Utilities.rng.nextInt(445);
    }

    public void infect() {
        infected = true;
    }

    @Override
    public synchronized void update() {
        System.out.println("Name: " + getName() + ": (" + xc + ", " + yc + ")");
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
        Random rng = new Random();
        double infectionChance = rng.nextDouble(100);
        if (infectionChance < PlagueSimulation.VIRULENCE) {
            infectionChance = rng.nextDouble(100);
            if (!(infectionChance < PlagueSimulation.RESISTANCE)) {
                Host potentialHost = (Host) world.getNeighbor(this, 10);
                if (potentialHost != null) {
                    potentialHost.infect();
                }
            }
        }
    }
}
