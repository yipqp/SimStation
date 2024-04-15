package src.plauge;

import src.simstation.Agent;
import src.simstation.Simulation;
import src.simstation.SimulationView;

import java.awt.*;

public class PlaugeView extends SimulationView {

    public PlaugeView(PlaugeSimulation model) {
        super(model);
        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        PlaugeSimulation sim = (PlaugeSimulation) model;
        for(Agent eachAgent : sim.agents) {
            if(((Host)eachAgent).infected) {
                g.setColor(Color.RED);
            }
            else {
                g.setColor(Color.GREEN);
            }
            g.fillOval(eachAgent.xc, eachAgent.yc, 10,10);
        }
    }
}
