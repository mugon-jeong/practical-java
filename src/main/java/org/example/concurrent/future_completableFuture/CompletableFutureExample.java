package org.example.concurrent.future_completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // 첫 번째 Runnable 인터페이스 정의
        Runnable mainTask = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Main Task : " + Thread.currentThread().getName());
        };

        // 두 번째 Runnable 인터페이스
        Runnable subTask = () -> System.out.println("Next Task : " + Thread.currentThread().getName());

        // ExecutorService 정의
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // 두개의 Runnable 작업을 등록하고 실행 시킨다.
        CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
        CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
        CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
        CompletableFuture.runAsync(mainTask, executor).thenRun(subTask);
    }
}
