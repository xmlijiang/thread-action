package com.jali.demo006.pc;

/**
 * @author lijiang
 * @create 2021-01-07 10:30
 */
public class Goods {

    private String brand;
    private String name;

    private boolean flag = false;

    public Goods() {
    }

    public Goods(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public synchronized void get(){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费"+getBrand()+getName());
        flag = false;
        notify();
    }

    public synchronized void set(String brand,String name){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setBrand(brand);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setName(name);
        System.out.println("生产"+getBrand()+getName());
        flag = true;
        notify();
    }
}
