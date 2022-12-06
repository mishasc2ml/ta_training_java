package com.epam.rd.autotasks;

public class CountDownTask implements Task {
    private int countDownValue;

    public CountDownTask(int value) {
        this.countDownValue = Math.max(value, 0);
    }

    public int getValue() {
        return countDownValue;
    }

    @Override
    public void execute() {
        if (!isFinished()) countDownValue--;
    }

    @Override
    public boolean isFinished() {
        return countDownValue <= 0;
    }
}
