package com.zca.test_thread;

import java.lang.Thread.State;

/**
 * @author Altria
 * Date: 2/10/2019 上午 11:14
 */
public class AllState {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i=0; i<5;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("查看线程状态");
        });
        State state = t.getState();
        System.out.println(state);

        t.start();
        state = t.getState();
        System.out.println(state);

//        while(state!= State.TERMINATED){
//            Thread.sleep(1000);
//            state = t.getState();
//            System.out.println(state);
//        }

        while (true){
            Thread.sleep(1000);
            int num = Thread.activeCount();// 获取当前正在执行的线程数
            if (num == 2){
                break;
            }
            System.out.println(num);
            state = t.getState();
            System.out.println(state);
        }
    }
}
