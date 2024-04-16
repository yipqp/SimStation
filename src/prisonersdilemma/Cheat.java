package src.prisonersdilemma;

public class Cheat extends Strategy {

    public static int fitness = 0;
@Override
    public boolean cooperate() {
        return false;
    }
    public void updateFitness(int amt) {
        fitness += amt;
    }
}
