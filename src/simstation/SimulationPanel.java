package src.simstation;
import src.mvc.*;
import src.randomwalk.RandomWalkFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;

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

    @Override
    public void actionPerformed(ActionEvent e) { //had to copy and paste whole method to edit "open" switch case
        String cmmd = e.getActionCommand();
        try {
            String[] editCommands = appfactory.getEditCommands();
            for (String c: editCommands) {
                if (cmmd.equals(c)) {
                    appfactory.makeEditCommand(model, cmmd, e.getSource()).execute();
                    return;
                }
            }

            switch (cmmd) {
                case "Save": {
                    Utilities.save(model, model.getUnsavedChanges());
                    break;
                }

                case "Open": { //Override Open Button to properly import simulations
                    if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                        Model newModel = Utilities.open(model);
                        if (newModel != null) setModel(newModel);
                    }
                    Simulation s = (Simulation) model;
                    for (Agent a: s.agents) {
                        a.suspended = false;
                        a.stopped = false;
                    }
                    break;
                }

                case "New": {
                    Utilities.saveChanges(model);
                    setModel(appfactory.makeModel());
                    // needed cuz setModel sets to true:
                    model.setUnsavedChanges(false);
                    break;
                }

                case "Quit": {
                    Utilities.saveChanges(model);
                    System.exit(0);
                    break;
                }

                case "About": {
                    Utilities.inform(appfactory.about());
                    break;
                }

                case "Help": {
                    Utilities.inform(appfactory.getHelp());
                    break;
                }

                default: {
                    throw new Exception("Unrecognized command: " + cmmd);
                }
            }

        } catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }
}
