package com.jali.demo007.pc_juc;

import com.jali.demo006.pc.Goods;

import java.util.concurrent.BlockingQueue;

/**
 * 使用juc的工具解决生产者消费者问题
 * @author lijiang
 * @create 2021-01-07 14:40
 */
public class ConsumerQueue implements Runnable{

    private BlockingQueue<Goods> blockingQueue;

    public ConsumerQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Goods goods = blockingQueue.take();
                System.out.println("消费者消费了商品："+goods.getBrand()+goods.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
