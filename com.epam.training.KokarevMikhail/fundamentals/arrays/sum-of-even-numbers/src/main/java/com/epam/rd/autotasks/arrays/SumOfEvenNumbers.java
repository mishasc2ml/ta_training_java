package com.epam.rd.autotasks.arrays;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }
    public static int sum(int[] array) {
        if (array != null) {
            int sum = 0;
            for (int i : array) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
            return sum;
        }
        return 0;
    }
}