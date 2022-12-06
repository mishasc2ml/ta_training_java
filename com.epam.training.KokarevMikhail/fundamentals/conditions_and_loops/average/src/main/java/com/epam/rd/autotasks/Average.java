package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentValue;
        int counter = 0;
        int sum = 0;
        do {
            currentValue = scanner.nextInt();
            if (currentValue != 0) {
                sum += currentValue;
                counter += 1;
            }
        } while (currentValue != 0);

        System.out.println(sum / counter);
    }
}