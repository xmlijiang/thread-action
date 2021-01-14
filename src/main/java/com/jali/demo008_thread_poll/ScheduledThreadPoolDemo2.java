package com.jali.demo008_thread_poll;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo2 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + " 1延迟1秒钟执行，每3秒执行一次");
            }
        },1,3, TimeUnit.SECONDS);

        // 不能shutDown，否则就关闭定时器了
//        scheduledExecutorService.shutdown();

        // corePoolSize的含义：核心线程数量，在池中保留的线程数，即使它们是空闲的
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + " 2延迟3秒钟执行，每3秒执行一次");
            }
        },3,3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + " 3延迟3秒钟执行，每3秒执行一次");
            }
        },3,3, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println(System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName() + " 4延迟3秒钟执行，每3秒执行一次");
            }
        },3,3, TimeUnit.SECONDS);
    }
}
