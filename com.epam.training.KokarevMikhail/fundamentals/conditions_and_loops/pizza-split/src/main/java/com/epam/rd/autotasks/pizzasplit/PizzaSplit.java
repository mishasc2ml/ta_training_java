package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        int numberOfPieces = scanner.nextInt();
        for (int i = 1; ; i++) {
            if (i * numberOfPieces % numberOfPeople == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
