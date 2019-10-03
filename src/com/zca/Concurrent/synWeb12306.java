package com.zca.Concurrent;

/**
 * @author Altria
 * @date: 2019/10/3 23:09
 */
public class synWeb12306 {
    public static void main(String[] args) throws InterruptedException {
        Web12306 w = new Web12306(20, "火车站");
        new Passenger(3, w, "Altria").start();
        new Passenger(4, w, "Saber").start();
        new Passenger(1, w, "Zhou").start();
        Thread.sleep(100);
        System.out.println(w.getName() + "还剩下-->" + w.getAvailable() + "张票");
    }
}

// 乘客
class Passenger extends Thread{
    int seats;
    public Passenger(int seats,Runnable runnable, String name) {
        super(runnable, name);
        this.seats = seats;
    }
}
// 购票网
class Web12306 implements Runnable{
    private int available; // 可用位置
    private String name; // 名称

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        // 通过父类强转为子类
        Passenger p = (Passenger) Thread.currentThread();
        boolean flag = bookTickets(p.seats);
        if (flag){
            System.out.println(Thread.currentThread().getName() + "-->购买了" + p.seats + "张票");
        }else{
            System.out.println(Thread.currentThread().getName() + "-->购票失败, 票数还剩: " + available);
        }
    }
    private synchronized boolean bookTickets(int seats){
        System.out.println("火车上还剩下的座位数--->" + available);
        if (seats>available){
            return false;
        }
        available -= seats;
        return true;
    }
}
