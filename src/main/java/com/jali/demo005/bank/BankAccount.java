package com.jali.demo005.bank;

/**
 * 银行账户
 */
public class BankAccount {

    private int balance;

    public BankAccount() {
    }

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized void drawMoney(String name,int money){
        if(balance>=money){
            System.out.println(name+"准备取款");
            setBalance(getBalance()-money);
            System.out.println(name+"完成取款，余额："+getBalance());
        }else{
            System.out.println(name+"准备取款"+money+"，但余额不足："+getBalance());
        }
    }
}
