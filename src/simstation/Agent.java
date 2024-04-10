package src.simstation;


public abstract class Agent implements Runnable {

    protected String name;
    protected Heading heading;
    protected Thread myThread;
    protected int xc;
    protected int yc;
    private boolean suspended, stopped;
    protected Simulation world;


    public Agent() {
        suspended = false;
        stopped = false;
        myThread = null;
    }

    public Agent(String name, Heading heading) {
        this.name = name;
        this.heading = heading;
        suspended = false;
        stopped = false;
        myThread = null;
    }

    public void setWorld (Simulation s) { world = s; }
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
                Thread.sleep(1000);
                checkSuspended();
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(name + " stopped");
    }

    public void move(int steps) {
        //will be overwritten upon implementation
        world.changed();
    }

    public abstract void update();
}