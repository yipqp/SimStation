package src.simstation;

import src.mvc.Model;
import java.util.*;

public class Simulation extends Model {
    transient private Timer timer; // timers aren't serializable
    private int clock = 0;
    protected static final int SIZE = 445; // ?? arbitrary number, figure it out later
    protected List<Agent> agents;

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }
    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public Simulation() {
        agents = new LinkedList<>();
    }
    public void start() {
        clock = 0;
        agents.removeAll(agents);
        startTimer();
        populate();
        for (Agent a: agents) {
            Thread thread = new Thread(a);
            thread.start();
        }
    }

    public void suspend() { for (Agent a: agents) { a.suspend(); }}

    public void resume() {
        if (timer == null) { //this accounts for importing new simulations
            startTimer();
            for (Agent a: agents) {
                Thread thread = new Thread(a);
                thread.start();
            }
        } else {
            for (Agent a: agents) {
                a.resume();
            }
        }
    }

    public void stop() {
        for (Agent a: agents) {
            a.stop();
        }
        stopTimer();
    }

    public Agent getNeighbor(Agent a, double radius) {
        Random ranGen = new Random();
        int randomNeighborIndex = ranGen.nextInt(agents.size());
        Agent neighbor = null;
        int numVisitedAgents = 0;
        for(int i = randomNeighborIndex; i < agents.size(); i++) {
            numVisitedAgents++;
            if(numVisitedAgents == agents.size()) {
                return neighbor; //no agent found
            }
            if((agents.get(i) != a) && (agents.get(i).xc > a.xc - radius && agents.get(i).xc < a.xc + radius) && (agents.get(i).yc > a.yc - radius && agents.get(i).yc < a.yc + radius)) {
                neighbor = agents.get(i); //neighbor found
                return neighbor;
            }
            if (i == agents.size() - 1) {
                i = 0; //loop back around
            }
        }
        return neighbor;
    }

    public void populate() {
        //will be overwritten on implementation
    }

    public void addAgent(Agent a) {
        agents.add(a);
        a.setWorld(this);
    }
    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }

    public int getClock() {
        return clock;
    }
}
