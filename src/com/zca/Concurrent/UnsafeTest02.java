package com.zca.Concurrent;

/**
 * 并发导致的线程不安全问题二
 * @author Altria
 * Date: 2/10/2019 下午 12:37
 */
public class UnsafeTest02 {
    public static void main(String[] args) {

    }
}

class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 模拟提款机
class Drawing implements Runnable{

    @Override
    public void run() {

    }
}