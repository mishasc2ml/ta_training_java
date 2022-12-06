package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int billTotalAmount = console.nextInt();
        int numberOfFriends = console.nextInt();
        int partToPay;

        if (numberOfFriends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else if (billTotalAmount < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else {
            partToPay = (billTotalAmount + billTotalAmount / 100 * 10) / numberOfFriends;
            System.out.println(partToPay);
        }
    }
}
