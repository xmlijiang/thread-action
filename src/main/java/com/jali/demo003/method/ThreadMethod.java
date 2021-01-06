package com.jali.demo003.method;

public class ThreadMethod {

    public static void main(String[] args) throws InterruptedException {
        // 线程的常见api

        // 1.返回目前正在执行的线程
        Thread thread = Thread.currentThread();

        // 2.返回线程的名字
        System.out.println(thread.getName());

        // 3.返回线程的优先级
        System.out.println(thread.getPriority());

        // 4.设定线程的优先级，最低1，最高10
        thread.setPriority(10);
        System.out.println("设置线程的优先级后："+thread.getPriority());

        // 5.判断线程是否在活动
        System.out.println(thread.isAlive());

        Thread thread1 = new Thread();
        System.out.println(thread1.isAlive());

        // 6.join()：谁调用，谁就优先执行，其他线程都处于阻塞状态
        // thread1.join();

        // 7.sleep()：线程休眠mills秒，线程处于阻塞状态
        thread.sleep(1000);// 睡眠1秒

        // 8.yield()：当前线程暂停一次，允许其他线程执行，不阻塞。相当于我跑步，跑着跑着调用yield就停下来一下，然后继续跑。
        // 线程回到就绪状态
        thread.yield();

        // 9.stop() 停止线程，已过时，不推荐使用
        thread.stop();
    }
}
