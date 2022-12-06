package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    static int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        DecrementingCarouselWithLimitedRun.actionLimit = actionLimit;
        flag = false;
    }
    @Override
    public CarouselRun run() {
        if (!runFlag) {
            runFlag = true;
            return new CarouselRun(actionLimit);
        } else return null;
    }
}
