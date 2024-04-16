package src.prisonersdilemma;

import src.mvc.*;
import src.simstation.*;

public class Prisoner extends Agent {
    protected int fitness;
    protected boolean partnerCheated;
    protected Strategy strategy;

    public Prisoner(Strategy strategy, String name) {
        super(name);
        fitness = 0;
        partnerCheated = false;
        this.strategy = strategy;
        strategy.myPrisoner = this;
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void updateFitness(int amt) {
        fitness += amt;
        strategy.updateFitness(amt);
    }

    @Override
    public synchronized void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);

        Prisoner neighbor = (Prisoner) world.getNeighbor(this, 10); // arbitrary radius

        if (neighbor == null) return;
        partnerCheated = !neighbor.cooperate();

        if (cooperate()) {
            if (neighbor.cooperate()) {
                updateFitness(3);
                neighbor.updateFitness(3);
            } else {
                neighbor.updateFitness(5);
            }
        } else {
            if (neighbor.cooperate()) {
                updateFitness(5);
            } else {
                updateFitness(1);
                neighbor.updateFitness(1);
            }
        }
    }
}
