package src.simstation;

import src.mvc.Command;
import src.mvc.Model;

public class StopCommand extends Command {
    public StopCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Simulation sim = (Simulation)model;
        sim.stop();
    }
}
