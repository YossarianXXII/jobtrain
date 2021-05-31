package com.yoss.train.algorithms;

import com.yoss.train.train.Train;

public interface CountingAlgorithm {
    int count(Train t);
    Statistics getStatistics();
}
