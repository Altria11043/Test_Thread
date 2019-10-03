package com.zca.Concurrent;

/**
 * 线程安全:在并发时保证数据的正确性,效率尽可能高
 * @author Altria
 * Date: 2/10/2019 下午 12:37
 */
public class synUnsafeTest02 {
    public static void main(String[] args) {
        synUnsafeWeb1230602 uw = new synUnsafeWeb1230602();

        new Thread(uw, "学生党").start();
        new Thread(uw, "上班族").start();
        new Thread(uw, "黄牛").start();
    }
}

class synUnsafeWeb1230602 implements Runnable{

    private int ticktNums = 20;
    boolean flag = true;

    @Override
    public void run() {
        while (flag){
            testWeb12306();
        }
    }

    private void testWeb12306(){
        // 使用方法块
        // 和锁方法一样,因为这里需要把ticktNums,flag两个参数一起锁住
        // 所以需要用到this
        // ticktNums在变,所以锁不住,但是对象的属性变不会影响
        synchronized(this){
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
    // 线程安全:尽可能锁定合理的范围(不是指代码,指数据的完整性)
    private void testWeb12306_01(){
        // 这里是考虑到没有票了,为了不然其他线程继续执行下面的语句导致性能浪费
        if (ticktNums <= 0){
            flag = false;
            return;
        }
        synchronized(this){
            // 如果这里只有一张票了,为了线程安全进行锁定
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
}
