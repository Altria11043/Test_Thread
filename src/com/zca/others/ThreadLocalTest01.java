package com.zca.others;

/**
 * ThreadLocal: 每个线程自身的存储本地, 局部区域
 * 使用ThreadLocal, 每个线程的数据互不干扰
 * get/set/initialValue
 * @author Altria
 * Date: 5/10/2019 上午 9:40
 */
public class ThreadLocalTest01 {

//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    // 更改初始值
//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
//        protected Integer initialValue(){
//            return 200;
//        }
//    };
    // jdk8之后的方法
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->200);
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        // 设置值
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());

        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{

        @Override
        public void run() {
            threadLocal.set((int)(Math.random()*99));
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
    }

}
