package com.jali.demo010.ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：三个售票员 卖出 30张票
 *
 * 多线程编程的企业级套路+模板
 *
 * 1.在高内聚低耦合的前提下，线程 操作（对外暴露的调用方法） 资源类
 * 资源类自身带有调用方法 高内聚
 */

//资源类
class Ticket{

    private int number = 60;
    private Lock lock = new ReentrantLock();

    public void saleTicket(){
        lock.lock();
        try {
            if(number > 0){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 卖出第"+(number--)+"张票，还剩下："+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

//        new Thread(()-> {{
//                for (int i = 1; i < 40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"张三").start();
//
//        new Thread(()->{{
//                for (int i = 1; i < 40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"李四").start();
//
//        new Thread(()->{{
//                for (int i = 1; i < 40; i++) {
//                    ticket.saleTicket();
//                }
//            }
//        },"小红").start();

        // lambda表达式
        new Thread(()->{for (int i = 1; i < 40; i++) ticket.saleTicket();},"张三").start();
        new Thread(()->{for (int i = 1; i < 40; i++) ticket.saleTicket();},"李四").start();
        new Thread(()->{for (int i = 1; i < 40; i++) ticket.saleTicket();},"小红").start();

    }
}
