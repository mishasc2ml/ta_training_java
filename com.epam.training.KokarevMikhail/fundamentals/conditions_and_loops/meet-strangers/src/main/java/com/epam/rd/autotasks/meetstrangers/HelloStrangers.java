package com.epam.rd.autotasks.meetstrangers;

import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int amountOfStrangers = Integer.parseInt(console.nextLine());

        if (amountOfStrangers == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (amountOfStrangers < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
            String[] res = new String[amountOfStrangers];
            for (int i = 0; i < amountOfStrangers; i++) {
                String nextStranger = console.nextLine();
                res[i] = "Hello, " + nextStranger;
            }
            for (int i = 0; i < amountOfStrangers; i++) {
                System.out.println(res[i]);
            }
        }
    }
}
