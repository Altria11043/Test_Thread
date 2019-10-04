package com.zca.ProducerConsumer;

/**
 * 协作模型: 生产者消费者实现方式一: 信号灯法
 * 借助标志位
 * @author Altria
 * Date: 4/10/2019 上午 10:22
 */
public class Cooperation02 {
    public static void main(String[] args) {
        TV t = new TV();
        new Player(t).start();
        new Watcher(t).start();
    }
}

// 生产者 演员
class Player extends Thread{
    TV tv;
    public Player(TV tv) {
        this.tv = tv;
    }

    public void run() {
        for (int i=0;i<20;i++){
            if (i%2==0){
                tv.play("开始脱口秀");
            }else{
                tv.play("好消息好消息, 智能手机降价了");
            }
        }
    }
}
// 消费者 观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv) {
        this.tv = tv;
    }

    public void run() {
        for (int i=0;i<20;i++){
            tv.watch();
        }

    }
}
// 同一个资源 电视
class TV{
    String voice;

    // 信号灯
    // T表示演员表演 观众等待
    // F表示观众观看 演员等待
    boolean flag = true;

    // 生产
    public synchronized void play(String voice){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了-->" + voice);
        this.voice = voice;
        this.notifyAll();
        // 信号灯必须在锁中切换
        this.flag = !this.flag;
    }

    // 消费
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了->" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}