package src.plague;

import src.mvc.*;
import src.simstation.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50;
    public static int RESISTANCE = 2;
    public static int STARTINFECTED = 1; //percentage of hosts that start infected
    public static int numOfHosts = 50;

    @Override
    public void populate() {
        double numOfStartInfected = (STARTINFECTED/100.0) * numOfHosts;
        for(int i = 0; i < numOfHosts; i++) {
            addAgent(new Host("Host " + i, false));
        }
        for(int i = 0; i < numOfStartInfected; i++) {
            Host toStartInfected = (Host) agents.get(i);
            toStartInfected.infect();
        }
    }

    public static void setRESISTANCE(int RESISTANCE) {
        PlagueSimulation.RESISTANCE = RESISTANCE;
    }

    public static void setVIRULENCE(int VIRULENCE) {
        PlagueSimulation.VIRULENCE = VIRULENCE;
    }

    public static void setSTARTINFECTED(int STARTINFECTED) {
        PlagueSimulation.STARTINFECTED = STARTINFECTED;
    }

    public double getPercentInfected() {
        int numInfected = 0;
        for(int i = 0; i < agents.size(); i++) {
            Host currAgent = (Host)agents.get(i);
            if(currAgent.infected) {
                numInfected++;
            }
        }
        return 100 * (double) numInfected / numOfHosts;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}
