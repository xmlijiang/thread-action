package com.jali.demo008_thread_poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 会出现有相同线程名情况，表示线程池中的线程被复用了
        // 如果睡眠1秒，则会有20个线程被创建
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
