package com.jali.demo006.pc;

/**
 * @author lijiang
 * @create 2021-01-07 10:28
 */
public class Producer implements Runnable{

    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                goods.set("娃哈哈","矿泉水");
            }else{
                goods.set("旺仔","小馒头");
            }

        }
    }
}
