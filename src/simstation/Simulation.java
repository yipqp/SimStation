package src.simstation;

import src.mvc.Model;
import java.util.*;

public class Simulation extends Model {
    transient private Timer timer; // timers aren't serializable
    private int clock = 0;
    protected List<Agent> agents;

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

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

    public void addAgent(Agent a) {
        agents.add(a);
    }
    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }
}
