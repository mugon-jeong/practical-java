package org.example.concurrent.future_completableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class InsuranceCalculator {
    public int calculatePrice(Map condition) {
        // 기본 가격
        int price = 1000;

        // 보험료 계산하는 로직 대신 10초 대기하는 것으로 대체
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }

    // calculatePrice를 비동기로 처리
    public Future<Integer> calculatePriceAsync(Map condition) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        // 스레드를 생성하고 실행할 작업을 CompletableFuture에 등록
        new Thread(() -> {
            int price = calculatePrice(condition);
            // 처리 상태에 대한 레퍼런스를 등록
            future.complete(price);
        }).start();
        return future;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InsuranceCalculator cal = new InsuranceCalculator();
        // 5회에 걸쳐 계산 (동기)
        for (int i = 0; i < 5; i++) {
            System.out.printf(
                    "계산 차수 %s : %s\n",
                    (i + 1), cal.calculatePrice(null));
        }

        // 5회에 걸쳐 계산 (동기)
        for (int i = 0; i < 5; i++) {
            System.out.printf(
                    "계산 차수 %s : %s\n",
                    (i + 1), cal.calculatePriceAsync(null).get());
        }

        // 비동기 처리
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            // 비동기로 처리되도록 메서드 호출
            Future<Integer> future = service.submit(() -> {
                return new InsuranceCalculator().calculatePrice(null);
            });
            futures.add(future);
        }
        futures.forEach(future -> {
            try {
                System.out.printf("계산 결과 : %s\n", future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
