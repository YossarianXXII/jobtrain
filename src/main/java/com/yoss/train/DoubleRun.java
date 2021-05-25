package com.yoss.train;

public class DoubleRun implements CountingAlgorithm{

    // 1 2 4 8 16
    // zazni
    // zapamataj ze 0 je zaznute
    // chod dopredu i, vsetko zhasni
    // vrat sa i, ak je 0 zapnuta
    //      i*2
    //

    public int count(Train t){
        int base = 0;
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
            if (t.isOn()) {

                stepLimit*=2;
            }
            else {

            };
        }
    }

}
