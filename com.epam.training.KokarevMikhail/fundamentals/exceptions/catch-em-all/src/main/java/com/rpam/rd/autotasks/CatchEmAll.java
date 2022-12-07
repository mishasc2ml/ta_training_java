package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new Exception();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
        try {
            riskyMethod();
        } catch (FileNotFoundException exception) {
            throw new IllegalArgumentException("Resource is missing", exception);
        } catch (IOException exception) {
            throw new IllegalArgumentException("Resource error", exception);
        } catch (ArithmeticException | NumberFormatException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
