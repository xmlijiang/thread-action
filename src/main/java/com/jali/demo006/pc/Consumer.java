package com.jali.demo006.pc;

import java.util.List;

/**
 * @author lijiang
 * @create 2021-01-07 10:29
 */
public class Consumer implements Runnable{

    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            goods.get();
        }
    }
}
