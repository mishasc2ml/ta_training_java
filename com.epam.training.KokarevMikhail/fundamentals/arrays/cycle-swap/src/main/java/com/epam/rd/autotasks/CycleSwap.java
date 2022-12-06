package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length > 0) {
            int[] res = new int[array.length];
            res[0] = array[array.length - 1];
            for (int i = 0; i < array.length - 1; i++) {
                res[i + 1] = array[i];
            }
            System.arraycopy(res, 0, array, 0, array.length);
        }
    }
    static void cycleSwap(int[] array, int shift) {
        if (array.length > 0) {
            int[] res = new int[array.length];
            for (int current = 0; current < array.length; current++) {
                if (current + shift >= array.length) {
                    res[Math.abs(array.length - (current + shift))] = array[current];
                } else {
                    res[current + shift] = array[current];
                }
            }
            System.arraycopy(res, 0, array, 0, array.length);
        }
    }
}



