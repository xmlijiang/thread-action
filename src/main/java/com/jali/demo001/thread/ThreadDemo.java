package com.jali.demo001.thread;

/**
 * code01 多线程实现方式一
 *
 * 实现多线程的时候
 * 1.继承Thread
 * 2.重写run方法
 * 3.启动线程调用start方法，不能直接使用run方法
 * 4.每次运行结果可能都是不一样的，多线程谁抢占资源无法人为控制
 */
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }

//    public static void main(String[] args) {
//        ThreadDemo threadDemo = new ThreadDemo();
//        // 不能直接使用run方法，否则和调用者main是同一个线程。
//        threadDemo.run();
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(Thread.currentThread().getName()+" main " + i);
//        }
//    }


}
