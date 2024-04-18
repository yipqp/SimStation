package src.prisonersdilemma;

import src.mvc.Model;
import src.mvc.Utilities;
import src.simstation.StatsCommand;

public class FitnessStatsCommand extends StatsCommand {

    public FitnessStatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        double[] stats = ((PrisonersDilemmaSimulation) model).getStats();
        double avgCooperateFitness = stats[0];
        double avgRandomlyCooperateFitness = stats[1];
        double avgCheatFitness = stats[2];
        double avgTit4TatFitness = stats[3];
        Utilities.inform("Cooperate Fitness Average: " + avgCooperateFitness + "\nRandomly Cooperate Fitness Average: " + avgRandomlyCooperateFitness + "\nCheat Fitness Average: " + avgCheatFitness + "\nTit4Tat Fitness Average: " + avgTit4TatFitness);
    }
}
