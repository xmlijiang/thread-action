package com.jali.demo007.pc_juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author lijiang
 * @create 2021-01-07 14:45
 */
public class MainQueueTest {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        ProducerQueue producerQueue = new ProducerQueue(blockingQueue);
        ConsumerQueue consumerQueue = new ConsumerQueue(blockingQueue);

        Thread t1 = new Thread(producerQueue);
        Thread t2 = new Thread(consumerQueue);

        t1.start();
        t2.start();
    }
}
