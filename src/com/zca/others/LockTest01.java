package com.zca.others;

/**
 * 可重入锁: 锁可以重复使用
 * @author Altria
 * Date: 5/10/2019 上午 10:12
 */
public class LockTest01 {
    public void test(){
        synchronized(this){
            while(true){
                synchronized (this){
                    System.out.println("可重入锁");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new LockTest01().test();
    }
}
