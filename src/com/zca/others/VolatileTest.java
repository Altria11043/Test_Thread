package com.zca.others;

/**
 * volatile用于保证数据的同步, 也就是可见性
 * 这里的同步比锁更加轻量, 但是现在使用的比较少
 * @author Altria
 * @date: 2019/10/4 21:30
 */
public class VolatileTest {
    private volatile static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            // 为了保证cpu全力去执行这行代码, 中间不添加任何会让cpu去同步数据的操作
            while(num == 0){

            }
        }).start();
        Thread.sleep(1000);
        num = 1;
    }
}
