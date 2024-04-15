package src.plauge;
import src.mvc.Utilities;
import src.simstation.*;

import java.util.List;
import java.util.Random;

public class Host extends Agent{
    public boolean infected = false;
    public Host() {
        super();
        heading = Heading.random();

    }

    public Host(String name) {
        super(name);
        heading = Heading.random();
    }

    public void infect() {
        infected = true;
    }

    @Override
    public void update() {
        System.out.println("Name: " + getName() + ": (" + xc + ", " + yc + ")");
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
        if(this.infected) {
            Random rng = new Random();
            double infectionChance = rng.nextDouble(100);
            if(infectionChance < PlaugeSimulation.VIRULENCE) {
                infectionChance = rng.nextDouble(100);
                if(!(infectionChance < PlaugeSimulation.RESISTANCE)) {
                    Host potentialHost = (Host) world.getNeighbor(this, 10);
                    potentialHost.infect();
                }
            }

        }
    }
}
