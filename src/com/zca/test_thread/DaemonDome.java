package com.zca.test_thread;

/**
 * 守护线程:是为用户线程服务的,jvm停止不用等待守护线程执行完毕
 * 默认:用户线程,jvm等待用户线程执行完毕才会停止
 * @author Altria
 * Date: 2/10/2019 上午 11:51
 */
public class DaemonDome {
    public static void main(String[] args) throws InterruptedException {
        God god = new God();
        My my = new My();

        Thread myt = new Thread(my);
        myt.start();
        Thread.sleep(100);
        System.out.println(myt.isAlive());  // 线程是否还活着
        Thread t= new Thread(god);
        t.setDaemon(true);  // 设置成为守护线程
        t.start();
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("守护线程");
        }
    }
}

class My implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<5; i++){
            System.out.println("普通线程");
        }
    }
}

