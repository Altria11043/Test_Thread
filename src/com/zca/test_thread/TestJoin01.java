package com.zca.test_thread;

/**
 * 在主线程中使用join来阻塞main方法
 * @author Altria
 * Date: 2/10/2019 上午 10:20
 */
public class TestJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i=0; i<100; i++){
                System.out.println("join....." + i);
            }
        });

        t.start();

        for (int i=0;i<100;i++){
            if (i == 20){
                t.join(); // 如果main这里到了20,对main进行阻塞
            }
            System.out.println("main...." + i);
        }
    }
}
