package src.plague;

import src.simstation.*;
import src.mvc.*;

public class PlagueFactory extends SimStationFactory {
    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague";}
    public View makeView(Model m) {
        return new PlagueView((PlagueSimulation) m);
    }
}
