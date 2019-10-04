package com.zca.others;

/**
 * DCL单例模式: 懒汉模式中添加并发控制 保证在多线程的情况下, 对外存在一个对象
 * 1. 构造器私有化-->避免外部new构造器
 * 2. 提供私有的静态属性-->存储对象的地址
 * 3. 提供公共的静态方法-->获取属性
 *
 * 关键字synchronized加在static静态方法上，是给当前*.java文件对应的Class类上锁；而加在非static静态方法上，是给对象上锁。
 * @author Altria
 * @date: 2019/10/4 21:37
 */
public class DoubleCheckedLocking {
    // 2.提供私有的静态属性
    // 再次重申此处如果没有volatila, 其他线程可能会访问到一个没有初始化的对象
    private volatile static DoubleCheckedLocking instance;
    // 1.构造器私有化
    private DoubleCheckedLocking(){
    }

    public static DoubleCheckedLocking getInstance(){
        // 如果已经存在对象了,为了避免其他线程等待,在这里添加一个判断
        if(null != instance){
            return instance;
        }
        synchronized(DoubleCheckedLocking.class){
            if (null == instance){
                // 这里为了避免对象在初始化的时候运行较慢,导致这个线程运行到后面拿到一个空对象
                // 建议添加volatile
                instance = new DoubleCheckedLocking();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        });
        t.start();
        System.out.println(DoubleCheckedLocking.getInstance());
    }
}
