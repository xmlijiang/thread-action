package com.jali.demo008_thread_poll;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println(System.currentTimeMillis());
        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                System.out.println(System.currentTimeMillis());
                System.out.println("延迟3秒钟执行");
            }
        },3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

    }
}
