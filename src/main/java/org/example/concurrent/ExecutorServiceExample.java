package org.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // ExecutorService 객체를 생성한다.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // Thread를 생성하고 실행시킨다.
        executorService.execute(new MyTask2("TODO 1"));
        executorService.execute(new MyTask2("TODO 2"));
        executorService.execute(new MyTask2("TODO 3"));
        // ExecutorService를 종료시킨다.
        executorService.shutdown();
    }

    static class MyTask2 implements Runnable {
        private String id;
        public MyTask2(String id) {
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
