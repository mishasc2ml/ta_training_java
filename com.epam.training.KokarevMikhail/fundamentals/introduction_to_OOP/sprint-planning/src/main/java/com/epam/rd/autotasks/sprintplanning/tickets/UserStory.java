package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {
    private final UserStory[] dependsOn;
    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = dependsOn;
    }
    @Override
    public void complete() {
        boolean flag = true;
        int counter = 0;
        for (UserStory userStory : dependsOn) {
            if (userStory.isCompleted()) {
                counter++;
            }
        }
        if (counter != dependsOn.length) {
            flag = false;
        }
        if (flag) super.complete();
    }

    public UserStory[] getDependencies() {
        return dependsOn.clone();
    }
    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
