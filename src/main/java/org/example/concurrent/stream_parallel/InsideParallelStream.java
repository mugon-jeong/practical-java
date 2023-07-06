package org.example.concurrent.stream_parallel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class InsideParallelStream {
    public static void main(String[] args) throws Exception {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // ForkJoinPool의 common Pool 개수 조정
        // 스레드 개수 2개로 설정
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
        System.out.println("## Thread Pool Size : " + ForkJoinPool.getCommonPoolParallelism());

        // 스트림 내부의 스레드 값을 구함
        intList.parallelStream().forEach(value -> {
            // 현재 스레드의 이름
            String threadName = Thread.currentThread().getName();

            // 스레드의 이름과 데이터 값 출력
            LocalDateTime currentTime = LocalDateTime.now();
            System.out.println(currentTime.format(formatter) +
                    " -> Thread Name : " + threadName + ", Stream Value : " + value);

            // 시간 확인을 위해 2초간 sleep
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 별도의 스레드 풀 생성
        ForkJoinPool customPool = new ForkJoinPool(2);
        customPool.submit(() -> {
            System.out.println("## Thread Pool Size : " + ForkJoinPool.getCommonPoolParallelism());
            // 스트림 내부의 스레드 값을 구함
            intList.parallelStream().forEach(value -> {
                // 현재 스레드의 이름
                String threadName = Thread.currentThread().getName();

                // 스레드의 이름과 데이터 값 출력
                LocalDateTime currentTime = LocalDateTime.now();
                System.out.println(currentTime.format(formatter) +
                        " -> Thread Name : " + threadName + ", Stream Value : " + value);

                // 시간 확인을 위해 2초간 sleep
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }).get();
    }
}
