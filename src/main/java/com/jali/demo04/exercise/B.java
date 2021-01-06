package com.jali.demo04.exercise;

public class B implements Runnable{

    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("B:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
