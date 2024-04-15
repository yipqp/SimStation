package src.plauge;

import src.mvc.*;
import src.simstation.*;

public class PlaugeSimulation extends Simulation {
    public static int VIRULENCE = 50;
    public static int RESISTANCE = 2;

    @Override
    public void populate() {
        for(int i = 0; i < 50; i++) {
            addAgent(new Host("Host " + i));
        }
    }

    public static void setRESISTANCE(int RESISTANCE) {
        PlaugeSimulation.RESISTANCE = RESISTANCE;
    }

    public static void setVIRULENCE(int VIRULENCE) {
        PlaugeSimulation.VIRULENCE = VIRULENCE;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlaugeFactory());
        panel.display();
    }
}
