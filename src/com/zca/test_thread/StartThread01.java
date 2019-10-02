package com.zca.test_thread;

import org.apache.commons.io.FileUtils;

/**
 * 测试thread
 * 创建线程的方式:
 * 一: 继承Thread类, 重写run方法
 * @author Altria
 */
public class StartThread01 extends Thread {

    /**
     * 线程入口
     */
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        // 创建子类对象
        StartThread01 st = new StartThread01();
        // 启动
        st.start();
        for (int i=0; i<20; i++){
            System.out.println("一边coding");
        }


    }
}
