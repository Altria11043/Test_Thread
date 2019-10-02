package com.zca.Concurrent;

/**
 * 并发导致的线程不安全问题一
 * @author Altria
 * Date: 2/10/2019 下午 12:37
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        UnsafeWeb12306 uw = new UnsafeWeb12306();

        new Thread(uw, "上班族").start();
        new Thread(uw, "学生党").start();
        new Thread(uw, "黄牛").start();
    }
}

class UnsafeWeb12306 implements Runnable{

    private int ticktNums = 20;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            testWeb12306();
        }
    }

    // 将方法分离
    private void testWeb12306(){
        if (ticktNums < 0){
            flag = false;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--->" + ticktNums--);
    }
}
