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
        double avgCooperateFitness = Cooperate.fitness / 10.0;
        double avgRandomlyCooperateFitness = RandomlyCooperate.fitness / 10.0;
        double avgCheatFitness = Cheat.fitness / 10.0;
        double avgTit4TatFitness = Tit4Tat.fitness / 10.0;
        Utilities.inform("Cooperate Fitness Average: " + avgCooperateFitness + "\nRandomly Cooperate Fitness Average: " + avgRandomlyCooperateFitness + "\nCheat Fitness Average: " + avgCheatFitness + "\nTit4Tat Fitness Average: " + avgTit4TatFitness);
    }
}
