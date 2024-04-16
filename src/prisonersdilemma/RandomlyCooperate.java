package src.prisonersdilemma;

public class RandomlyCooperate extends Strategy {

    static int fitness = 0;
    @Override
    public boolean cooperate() {
        return Math.random() < 0.5;
    }


    @Override
    public void updateFitness(int amt) {
        fitness += amt;
    }
}
