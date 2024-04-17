package src.plague;

import src.simstation.Agent;
import src.simstation.SimulationView;

import java.awt.*;

public class PlagueView extends SimulationView {

    public PlagueView(PlagueSimulation model) {
        super(model);
        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        PlagueSimulation sim = (PlagueSimulation) model;
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
