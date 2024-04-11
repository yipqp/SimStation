package src.simstation;
import src.mvc.*;

import javax.swing.*;

public class SimulationPanel extends AppPanel{
    public SimulationPanel(AppFactory factory) {
        super(factory);
        JButton button = new JButton("Start");
        controlPanel.add(button);
        button.addActionListener(this);

        button = new JButton("Suspend");
        controlPanel.add(button);
        button.addActionListener(this);

        button = new JButton("Resume");
        controlPanel.add(button);
        button.addActionListener(this);

        button = new JButton("Stop");
        controlPanel.add(button);
        button.addActionListener(this);

        button = new JButton("Stats");
        controlPanel.add(button);
        button.addActionListener(this);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new SimStationFactory());
        panel.display();
    }
}
