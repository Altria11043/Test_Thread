package com.zca.Concurrent;

/**
 * 线程安全:在并发时保证数据的正确性,效率尽可能高
 * @author Altria
 * Date: 2/10/2019 下午 12:37
 */
public class synUnsafeTest01 {
    public static void main(String[] args) {
        synUnsafeWeb12306 uw = new synUnsafeWeb12306();

        new Thread(uw, "学生党").start();
        new Thread(uw, "上班族").start();
        new Thread(uw, "黄牛").start();
    }
}

class synUnsafeWeb12306 implements Runnable{

    private int ticktNums = 1000;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            testWeb12306();
        }
    }

    // 对这个方法加锁
    public synchronized void testWeb12306(){
        if (ticktNums <= 0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--->" + ticktNums--);
    }
}
