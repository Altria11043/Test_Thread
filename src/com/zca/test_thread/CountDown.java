package com.zca.test_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Altria
 * Date: 2/10/2019 上午 9:55
 */
public class CountDown {


    public static void main(String[] args) {
        Date endTime = new Date(System.currentTimeMillis());
        long end = endTime.getTime();
        try {
            while(true){
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(endTime));
                Thread.sleep(1000);
                endTime = new Date(endTime.getTime()+1000);
                if (end+10000 < endTime.getTime()){
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
