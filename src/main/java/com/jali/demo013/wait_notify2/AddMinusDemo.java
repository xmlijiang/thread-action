package com.jali.demo013.wait_notify2;

/**
 *
 * 两个生产者，两个消费者
 * 防止线程的唤醒，多线程交互中，必须要防止多线程的虚假唤醒，也即（判断只能用while，不能用if）
 */
class AirConditioner{
    int i = 0;

    public synchronized void increment(){
        // 判断用while，防止虚假唤醒
        // if判断的情况
        // 当i=1，A线程进来判断，1!=0 true，wait等待，C线程进来判断，也是true，等待
        // B进来，--后唤醒，A获得执行权，++后等于1，然后再通知C又++等于2
        while(i!=0){
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
        while(i==0){
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
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myNum.increment();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myNum.decrement();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myNum.increment();
            }
        },"C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myNum.decrement();
            }
        },"D").start();
    }
}
