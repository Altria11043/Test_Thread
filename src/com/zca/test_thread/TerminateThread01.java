package com.zca.test_thread;

/**
 * 终止线程
 * 1.线程正常执行--->次数
 * 2.外部干涉--->加入标识(不要使用stop destroy)
 * @author Altria
 * Date: 1/10/2019 上午 9:50
 */
public class TerminateThread01 implements Runnable {

    // 加入标识,标记线程体是否可以运行
    private boolean flag = true;
    private String name;

    private TerminateThread01(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        // 关联标识,true--->运行, false--->停止
        while(flag){
            System.out.println(name + "--->" + i++);
        }
    }

    private void terminate(){
        this.flag = false;
        System.out.println(name + "--->线程停止");
    }

    public static void main(String[] args) {
        TerminateThread01 tt1 = new TerminateThread01("Zhou");
        new Thread(tt1).start();

        for (int i=0; i<999; i++){
            if (i == 800){
                tt1.terminate();
            }
            // 这里的打印输出不能省略,不然会因为电脑运行过快导致线程直接停止
            System.out.println("main--->" + i);
        }
    }
}
