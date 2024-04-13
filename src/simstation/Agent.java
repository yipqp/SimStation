package src.simstation;


import java.awt.*;

public abstract class Agent implements Runnable {

    protected String name;
    protected Heading heading;
    transient protected Thread myThread;
    protected int xc;
    protected int yc;
    private boolean suspended, stopped;
    protected Simulation world;


    public Agent() {
        suspended = false;
        stopped = false;
        myThread = null;
    }

    public Agent(String name) {
        super();
        this.name = name;
    }

    public Agent(String name, Heading heading) {
        this.name = name;
        this.heading = heading;
        suspended = false;
        stopped = false;
        myThread = null;
    }

    public void setWorld(Simulation s) { world = s; }
    public String getName() { return name; }
    public synchronized String toString() {
        String result = name;
        if (stopped) result += " (stopped)";
        else if (suspended) result += " (suspended)";
        else result += " (running)";
        return result;
    }
    // thread stuff:
    public synchronized void stop() { stopped = true; }
    public synchronized void suspend() { suspended = true; }
    public synchronized void resume() { notify(); }
    // wait for me to die:
    public synchronized void join() {
        try {
            if (myThread != null) myThread.join();
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    // wait for notification if I'm not stopped and I am suspended
    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                System.out.println(name + " suspended");
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        myThread = Thread.currentThread();
        while (!stopped) {
            try {
                update();
                Thread.sleep(200);
                checkSuspended();
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(name + " stopped");
    }

    public synchronized void move(int steps) {
        Point oldPos = new Point(xc, yc);
        switch (heading) {
            case NORTH:
                for (int i = 0; i < steps; i++) {
                    if (yc < 0) {
                        yc = Simulation.SIZE - 1;
                    } else {
                        yc = yc - 1;
                    }
                }
                world.changed();
                break;
            case SOUTH:
                for (int i = 0; i < steps; i++) {
                    if (yc > Simulation.SIZE - 1) {
                        yc = 0;
                    } else {
                        yc = yc + 1;
                    }
                }
                world.changed();
                break;
            case EAST:
                for (int i = 0; i < steps; i++) {
                    if (xc < 0) {
                        xc = Simulation.SIZE - 1;
                    } else {
                        xc = xc - 1;
                    }
                }
                world.changed();
                break;
            case WEST:
                for (int i = 0; i < steps; i++) {
                    if (xc > Simulation.SIZE - 1) {
                        xc = 0;
                    } else {
                        xc = xc + 1;
                    }
                }
                world.changed();
                break;
        }
    }

    public abstract void update();
}