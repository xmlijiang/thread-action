package com.jali.demo012.wait_notify;

/**
 * 题目：现在两个线程，可以操作初始值为0度的一个空调
 * 实现一个线程对该变量加1，一个线程对该变量减1
 * "实现" 交替，来10轮，变量初始值为零
 *
 * 线程 操作 资源类
 * 判断、干活、通知
 */
class AirConditioner{
    int i = 0;

    public synchronized void increment(){
        // 判断
        if(i!=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 干活
        i++;
        System.out.println(Thread.currentThread().getName() + "： "+i);
        // 通知
        notify();
    }

    public synchronized void decrement(){
        if(i==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i--;
        System.out.println(Thread.currentThread().getName() + "： "+i);
        notify();
    }
}
public class AddMinusDemo {
    public static void main(String[] args) {
        AirConditioner myNum = new AirConditioner();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myNum.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                myNum.decrement();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(myNum.i);
    }
}
