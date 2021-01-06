package com.jali.demo001.thread;

/**
 * code02 多线程实现方式二
 *
 * （使用了代理模式）
 * 实现Runnable接口
 * 重写run方法
 * 创建Thread对象，将Runnable的实现类对象作为Thread的构造参数
 * 调用thread的start方法
 *
 * 推荐使用：因为java是单继承，将继承关系留给最需要的类
 */
public class RunnableDemo implements Runnable{
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableDemo()).start();
    }
}
