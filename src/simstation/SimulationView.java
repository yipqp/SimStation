package src.simstation;
import src.mvc.*;

import javax.swing.*;
import java.awt.*;

public class SimulationView extends View{

    int x;
    int y;
    JPanel simulationArea;
    public SimulationView(Simulation model) {
        super(model);
        simulationArea = new JPanel();
        setBackground(Color.DARK_GRAY);
        for(Agent eachAgent : model.agents) {
            x = eachAgent.xc;
            y = eachAgent.yc;
            simulationArea.paint(null);
        }
    }
    @Override
    public void update() {
        Simulation sim = (Simulation) model;
        for(Agent eachAgent : sim.agents) {
            x = eachAgent.xc;
            y = eachAgent.yc;
            simulationArea.paint(null);
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(x, y, 10, 1);
    }
}
