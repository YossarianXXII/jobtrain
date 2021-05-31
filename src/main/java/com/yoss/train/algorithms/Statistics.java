package com.yoss.train.algorithms;

public class Statistics {
    public int movesCount = 0;
    public int switchCount = 0;


    @Override
    public String toString() {
        return "{" + movesCount + ", " + switchCount + '}';
    }
}
