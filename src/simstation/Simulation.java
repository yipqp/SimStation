package src.simstation;

import src.mvc.Model;
import src.mvc.Utilities;

import java.util.*;

public class Simulation extends Model {
    transient private Timer timer; // timers aren't serializable
    private int clock = 0;
    protected static final int SIZE = 445; // ?? arbitrary number, figure it out later
    public List<Agent> agents;

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    public Simulation() {
        agents = new LinkedList<>();
    }
    public void start() {
        stop();
        clock = 0;
        agents.removeAll(agents);
        startTimer();
        populate();
        for (Agent a: agents) {
            Thread thread = new Thread(a);
            thread.start();
        }
    }

    public List<Agent> getAgents() {
        return agents;
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
        if(timer != null) {
            stopTimer();
        }
    }

    public Agent getNeighbor(Agent a, double radius) {
        Random ranGen = new Random();
        int randomNeighborIndex = ranGen.nextInt(agents.size());
        for (int i = 0; i < agents.size(); i++) {
            Agent neighbor = agents.get(randomNeighborIndex);

            double left = a.xc - radius;
            double right = a.xc + radius;
            double up = a.yc - radius;
            double down = a.yc + radius;

            if (neighbor != a
                    && (neighbor.xc > left || neighbor.xc > SIZE + left)
                    && (neighbor.xc < right || neighbor.xc < right % SIZE)
                    && (neighbor.yc > up || neighbor.yc > SIZE + up)
                    && (neighbor.yc < down || neighbor.yc < down % SIZE)) {
                return neighbor;
            }

            randomNeighborIndex = (randomNeighborIndex + 1) % agents.size();
        }

        return null;
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

    public String getStats() {
        int numOfAgents = agents.size();
        int timeInSec = getClock();
        return "#Agents = " + numOfAgents + "\nclock = " + timeInSec;
    }
}
