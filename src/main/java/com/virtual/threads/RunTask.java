package com.virtual.threads;

public class RunTask implements Runnable{

    private static int CONT = 0;
    @Override
    public void run() {
        CONT++;
        //System.out.println("Task number " + CONT + " initialized");
    }
}