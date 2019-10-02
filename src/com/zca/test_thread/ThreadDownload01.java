package com.zca.test_thread;

import com.zca.test.WebDownload;

/**
 * 继承多线程
 * 多线程下载图片
 * 1.创建: 继承Thread+重写run
 * 2.启动: 创建实现类对象+start
 * @author Altria
 * @date: 2019/9/30 0:04
 */
public class ThreadDownload01 extends Thread{
    private String url;
    private String name;

    public ThreadDownload01(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownload wd = new WebDownload();
        wd.download(url, name);
        System.out.println(name);
    }

    public static void main(String[] args) {
//        ThreadDownload01 td1 = new ThreadDownload01("https://cdn.umowang.com/media/fgo/servant/card/265A.png", "一破.png");
        new ThreadDownload01("https://cdn.umowang.com/media/fgo/servant/card/265A.png", "一破.png").start();
//        ThreadDownload01 td2 = new ThreadDownload01("https://cdn.umowang.com/media/fgo/servant/card/265B.png", "二破.png");
        new ThreadDownload01("https://cdn.umowang.com/media/fgo/servant/card/265B.png", "二破.png").start();
//        ThreadDownload01 td3 = new ThreadDownload01("https://cdn.umowang.com/media/fgo/servant/card/265C.png", "三破.png");
        new ThreadDownload01("https://cdn.umowang.com/media/fgo/servant/card/265C.png", "三破.png").start();
//        ThreadDownload01 td4 = new ThreadDownload01("https://cdn.umowang.com/media/fgo/servant/card/265D.png", "满破.png");
        new ThreadDownload01("https://cdn.umowang.com/media/fgo/servant/card/265D.png", "满破.png").start();

    }
}
