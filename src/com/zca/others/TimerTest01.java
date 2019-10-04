package com.zca.others;

import java.util.*;

/**
 * 任务定时调度
 * @author Altria
 * Date: 4/10/2019 下午 12:26
 */
public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // delay: 多久开始执行. period: 下次执行时间间隔
//        timer.schedule(new MyTask(), 2000,1000);
        // month: 从0开始到11
        Calendar cal = new GregorianCalendar(2019,9,4,12,38,00);
        timer.schedule(new MyTask(), cal.getTime());
    }
}

class MyTask extends TimerTask{

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("定时任务,当年的痛");
        }
        System.out.println("任务结束");
    }
}
