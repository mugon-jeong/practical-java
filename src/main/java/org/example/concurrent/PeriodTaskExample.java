package org.example.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PeriodTaskExample {
    public static void main(String[] args) {
        ScheduledExecutorService exeService = Executors.newScheduledThreadPool(2);

        // 5초 후 실행, 종료 후 10초 대기 후 반복 실행
        exeService.scheduleWithFixedDelay(
                new MyTask("Delayed 1"), 5, 10, TimeUnit.SECONDS);
        // 5초 후에 실행, 10초 주기로 반복 실행
        exeService.scheduleAtFixedRate(
                new MyTask("Rate 1"), 5, 10, TimeUnit.SECONDS);
        // 5초 후에 실행, 10초 주기로 반복 실행
        exeService.scheduleAtFixedRate(
                new MyTask("Rate 2"), 5, 10, TimeUnit.SECONDS);
    }

    static class MyTask implements Runnable {
        private String id;
        public MyTask(String id) {
            this.id = id;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Task ID : " + id + ", running... " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
