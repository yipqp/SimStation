package src.plauge;

import src.randomwalk.RandomWalkSimulation;
import src.simstation.*;
import src.mvc.*;

public class PlaugeFactory extends SimStationFactory {
    public Model makeModel() { return new PlaugeSimulation(); }
    public String getTitle() { return "Plague";}
    public View makeView(Model m) {
        return new PlaugeView((PlaugeSimulation) m);
    }
    @Override
    public Command makeEditCommand(Model m, String type, Object source) {
        switch(type) {
            case "Start": return new StartCommand(m);
            case "Suspend": return new SuspendCommand(m);
            case "Resume": return new ResumeCommand(m);
            case "Stop": return new StopCommand(m);
            case "Stats": return new PlaugeStatsCommand(m);
            default: return null;
        }
    }
}
