package com.zca.ProducerConsumer;

/**
 * 协作模型: 生产者消费者实现方式一: 管程法
 * @author Altria
 * Date: 4/10/2019 上午 10:22
 */
public class Cooperation01 {
    public static void main(String[] args) {
        synContainer container = new synContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }
}

// 生产者
class Productor extends Thread{
    synContainer container;
    public Productor(synContainer container){
        this.container = container;
    }
    public void run(){
        for(int i=0; i<100; i++){
            System.out.println("生成->" + i + "馒头");
            container.push(new Steamedbun(i));
        }
    }
}
// 消费者
class Consumer extends Thread{
    synContainer container;
    public Consumer(synContainer container){
        this.container = container;
    }
    public void run(){
        for(int i=0; i<100; i++){
            System.out.println("消费->" + container.pop().getId() + "个馒头");
        }

    }
}
// 缓冲区
class synContainer{
    Steamedbun[] buns = new Steamedbun[10];
    int count = 0;

    // 存储
    public synchronized void push(Steamedbun bun){
        // 何时可以生产 容器存在空间
        // 什么时候不能生产?
        if (count == buns.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count] = bun;
        count++;
        this.notifyAll();
    }
    // 获取 消费
    public synchronized Steamedbun pop(){
        // 何时消费
        // 没有数据 只能等待
        if (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Steamedbun bun = buns[count];
        this.notifyAll();
        return bun;
    }
}
// 数据
class Steamedbun{
    private int id;

    public Steamedbun(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}