package com.epam.rd.autotasks;

import java.util.Arrays;
class Spiral {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiral(2, 2)));
    }

    static int[][] spiral(int rows, int columns) {
        int[][] newMatrix = new int[rows][columns];
        int startRowIndex = 0;
        int startColumnIndex = 0;
        int counter = 1;

        while (startColumnIndex < columns && startRowIndex < rows) {
            for (int i = startColumnIndex; i < columns; i++) {
                newMatrix[startRowIndex][i] = counter++;
            }
            startRowIndex++;

            for (int i = startRowIndex; i < rows; i++) {
                newMatrix[i][columns - 1] = counter++;
            }
            columns--;

            if (startRowIndex < rows) {
                for (int i = columns - 1; i >= startColumnIndex; i--) {
                    newMatrix[rows - 1][i] = counter++;
                }
            }
            rows--;

            for (int i = rows - 1; i >= startRowIndex; i--) {
                newMatrix[i][startColumnIndex] = counter++;
            }
            startColumnIndex++;
        }
        return newMatrix;
    }
}



