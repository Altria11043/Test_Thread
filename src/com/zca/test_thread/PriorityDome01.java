package com.zca.test_thread;

/**
 * 线程优先级
 * 1.MAX_PRIORITY:10
 * 2.MIN_PRIORITY:1
 * 3.NORM_PRIORITY:5(默认)
 * 优先级!=绝对的先后顺序
 * 只是概率高
 * @author Altria
 * Date: 2/10/2019 上午 11:36
 */
public class PriorityDome01 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());

        // 这里不用匿名,后面还有很多地方需要用
        MyPriority mp = new MyPriority();
        Thread t1 = new Thread(mp,"t1");
        Thread t2 = new Thread(mp,"t2");
        Thread t3 = new Thread(mp,"t3");
        Thread t4 = new Thread(mp,"t4");
        Thread t5 = new Thread(mp,"t5");
        Thread t6 = new Thread(mp,"t6");

        // 这里开始设置线程的状态,不能私自设置其他的数值
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);
        t6.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        int num = Thread.activeCount();
        System.out.println(num);
    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}
