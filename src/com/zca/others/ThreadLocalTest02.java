package com.zca.others;

/**
 * inheritableThreadLocal: 继承上下文环境的数据, 拷贝一份给子线程
 * @author Altria
 * Date: 5/10/2019 上午 9:40
 */
public class ThreadLocalTest02 {

//    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(2);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }).start();
    }

}