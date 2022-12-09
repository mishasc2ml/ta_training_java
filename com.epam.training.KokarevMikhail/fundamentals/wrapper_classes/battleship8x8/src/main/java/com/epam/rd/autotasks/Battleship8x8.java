package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        String bShots = String.format("%64s", Long.toBinaryString(shots)).replaceAll(" ", "0");
        String bShips = String.format("%64s", Long.toBinaryString(ships)).replaceAll(" ", "0");
        int columnIndex = shot.charAt(0) - 65;
        int rowIndex = Integer.parseInt(shot.substring(1, 2));
        char[] bShotsArray = bShots.toCharArray();
        bShotsArray[columnIndex + --rowIndex * 8] = '1';
        bShots = new String(bShotsArray);
        shots = new BigInteger(bShots, 2).longValue();
        return bShips.charAt(columnIndex + rowIndex * 8) == '1';
    }

    public String state() {
        String bShots = String.format("%64s", Long.toBinaryString(shots)).replaceAll(" ", "0");
        String bShips = String.format("%64s", Long.toBinaryString(ships)).replaceAll(" ", "0");
        StringBuilder defaultState = new StringBuilder(bShips);
        StringBuilder runningState = new StringBuilder(bShots);
        int counter = 0;
        char empty = '.';
        char miss = '×';
        char ship = '☐';
        char hit = '☒';
        if (shots == 0L) {
            for (int i = 0; i < bShips.length(); i++) {
                if (bShips.charAt(i) == '1') {
                    defaultState.setCharAt(i, ship);
                }
                if (bShips.charAt(i) == '0') {
                    defaultState.setCharAt(i, empty);
                }
            }
            return defaultState.toString();

        } else {
            for (int i = 0; i < bShots.length(); i++) {
                if (bShips.charAt(i) == '1' && bShots.charAt(i) == '0') {
                    runningState.setCharAt(counter++, ship);
                }
                if (bShips.charAt(i) == '0' && bShots.charAt(i) == '1') {
                    runningState.setCharAt(counter++, miss);
                }
                if (bShips.charAt(i) == '1' && bShots.charAt(i) == '1') {
                    runningState.setCharAt(counter++, hit);
                }
                if (bShips.charAt(i) == '0' && bShots.charAt(i) == '0') {
                    runningState.setCharAt(counter++, empty);
                }
                if ((i + 1) % 8 == 0) {
                    runningState.insert(counter++, '\n');
                }
            }
            return runningState.toString();
        }
    }
}
