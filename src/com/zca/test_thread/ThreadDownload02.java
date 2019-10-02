package com.zca.test_thread;

import com.zca.test.WebDownload;

/**
 * 实现runnables多线程
 * 多线程下载图片
 * 1.创建: 实现Runnable+重写run
 * 2.启动: 创建实现类对象+Thread类+start
 *
 * 推荐: 避免单继承的局限性,优先使用接口
 * 方便共享资源
 * @author Altria
 * @date: 2019/9/30 0:04
 */
public class ThreadDownload02 implements Runnable{
    private String url;
    private String name;

    public ThreadDownload02(String url, String name) {
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
        ThreadDownload02 td1 = new ThreadDownload02("https://cdn.umowang.com/media/fgo/servant/card/265A.png", "一破.png");
        ThreadDownload02 td2 = new ThreadDownload02("https://cdn.umowang.com/media/fgo/servant/card/265B.png", "二破.png");
        ThreadDownload02 td3 = new ThreadDownload02("https://cdn.umowang.com/media/fgo/servant/card/265C.png", "三破.png");
        ThreadDownload02 td4 = new ThreadDownload02("https://cdn.umowang.com/media/fgo/servant/card/265D.png", "满破.png");

        Thread t1 = new Thread(td1);
        Thread t2 = new Thread(td2);
        Thread t3 = new Thread(td3);
        Thread t4 = new Thread(td4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
