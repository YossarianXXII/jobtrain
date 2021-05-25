package com.yoss.train;

public class SimpleRun implements CountingAlgorithm{


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
                if(t.isOn()) t.turnOff();
            }
            for (int i = 0; i < stepLimit; i++) {
                t.previous();
            }
            if (!t.isOn()) return stepLimit;
            else stepLimit++;
        }
    }
}
