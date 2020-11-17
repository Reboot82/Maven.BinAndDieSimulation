package com.github.git_leon.dicerollsimulator;

public class Simulation {
    private final Dice dice;
    private final Bins bins;
    private final Integer numberOfTosses;

    public Simulation(Integer numberOfDie, Integer numberOfTosses) {
        this.dice = new Dice(numberOfDie);
        this.bins = new Bins(dice.getRollMin(), dice.getRollMax());
        this.numberOfTosses = numberOfTosses;
    }

    public void run() {
        for (int i = 0; i < numberOfTosses; i++) {
             int faceValueToTrack = dice.rollAndSum();
             bins.getBin(faceValueToTrack).increment();

        }
    }

    public Double getPercentageOfOccurrences(Integer faceValueToCheck) {
        return bins.getBin(faceValueToCheck).getNumberOfOccurrences() / numberOfTosses.doubleValue();
    }

    @Override
    public String toString() {
        return null;
    }

    public Bins getBins() {
        return bins;
    }
}
