package src.plague;

import src.mvc.Model;
import src.mvc.Utilities;
import src.simstation.StatsCommand;

public class PlagueStatsCommand extends StatsCommand {
    public PlagueStatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        PlagueSimulation sim = (PlagueSimulation)model;
        int numOfAgents = sim.agents.size();
        int timeInSec = sim.getClock();
        Utilities.inform("#Agents = " + numOfAgents + "\nclock = " + timeInSec + "\n% infected = " + sim.getPercentInfected());
    }
}
