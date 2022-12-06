package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.*;
import static com.epam.rd.autotasks.DecrementingCarouselWithLimitedRun.actionLimit;

public class CarouselRun {
    private int current = 0;

    public CarouselRun() {
    }

    public CarouselRun(int actionLimit) {
        DecrementingCarouselWithLimitedRun.actionLimit = actionLimit;
    }

    public int next() {
        int res = 0;
        while (carouselContainer[current] == 0 && !isFinished()) {
            if (current + 1 >= capacity) {
                current = 0;
            } else current++;
        }
        if (flag) {
            if (!isFinished()) {
                if (carouselContainer[current] > 0) {
                    res = carouselContainer[current]--;
                }
                if (current + 1 >= capacity) {
                    current = 0;
                } else current++;
            } else return -1;

        } else {
            if (actionLimit > 0 && !isFinished()) {
                if (carouselContainer[current] > 0) {
                    res = carouselContainer[current]--;
                    actionLimit--;
                }
                if (current + 1 >= capacity) {
                    current = 0;
                } else current++;
            } else return -1;
        }
        return res;
    }
    public boolean isFinished() {
        if (actionLimit == 0 && !flag) {
            return true;
        }
        for (int element : carouselContainer) {
            if (element > 0) return false;
        }
        return true;
    }
}