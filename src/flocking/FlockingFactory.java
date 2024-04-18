package src.flocking;
import src.mvc.*;
import src.simstation.*;

public class FlockingFactory extends SimStationFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Flocking";}

    @Override
    public Command makeEditCommand(Model m, String type, Object source) {
        switch(type) {
            case "Start": return new StartCommand(m);
            case "Suspend": return new SuspendCommand(m);
            case "Resume": return new ResumeCommand(m);
            case "Stop": return new StopCommand(m);
            case "Stats": return new FlockingStatsCommand(m); //new flocking stats
            default: return null;
        }
    }
}
