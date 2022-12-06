package com.epam.rd.autotasks.sequence;

import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner scanner = new Scanner(System.in);
        int maxValue = Integer.MIN_VALUE;
        int currentValue;

        do {
            currentValue = scanner.nextInt();

            if (currentValue > maxValue && currentValue != 0) {
                maxValue = currentValue;
            }
        } while (currentValue != 0);

        return maxValue;
    }

    public static void main(String[] args) {

        System.out.println(max());

    }
}

