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
        Utilities.inform(sim.getStats());
    }
}
