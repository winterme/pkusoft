package com.zzq.util;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("zhangzq===>" + new Date());
            }
        },0,3, TimeUnit.SECONDS);


    }

}
