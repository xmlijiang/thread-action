package com.jali.demo002.ticket;

/**
 * code01 卖票线程
 *
 * 问题：顺序不一致
 */
public class TicketThread extends Thread{

    // 需要加static，如果是实现Runnable接口则不需要
    private static int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(ticket>0){
                System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket-- + "张票");
            }
        }
    }

    public static void main(String[] args) {
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        TicketThread t3 = new TicketThread();
        TicketThread t4 = new TicketThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
