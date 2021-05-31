package com.yoss.train.train;


public interface TrainActions {
    boolean checkSize(int calculatedSize);
    boolean isOn();
    void turnOff();
    void turnOn();

    void next();
    void previous();
}
