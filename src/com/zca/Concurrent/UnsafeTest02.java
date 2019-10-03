package com.zca.Concurrent;

/**
 * 并发导致的线程不安全问题二
 * 同时取款
 * @author Altria
 * Date: 2/10/2019 下午 12:37
 */
public class UnsafeTest02 {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚礼金");

        Drawing my = new Drawing(account, 80, "我");
        Drawing set = new Drawing(account, 80, "她");

        my.start();
        set.start();
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
class Drawing extends Thread{

    Account account; // 取钱的账户
    int drawingMoney; // 取钱的钱数
    int drawingTotal; // 取钱的总数

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        account.money -= drawingMoney;
        drawingTotal += drawingMoney;
        System.out.println(this.getName() + "-->账户余额为:" + account.money);
        System.out.println(this.getName() + "-->取出的总额:" + drawingTotal);
    }
}