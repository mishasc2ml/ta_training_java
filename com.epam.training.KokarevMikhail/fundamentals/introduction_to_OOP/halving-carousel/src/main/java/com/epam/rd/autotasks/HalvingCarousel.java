package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
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
