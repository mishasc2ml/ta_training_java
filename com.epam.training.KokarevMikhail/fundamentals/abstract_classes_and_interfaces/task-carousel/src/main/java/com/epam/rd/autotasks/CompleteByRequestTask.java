package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean finishedFlag;
    private boolean completed;

    @Override
    public void execute() {
        if (completed) finishedFlag = true;
    }

    @Override
    public boolean isFinished() {
        return finishedFlag;
    }

    public void complete() {
        completed = true;
    }
}
