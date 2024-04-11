package src.randomwalk;
import src.simstation.*;
import src.mvc.*;

public class RandomWalkSimulation extends Simulation {

    public void populate() {
        for (int i = 1; i <= 15; i++)
            addAgent(new Drunk("Agent " + i));
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }
}

