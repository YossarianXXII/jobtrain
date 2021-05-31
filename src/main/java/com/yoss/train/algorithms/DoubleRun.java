package com.yoss.train.algorithms;

import com.yoss.train.train.Train;

public class DoubleRun implements CountingAlgorithm{

    private Statistics statistics = new Statistics();

    // zazni
    // chod dopredu i, vsetko zhasni
    // vrat sa i, ak je 0 zapnuta
    //      i*2
    // inak vsetky su vypnute
    // zapni 0, chod kym nenajdes zapnute

    public int count(Train t){
        int stepLimit = 1;
        t.turnOn();
        while(true) {
            for (int i = 0; i < stepLimit; i++) {
                t.next();
                this.statistics.movesCount++;
                if(t.isOn()){
                    t.turnOff();
                    this.statistics.switchCount++;
                }
            }
            for (int i = 0; i < stepLimit; i++) {
                t.previous();
                this.statistics.movesCount++;
            }
            if (t.isOn()) {
                stepLimit*=2;
            }
            else {
                break;
            }
        }
        int size = 0;
        t.turnOn();
        this.statistics.switchCount++;
        do{
            size++;
            t.next();
            this.statistics.movesCount++;
        }while (!t.isOn());

        return size;
    }


    @Override
    public Statistics getStatistics() {
        return statistics;
    }

}
