package com.yoss.train;

public class Statistics {
    public int movesCount = 0;
    public int switchCount = 0;


    @Override
    public String toString() {
        return "{" + movesCount + ", " + switchCount + '}';
    }
}
