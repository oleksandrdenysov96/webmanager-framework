package com.example.test.utils;


//DEPRECATED
public class Utils {

    public static void sleep(long ms) {

        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
