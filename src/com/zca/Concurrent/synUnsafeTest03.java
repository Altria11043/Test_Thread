package com.zca.Concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * 并发导致的线程不安全问题三
 * 往容器放东西,会有内容被覆盖的情况
 * @author Altria
 * Date: 2/10/2019 下午 12:37
 */
public class synUnsafeTest03 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<10000;i++){
            new Thread(()->{
                synchronized(list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        // 这里需要加个延时,否则list中的数还没有添加完,就会被打印出来
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
