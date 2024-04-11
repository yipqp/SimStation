package src.simstation;
import src.mvc.*;

import javax.swing.*;
import java.awt.*;

public class SimulationView extends View {

    public SimulationView(Simulation model) {
        super(model);
        setBackground(Color.DARK_GRAY);
    }
    @Override
    public void update() { repaint(); }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Simulation sim = (Simulation) model;
        for(Agent eachAgent : sim.agents) {
            g.setColor(Color.WHITE);
            g.fillRect(eachAgent.xc, eachAgent.yc, 10,10);
        }
    }
}
