package com.jali.demo008_thread_poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }
}
