package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    private int capacity;
    private int ticketsLimit;
    private int position;
    Ticket[] sprintTickets;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        sprintTickets = new Ticket[ticketsLimit];
    }
    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted() || ticketsLimit == 0 || capacity - userStory.getEstimate() < 0) {
            return false;
        }
        for (UserStory userStory1 : userStory.getDependencies()) {
            if (!userStory1.isCompleted()) return false;
        }
        sprintTickets[position++] = userStory;
        ticketsLimit--;
        capacity -= userStory.getEstimate();
        return true;
    }
    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted() || ticketsLimit == 0 || capacity - bugReport.getEstimate() < 0) {
            return false;
        }
        sprintTickets[position++] = bugReport;
        ticketsLimit--;
        capacity -= bugReport.getEstimate();
        return true;
    }
    public Ticket[] getTickets() {
        Ticket[] tickets = new Ticket[position];
        System.arraycopy(sprintTickets, 0, tickets, 0, position);
        return tickets;
    }
    public int getTotalEstimate() {
        int sum = 0;
        for (int i = 0; i < position; i++) {
            sum += sprintTickets[i].getEstimate();
        }
        return sum;
    }
}
