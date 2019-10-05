package com.zca.others;

/**
 * 不可重入锁: 锁不可以重复使用
 * @author Altria
 * Date: 5/10/2019 上午 10:12
 */
public class LockTest03 {
    ReLock lock = new ReLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        // 这里被死锁了
        LockTest03 lockTest03 = new LockTest03();
        lockTest03.a();
        System.out.println(lockTest03.lock.getHoldCount());
    }
}

class ReLock{
    // 是否占用
    private boolean isLocked = false;
    Thread locedBy = null; // 存储线程
    private int holdCount = 0;
    // 使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while(isLocked && locedBy != t){
            wait();
        }
        isLocked = true;
        locedBy = t;
        holdCount++;
    }
    // 释放锁
    public synchronized void unlock(){
        if (Thread.currentThread() == locedBy){
            holdCount--;
            if (holdCount == 0){
                isLocked = false;
                notify();
                locedBy = null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}
