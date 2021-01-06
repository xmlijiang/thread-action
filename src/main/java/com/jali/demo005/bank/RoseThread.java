package com.jali.demo005.bank;

public class RoseThread implements Runnable{

    private BankAccount account;

    public RoseThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.drawMoney("Rose",100);
        }
    }
}
