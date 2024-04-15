package src.flocking;

import src.simstation.*;
import src.mvc.*;;

public class FlockingSimulation extends Simulation{

    public void populate() {
        for (int i = 1; i <= 30; i++)
            addAgent(new Bird());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
