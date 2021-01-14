package com.jali.demo008_thread_poll;

public class Task implements Runnable {

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " running");
    }
}
