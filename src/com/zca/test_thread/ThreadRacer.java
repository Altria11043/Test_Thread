package com.zca.test_thread;

/**
 * 使用多线程模拟两个人赛跑
 * @author Altria
 * @date: 2019/9/30 1:40
 */
public class ThreadRacer implements Runnable{
    // 记录胜利者
    private String winner;
    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%10==0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            // 判断谁是否胜利需要交给其他的方法来
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
        }
    }

    private boolean gameOver(int steps){
        if (winner !=null){
            return true;
        }else{
            if (100 == steps){
                winner = Thread.currentThread().getName();
                System.out.println("winner====>" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreadRacer tr1 = new ThreadRacer();
        new Thread(tr1, "西方记者").start();
        new Thread(tr1, "香港记者").start();
    }
}
