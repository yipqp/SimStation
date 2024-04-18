package src.prisonersdilemma;

public class Cooperate extends Strategy {

    protected static int fitness = 0;
    @Override
    public boolean cooperate() {
        return true;
    }

    @Override
    public void updateFitness(int amt) {
        fitness += amt;
    }
}
