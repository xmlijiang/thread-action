package com.jali.demo006.pc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lijiang
 * @create 2021-01-07 10:41
 */
public class MainTest {

    public static void main(String[] args) {
        Goods goods = new Goods();
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
