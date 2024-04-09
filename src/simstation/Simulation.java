package src.simstation;

import src.mvc.Model;

import java.util.LinkedList;
import java.util.List;

public class Simulation extends Model {
    private int clock = 0;
    protected List<Agent> agents;

    public Simulation() {
        agents = new LinkedList<>();
    }
    public void start() {
        populate();
        for (Agent a: agents) {
            Thread thread = new Thread(a);
            thread.start();
        }
        for (Agent a: agents) {
            a.join();
        }
    }

    public void suspend() { for (Agent a: agents) { a.suspend(); }}

    public void resume() { for (Agent a: agents) { a.resume(); }}

    public void stop() { for (Agent a: agents) { a.stop(); }}

    public Agent getNeighbor(Agent a, double radius) {
        return null; //will be overwritten on implementation
    }

    public void populate() {
        //will be overwritten on implementation
    }
}
