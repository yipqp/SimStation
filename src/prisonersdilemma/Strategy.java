package src.prisonersdilemma;

import java.io.Serializable;

public abstract class Strategy implements Serializable {
    protected Prisoner myPrisoner = null;
    public abstract boolean cooperate();

    public abstract void updateFitness(int amt);

}
