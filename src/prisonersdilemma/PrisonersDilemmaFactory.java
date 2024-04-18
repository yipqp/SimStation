package src.prisonersdilemma;

import src.mvc.Command;
import src.mvc.Model;
import src.simstation.*;

public class PrisonersDilemmaFactory extends SimStationFactory {
    public Model makeModel() { return new PrisonersDilemmaSimulation(); }
    public String getTitle() { return "Prisoner's Dilemma";}
}

