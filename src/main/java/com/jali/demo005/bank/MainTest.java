package com.jali.demo005.bank;

/**
 * Jack和妻子Rose各拥有一张银行卡和存折，可以对同一银行账户进行存取款的操作
 * 请使用多线程以及同步方法模拟Jack和Rose同时取款的过程
 * 要求使用同步方法和同步代码块两种方式实现
 *
 * 分析
 * 定义Account类表示银行账户
 * 定义两个线程分别实现张三和妻子取款的操作
 */
public class MainTest {

    public static void main(String[] args) {
        // 初始化账户余额1000元
        BankAccount bankAccount = new BankAccount(900);
        // 初始化银行卡和存折
        JackThread jackThread = new JackThread(bankAccount);
        RoseThread roseThread = new RoseThread(bankAccount);
        Thread jack = new Thread(jackThread);
        Thread rose = new Thread(roseThread);
        jack.start();
        rose.start();
    }
}
