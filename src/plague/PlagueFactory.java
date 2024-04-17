package src.plague;

import src.simstation.*;
import src.mvc.*;

public class PlagueFactory extends SimStationFactory {
    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague";}
    public View makeView(Model m) {
        return new PlagueView((PlagueSimulation) m);
    }
    @Override
    public Command makeEditCommand(Model m, String type, Object source) {
        switch(type) {
            case "Start": return new StartCommand(m);
            case "Suspend": return new SuspendCommand(m);
            case "Resume": return new ResumeCommand(m);
            case "Stop": return new StopCommand(m);
            case "Stats": return new PlagueStatsCommand(m);
            default: return null;
        }
    }
}
