package com.epam.rd.autotasks;

import static com.epam.rd.autotasks.DecrementingCarousel.capacity;
import static com.epam.rd.autotasks.DecrementingCarousel.carouselContainer;

public class CarouselRun {
    private int current = 0;
    public int next() {
        int res = 0;
        while (carouselContainer[current] == 0 && !isFinished()) {
            if (current + 1 >= capacity) current = 0;
            else current++;
        }
        if (!isFinished()) {
            if (carouselContainer[current] > 0) {
                res = carouselContainer[current]--;
            }
            if (current + 1 >= capacity) {
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
