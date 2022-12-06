package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel {
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }
    @Override
    public CarouselRun run() {
        if (!runFlag) {
            runFlag = true;
            flag = false;
            return new CarouselRun();
        } else return null;
    }
}

