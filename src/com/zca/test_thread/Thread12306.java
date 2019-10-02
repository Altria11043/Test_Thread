package com.zca.test_thread;

/**
 * 模拟网上抢票
 * @author Altria
 * @date: 2019/9/30 1:28
 */
public class Thread12306 implements Runnable{

    private int Nums = 100;

    @Override
    public void run() {
        while(true){
            if (Nums<0){
                break;
            }
            // 在无网络延时的情况下,共同抢夺一份资源会很少出现异常
            // 现在来模仿一下网络异常
            try {
                // run方法中的所有异常都必须原地解决
                // 在延时10ms之后,就已经出现负数的情况了
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---->" + Nums--);
        }
    }

    public static void main(String[] args) {
        Thread12306 t1 = new Thread12306();
        new Thread(t1,"上班族").start();
        new Thread(t1,"黄牛").start();
        new Thread(t1,"打工仔").start();
    }

}
