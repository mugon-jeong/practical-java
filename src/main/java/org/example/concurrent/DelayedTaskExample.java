package org.example.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayedTaskExample {
    public static void main(String[] args) {
        ScheduledExecutorService exeService = Executors.newSingleThreadScheduledExecutor();

        // 스레드 3개 등록
        exeService.schedule(
                () -> System.out.println("TODO 1"), 10, TimeUnit.SECONDS
        );
        exeService.schedule(
                () -> System.out.println("TODO 2"), 20, TimeUnit.SECONDS
        );
        exeService.schedule(
                () -> System.out.println("TODO 3"), 30, TimeUnit.SECONDS
        );
    }
}
