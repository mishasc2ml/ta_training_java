package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.carouselContainer;
import static com.epam.rd.autotasks.DecrementingCarousel.capacity;
import static com.epam.rd.autotasks.DecrementingCarousel.flag;

public class CarouselRun {
    private int decrease = 1;
    private int current = 0;
    public int next() {
        int res;
        while (carouselContainer[current] == 0 && !isFinished()) {
            if (current + 1 >= capacity) {
                current = 0;
                decrease++;
            } else current++;
        }
        if (!isFinished() && carouselContainer[current] > 0) {
            res = carouselContainer[current];
            if (flag) {
                carouselContainer[current]--;
            } else {
                carouselContainer[current] = carouselContainer[current] - decrease;
                if (carouselContainer[current] < 0) {
                    carouselContainer[current] = 0;
                }
            }
            if (current + 1 >= capacity) {
                decrease++;
                current = 0;
            } else current++;
        } else return -1;
        return res;
    }
    public boolean isFinished() {
        for (int element : carouselContainer) {
            if (element > 0) return false;
        }
        return true;
    }
}
