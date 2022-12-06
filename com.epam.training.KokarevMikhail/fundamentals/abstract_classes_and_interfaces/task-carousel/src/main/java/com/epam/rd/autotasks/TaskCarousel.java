package com.epam.rd.autotasks;

public class TaskCarousel {
    private final int capacity;
    private final Task[] carouselContainer;
    private int current;
    private int executionCurrent;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        carouselContainer = new Task[capacity];
    }

    public boolean addTask(Task task) {
        if (task != null && !task.isFinished() && !isFull()) {
            while (carouselContainer[current] != null) {
                if (current + 1 >= capacity) current = 0;
                else current++;
            }
            carouselContainer[current] = task;
            if (current + 1 >= capacity) current = 0;
            else current++;
            return true;
        }
        return false;
    }

    public boolean execute() {
        if (!isEmpty()) {
            while (carouselContainer[executionCurrent] == null) {
                if (executionCurrent + 1 >= capacity) executionCurrent = 0;
                else executionCurrent++;
            }
            carouselContainer[executionCurrent].execute();
            if (carouselContainer[executionCurrent].isFinished()) carouselContainer[executionCurrent] = null;
            if (executionCurrent + 1 >= capacity) executionCurrent = 0;
            else executionCurrent++;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < capacity; i++) {
            if (carouselContainer[i] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        int counter = 0;
        for (int i = 0; i < capacity; i++) {
            if (carouselContainer[i] == null) counter++;
        }
        return counter == capacity;
    }
}
