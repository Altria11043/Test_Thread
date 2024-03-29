package com.zca.Concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * 并发导致的线程不安全问题三
 * 往容器放东西,会有内容被覆盖的情况
 * @author Altria
 * Date: 2/10/2019 下午 12:37
 */
public class UnsafeTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
