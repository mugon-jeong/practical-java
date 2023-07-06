package org.example.concurrent;

import java.util.concurrent.Executor;

public class ExecutorExample implements Executor {
    @Override
    public void execute(Runnable task) {
        // 1. Runnable 인터페이스 직접 실행
        task.run();

        // 2. Thread 생성해서 실행
        // new Thread(task).start();
    }

    public static void main(String[] args) {
        ExecutorExample executor = new ExecutorExample();
        executor.execute(() -> System.out.println("Hello, Executor!"));
    }
}
