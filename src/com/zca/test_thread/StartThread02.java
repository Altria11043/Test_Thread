package com.zca.test_thread;

/**
 * 将该案例用lambda重写
 * @author Altria
 */
public class StartThread02{

    public static void main(String[] args) {

        new Thread(()->{
            for (int i=0;i<20;i++){
                System.out.println("一边吃东西");
            }
        }).start();

        for (int i=0; i<20; i++){
            System.out.println("一边coding");
        }


    }
}
