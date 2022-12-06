package com.epam.rd.autotasks;

public class DecrementingCarousel {
    static int capacity;
    static int[] carouselContainer;
    private int counter;
    boolean runFlag;
    static boolean flag; // check if DecrementingCarouselWithLimitedRun or DecrementingCarousel is for run

    public DecrementingCarousel(int capacity) {
        DecrementingCarousel.capacity = capacity;
        carouselContainer = new int[capacity];
        flag = true;
    }
    public boolean addElement(int element) {
        if (counter < capacity && element > 0 && !runFlag) {
            carouselContainer[counter] = element;
            counter++;
            return true;
        }
        return false;
    }
    public CarouselRun run() {
        if (!runFlag) {
            runFlag = true;
            return new CarouselRun();
        } else return null;
    }
}
