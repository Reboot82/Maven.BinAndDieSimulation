package com.github.git_leon.dicerollsimulator;

import java.util.Arrays;
import java.util.StringJoiner;

public class Bins {
    Bin[] binArray;

    public Bins() {
        this(2,12);
    }

    public Bins(Integer minFaceValue, Integer maxFaceValue) {
        if(maxFaceValue < minFaceValue){
            throw new NegativeArraySizeException();
        }
        binArray = new Bin[(maxFaceValue-minFaceValue)+1];
        for (int i = 0; i < binArray.length; i++) {
            binArray[i] = new Bin(minFaceValue+i);
        }
    }

    public void incrementBin(Integer faceValueToIncrement) {
        getBin(faceValueToIncrement).increment();
    }

    public Bin getBin(Integer faceValueToIncrement) {
        for (int i = 0; i < binArray.length; i++) {
             Bin bin = binArray[i];
             int faceValueSumToTrack = bin.getFaceValueToTrack();
             if(faceValueSumToTrack == faceValueToIncrement) {
                 return bin;
             }
        }
        String errorMessage = new StringJoiner("\n")
                .add("Unable to find bin with face-value [ %s ]")
                .add("Here is the list of bins we have available:")
                .add(toString())
                .toString();
        throw new RuntimeException(String.format(errorMessage, faceValueToIncrement));

    }

    @Override
    public String toString() {
        return "Bins{" +
                "binArray=" + Arrays.toString(binArray) +
                '}';
    }

    public Bin[] getBins() {
        return binArray;
    }
}
