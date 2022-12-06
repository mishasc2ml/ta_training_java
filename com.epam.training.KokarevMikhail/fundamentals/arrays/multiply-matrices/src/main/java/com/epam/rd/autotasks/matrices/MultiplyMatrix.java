package com.epam.rd.autotasks.matrices;

import java.util.Arrays;
public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int[][] newMatrix = new int[matrix1.length][matrix2[0].length];
        for (int row = 0; row < matrix1.length; row++) {
            for (int column = 0; column < matrix2[0].length; column++) {
                for (int i = 0; i < matrix1[0].length; i++) {
                    newMatrix[row][column] += matrix1[row][i] * matrix2[i][column];
                }
            }
        }
        return newMatrix;
    }
    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567}};

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6}};

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
