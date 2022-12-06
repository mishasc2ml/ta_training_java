package com.epam.rd.autotasks.meetautocode;

import java.time.LocalTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int hour = seconds / 3600;
        int min = (seconds - hour * 3600) / 60;
        int sec = (seconds - hour * 3600) - 60 * min;
        if (hour == 24) hour = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
        LocalTime localtime = LocalTime.of(hour, min, sec);
        System.out.println(formatter.format(localtime));
    }
}
