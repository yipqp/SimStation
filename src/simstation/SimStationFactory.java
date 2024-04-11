package src.simstation;
import src.mvc.*;
public class SimStationFactory implements AppFactory {

    @Override
    public Model makeModel() {
        return new Simulation();
    }

    @Override
    public View makeView(Model m) {
        return new SimulationView((Simulation)m);
    }

    @Override
    public String getTitle() {
        return "SimStation";
    }

    @Override
    public String[] getHelp() {
        return new String[0];
    }

    @Override
    public String about() {
        return "This program simulates various phenomenon such as flocking, plague spreading, and the Prisoner's Dilemma.";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model m, String type, Object source) {
        switch(type) {
            case "Start": return new StartCommand(m);
            case "Suspend": return new SuspendCommand(m);
            case "Resume": return new ResumeCommand(m);
            case "Stop": return new StopCommand(m);
            case "Stats": return new StatsCommand(m);
            default: return null;
        }
    }
}
