package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;


public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double D = b * b - 4 * a * c;
        if (D < 0) {
            System.out.println("no roots");
        } else if (D == 0) {
            double x = -b / 2 * a;
            System.out.println((int) x);
        } else if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
    }
}