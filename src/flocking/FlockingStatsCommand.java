package src.flocking;

import src.mvc.Command;
import src.mvc.Model;
import src.mvc.Utilities;
import src.simstation.Agent;
import src.simstation.Simulation;

public class FlockingStatsCommand extends Command {
    public FlockingStatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Simulation sim = (Simulation)model;
        int[] agentSpeeds = new int[5];
        for (Agent a: sim.getAgents()) {
            agentSpeeds[((Bird) a).speed - 1]++;
        }
        Utilities.inform("#birds @ speed 1 = " + agentSpeeds[0] +
                "\n#birds @ speed 2 = " + agentSpeeds[1] +
                "\n#birds @ speed 3 = " + agentSpeeds[2] +
                "\n#birds @ speed 4 = " + agentSpeeds[3] +
                "\n#birds @ speed 5 = " + agentSpeeds[4]);
    }
}
