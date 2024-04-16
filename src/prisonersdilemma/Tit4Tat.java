package src.prisonersdilemma;

public class Tit4Tat extends Strategy {

    public static int fitness = 0;
    @Override
    public boolean cooperate() {
        return !myPrisoner.partnerCheated;
    }

    @Override
    public void updateFitness(int amt) {
        fitness += amt;
    }
}
