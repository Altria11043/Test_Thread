package com.zca.test_thread;

/**
 * 在主线程中使用join来阻塞main方法
 * @author Altria
 * Date: 2/10/2019 上午 10:20
 */
public class TestJoin02 {
    public static void main(String[] args){
        System.out.println("这是讲述了JOJO打败DIO的故事");
        new Thread(new JOJO()).start();
    }
}

class JOJO implements Runnable{

    @Override
    public void run() {
        System.out.println("JOJO正在用他无敌的白金之星吊打DIO");
        System.out.println("不小心被DIO开出了`咋哇鲁托`");
        Thread t = new Thread(new DIO());
        t.start();
        try {
            t.join();
            System.out.println("欧拉欧拉欧拉欧拉欧拉欧拉欧拉欧拉欧拉欧拉欧拉欧拉欧拉!!!!");
            System.out.println("因为DIO去扛压路机的原因导致世界的效果已经过去");
            System.out.println("现在是JOJO的回合");
            System.out.println("DIO战败");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("在DIO开出`咋哇鲁托`的瞬间,JOJO用他那无敌的白金之星打断了他");
        }
    }
}


class DIO implements Runnable{

    @Override
    public void run() {
        System.out.println("咋哇鲁托");
        System.out.println("现在是我的回合");
        System.out.println("DIO突然消失了");
        for (int i=0; i<10; i++){
            try {
                Thread.sleep(1000);
                System.out.println(i + "秒过去了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("泷泽罗拉哒");
    }
}