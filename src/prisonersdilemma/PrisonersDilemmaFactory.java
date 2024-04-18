package src.prisonersdilemma;

import src.mvc.Command;
import src.mvc.Model;
import src.simstation.*;

public class PrisonersDilemmaFactory extends SimStationFactory {
    public Model makeModel() { return new PrisonersDilemmaSimulation(); }
    public String getTitle() { return "Prisoner's Dilemma";}
    @Override
    public Command makeEditCommand(Model m, String type, Object source) {
        switch(type) {
            case "Start": return new StartCommand(m);
            case "Suspend": return new SuspendCommand(m);
            case "Resume": return new ResumeCommand(m);
            case "Stop": return new StopCommand(m);
            case "Stats": return new FitnessStatsCommand(m);
            default: return null;
        }
    }
}

