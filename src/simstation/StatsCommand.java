package src.simstation;

import jdk.jshell.execution.Util;
import src.mvc.Command;
import src.mvc.Model;
import src.mvc.Utilities;

public class StatsCommand extends Command {
    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Simulation sim = (Simulation)model;
        int numOfAgents = sim.agents.size();
        int timeInSec = sim.getClock();
        Utilities.inform("#Agents = " + numOfAgents + "\nclock = " + timeInSec);
    }
}
