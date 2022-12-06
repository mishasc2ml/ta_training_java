package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
        int h = console.nextInt();
        int numberOfDays = 0;
        if (h <= a) {
            System.out.println(1);
        } else if (a <= b) {
            System.out.println("Impossible");
        } else {
            while (h >= a) {
                h = h - a + b;
                numberOfDays += 1;
            }
            System.out.println(numberOfDays);
        }
    }
}
