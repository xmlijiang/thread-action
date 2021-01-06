package com.jali.demo005.bank;

public class JackThread implements Runnable{

    private BankAccount account;

    public JackThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.drawMoney("Jack",200);
        }
    }


}
