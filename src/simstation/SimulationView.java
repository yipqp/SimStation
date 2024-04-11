package src.simstation;
import src.mvc.*;

import javax.swing.*;
import java.awt.*;

public class SimulationView extends View{

    int x;
    int y;
    public SimulationView(Simulation model) {
        super(model);
        JPanel simulationArea = new JPanel();
        setBackground(Color.DARK_GRAY);
        for(Agent eachAgent : model.agents) {
            x = eachAgent.xc;
            y = eachAgent.yc;
            simulationArea.paint(null);
        }
    }
    @Override
    public void update() {
        repaint();
    }


    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(x, y, 10, 10);
    }
}
