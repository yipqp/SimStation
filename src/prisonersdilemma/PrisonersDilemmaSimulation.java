package src.prisonersdilemma;

import src.mvc.AppPanel;
import src.simstation.Simulation;
import src.simstation.SimulationPanel;

public class PrisonersDilemmaSimulation extends Simulation {
    public void populate() {
        for (int i = 0; i < 40; i++) {
            if (i % 4 == 1) {
                Prisoner prisoner = new Prisoner(new Cooperate(), "Prisoner " + i);
                addAgent(prisoner);
            } else if (i % 4 == 2) {
                Prisoner prisoner = new Prisoner(new RandomlyCooperate(), "Prisoner " + i);
                addAgent(prisoner);
            } else if (i % 4 == 3) {
                Prisoner prisoner = new Prisoner(new Cheat(), "Prisoner " + i);
                addAgent(prisoner);
            } else {
                Prisoner prisoner = new Prisoner(new Tit4Tat(), "Prisoner " + i);
                addAgent(prisoner);
            }
        }
    }

    @Override
    public String getStats() {
        return  "Cooperate Fitness Average: " + Cooperate.fitness / 10.0 +
                "\nRandomly Cooperate Fitness Average: " + RandomlyCooperate.fitness / 10.0 +
                "\nCheat Fitness Average: " + Cheat.fitness / 10.0 +
                "\nTit4Tat Fitness Average: " +  Tit4Tat.fitness / 10.0;
    }

    public void start() {
        super.start();
        Cheat.fitness = 0;
        Cooperate.fitness = 0;
        RandomlyCooperate.fitness = 0;
        Tit4Tat.fitness = 0;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonersDilemmaFactory());
        panel.display();
    }
}
