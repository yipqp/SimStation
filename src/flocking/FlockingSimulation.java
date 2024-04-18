package src.flocking;

import src.simstation.*;
import src.mvc.*;;

public class FlockingSimulation extends Simulation{

    public void populate() {
        for (int i = 1; i <= 30; i++)
            addAgent(new Bird());
    }

    @Override
    public String getStats() {
        int[] agentSpeeds = new int[5];
        for (Agent a: getAgents()) {
            agentSpeeds[((Bird) a).speed - 1]++;
        }
        return ("#birds @ speed 1 = " + agentSpeeds[0] +
                "\n#birds @ speed 2 = " + agentSpeeds[1] +
                "\n#birds @ speed 3 = " + agentSpeeds[2] +
                "\n#birds @ speed 4 = " + agentSpeeds[3] +
                "\n#birds @ speed 5 = " + agentSpeeds[4]);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
