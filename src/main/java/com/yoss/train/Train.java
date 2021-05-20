package com.yoss.train;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Train implements TrainActions{

    private int size = 0;

    private final List<Wagon> wagons = new ArrayList<>();
    private int current = 0;

    public Train(int size) {
        this.size = size;
        generate();
    }

    private void generate() {
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            wagons.add(new Wagon(i, r.nextBoolean()));
        }
        current = r.nextInt(size)+1;
    }

    private Wagon getCurrentWagon(){
        return wagons.get(current);
    }

    @Override
    public boolean checkSize(int calculatedSize) {
        return calculatedSize==this.size;
    }

    @Override
    public boolean isOn() {
        return getCurrentWagon().light;
    }

    @Override
    public void turnOff() {
        getCurrentWagon().light = false;
    }

    @Override
    public void turnOn() {
        getCurrentWagon().light = true;
    }

    @Override
    public void next() {
        if(current+1 > size) current=1;
        else current +=1;
    }

    @Override
    public void previous() {
        if(current-1 == 0) current=size-1;
        else current -=1;
    }

    public class Wagon {
        int index;
        boolean light;

        public Wagon(int index, boolean light) {
            this.index = index;
            this.light = light;
        }


    }
}
