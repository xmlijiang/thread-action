package com.jali.demo007.pc_juc;

import com.jali.demo006.pc.Goods;

import java.util.concurrent.BlockingQueue;

/**
 * @author lijiang
 * @create 2021-01-07 14:40
 */
public class ProducerQueue implements Runnable{

    private BlockingQueue<Goods> blockingQueue;

    public ProducerQueue(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Goods goods = new Goods();
            if(i%2==0){
                goods.setBrand("娃哈哈");
                goods.setName("矿泉水"+i);
            }else{
                goods.setBrand("旺仔");
                goods.setName("小馒头"+i);
            }
            System.out.println("生产者开始生产商品："+goods.getBrand()+goods.getName());
            try {
                blockingQueue.put(goods);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
