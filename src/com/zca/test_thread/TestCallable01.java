package com.zca.test_thread;

import com.zca.test.WebDownload;

import java.util.concurrent.*;

/**
 * 实现Callable
 * @author Altria
 */
public class TestCallable01 implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable01(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() {
        WebDownload wd = new WebDownload();
        wd.download(url, name);
        System.out.println(name);
        return true;
    }

    public static void main(String[] args) {
        // 创建目标对象
        TestCallable01 tc1 = new TestCallable01("https://cdn.umowang.com/media/fgo/servant/card/266A.png", "莉莉丝1.png");
        TestCallable01 tc2 = new TestCallable01("https://cdn.umowang.com/media/fgo/servant/card/266B.png", "莉莉丝2.png");
        TestCallable01 tc3 = new TestCallable01("https://cdn.umowang.com/media/fgo/servant/card/266C.png", "莉莉丝3.png");
        TestCallable01 tc4 = new TestCallable01("https://cdn.umowang.com/media/fgo/servant/card/266D.png", "莉莉丝4.png");

        // 创建执行服务
        ExecutorService es = Executors.newFixedThreadPool(4);

        // 提交执行
        Future<Boolean> future1 = es.submit(tc1);
        Future<Boolean> future2 = es.submit(tc2);
        Future<Boolean> future3 = es.submit(tc3);
        Future<Boolean> future4 = es.submit(tc4);
        // 获取结果
        try {
            boolean f1 = future1.get();
            boolean f2 = future2.get();
            boolean f3 = future3.get();
            boolean f4 = future4.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 关闭服务
        es.shutdownNow();
    }
}
