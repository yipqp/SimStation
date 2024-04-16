package src.prisonersdilemma;

public abstract class Strategy {
    protected Prisoner myPrisoner = null;
    public abstract boolean cooperate();

    public abstract void updateFitness(int amt);

}
