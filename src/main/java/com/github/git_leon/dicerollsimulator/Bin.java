package com.github.git_leon.dicerollsimulator;

public class Bin {
    private final Integer faceValueToTrack;
    private Integer numberOfOccurrences = 0;

    public Bin(Integer faceValueToTrack) {
        this(faceValueToTrack,0);
    }

    Bin(Integer faceValueToTrack, Integer numberOfOccurrences) {
        this.faceValueToTrack = faceValueToTrack;
        this.numberOfOccurrences = numberOfOccurrences;
    }

    public Integer getFaceValueToTrack() {
        return faceValueToTrack;
    }

    public Integer getNumberOfOccurrences() {
        return numberOfOccurrences;
    }

    public void increment() {
        numberOfOccurrences++;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "faceValueToTrack=" + faceValueToTrack +
                '}';
    }
}
