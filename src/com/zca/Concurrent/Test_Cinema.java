package com.zca.Concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Altria
 * @date: 2019/10/3 22:00
 */
public class Test_Cinema {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> seats = new ArrayList<Integer>();
        seats.add(1);
        seats.add(2);
        seats.add(3);
        seats.add(4);
        seats.add(5);
        seats.add(6);
        seats.add(7);
        Cinema cinema = new Cinema(seats, "迦勒底影院");

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        new Thread(new Customer(cinema, list1), "藤丸立香").start();
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        new Thread(new Customer(cinema, list2), "圆桌三绅士").start();
        Thread.sleep(100);
        System.out.println(cinema.getName() + "剩下位置为-->" + Arrays.toString(cinema.getAvailable().toArray()));
    }
}

// 影院
class Cinema{
    private List<Integer> available; // 可用的位置
    private String name; //名称

    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    // 购票
    public boolean bookTickets(List<Integer> seat){
        System.out.println(name + "可用的位置-->" + Arrays.toString(available.toArray()));
        // 顾客购买电影票选座
        // 没买一张会从list中将购买后的票去除
        // 对两个数组进行比较
        boolean flag = available.containsAll(seat);
        if (flag){
            available.removeAll(seat);
            return true;
        }
        return false;
    }

    public List<Integer> getAvailable() {
        return available;
    }

    public void setAvailable(List<Integer> available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 顾客
class Customer implements Runnable{
    private Cinema cinema;
    private List<Integer> seat;
    public Customer(Cinema cinema, List<Integer> seat) {
        this.cinema = cinema;
        this.seat = seat;
    }

    @Override
    public void run() {
        synchronized(cinema){
            System.out.println(Thread.currentThread().getName() + "想要的位置为--->" +  Arrays.toString(seat.toArray()));
            boolean flag = cinema.bookTickets(seat);
            if (flag){
                System.out.println("出票成功: " + Thread.currentThread().getName() + "--->位置为: " + Arrays.toString(seat.toArray()));
            }else{
                System.out.println("出票失败: " + Thread.currentThread().getName() + "--->位置不够");
            }
        }
    }
}