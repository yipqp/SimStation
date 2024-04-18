package src.flocking;
import src.mvc.*;
import src.simstation.*;

public class FlockingFactory extends SimStationFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Flocking";}
}
