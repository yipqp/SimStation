package src.plauge;

import src.mvc.Command;
import src.mvc.Model;
import src.mvc.Utilities;
import src.simstation.Simulation;
import src.simstation.StatsCommand;

public class PlaugeStatsCommand extends StatsCommand {
    public PlaugeStatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Simulation sim = (PlaugeSimulation)model;
        int numOfAgents = sim.agents.size();
        int timeInSec = sim.getClock();
        Utilities.inform("#Agents = " + numOfAgents + "\nclock = " + timeInSec);
    }
}
