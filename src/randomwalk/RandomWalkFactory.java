package src.randomwalk;

import src.mvc.*;
import src.simstation.*;

class RandomWalkFactory extends SimStationFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}
