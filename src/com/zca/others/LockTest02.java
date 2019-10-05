package com.zca.others;

/**
 * 不可重入锁: 锁不可以重复使用
 * @author Altria
 * Date: 5/10/2019 上午 10:12
 */
public class LockTest02 {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        doSomething();
        lock.unlock();
    }
    public void doSomething() throws InterruptedException {
        lock.lock();
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        // 这里被死锁了
        LockTest02 lockTest02 = new LockTest02();
        lockTest02.a();
        lockTest02.doSomething();
    }
}

class Lock{
    // 是否占用
    private boolean isLocked = false;

    // 使用锁
    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    // 释放锁
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }

}
