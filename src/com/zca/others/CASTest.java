package com.zca.others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS: 比较并交换
 * @author Altria
 * Date: 5/10/2019 上午 10:56
 */
public class CASTest {
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left < 1){
                    System.out.println("抢完了");
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "抢了一件商品");
                System.out.println("还剩: " + left);
            }).start();
        }
    }
}
