package com.jali.demo004.exercise;

public class A implements Runnable{

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("A-------:" + i);
            try {
                Thread.sleep(1050);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
