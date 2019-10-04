package com.zca.others;

/**
 * 指令重排: 代码执行顺序与预期不一致
 * 目的: 提高性能
 * @author Altria
 * @date: 2019/10/4 21:13
 */
public class HappenBefore {
    private static int a = 0;
    private static boolean flag = true;

    public static void main(String[] args) {
        for(int i=0; i<10;i++){
            a = 0;
            flag = true;
            Thread t1 = new Thread(()->{
                a = 1;
                flag = false;
            });
            Thread t2 = new Thread(()->{
                if (flag){
                    a *= 1;
                }
                if (a == 0){
                    System.out.println("Happen Before -->" + a);
                }
            });
            t1.start();
            t2.start();

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
