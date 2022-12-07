package com.epam.rd.autotasks.requirements;

public class Requirements {

    public static void requireNonNull(Object obj) throws NullPointerException {
        if (obj == null) throw new NullPointerException();
    }

    public static void requireNonNull(Object obj, String message) throws NullPointerException {
        if (obj == null) throw new NullPointerException(message);
    }

    public static void checkArgument(boolean value) throws IllegalArgumentException {
        if (!value) throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean value, String message) throws IllegalArgumentException {
        if (!value) throw new IllegalArgumentException(message);
    }

    public static void checkState(boolean value) throws IllegalStateException{
        if (!value) throw new IllegalStateException();
    }

    public static void checkState(boolean value, String message) {
        if (!value) throw new IllegalStateException(message);
    }

    public static void checkIndex(int index, int size) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
    }
}
