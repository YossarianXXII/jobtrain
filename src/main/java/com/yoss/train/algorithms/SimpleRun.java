package com.yoss.train.algorithms;

import com.yoss.train.train.Train;

public class SimpleRun implements CountingAlgorithm{

    private Statistics statistics = new Statistics();
    // zazni
    // zapamataj ze 0 je zaznute
    // chod dopredu i, vsetko zhasni
    // vrat sa i, ak je 0 zhasnuta, i je dlzka vlaku
    // inak zvys i

    public int count(Train t){
        int stepLimit = 1;
        t.turnOn();
        while(true) {

            for (int i = 0; i < stepLimit; i++) {
                t.next();
                this.statistics.movesCount++;
                if(t.isOn()) {
                    t.turnOff();
                    this.statistics.switchCount++;
                }
            }
            for (int i = 0; i < stepLimit; i++) {
                t.previous();
                this.statistics.movesCount++;
            }
            if (!t.isOn()) return stepLimit;
            else stepLimit++;
        }
    }

    @Override
    public Statistics getStatistics() {
        return statistics;
    }
}
