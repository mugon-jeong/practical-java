package org.example.concurrent.forkjoin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinDirSize extends RecursiveTask<Long> {
    private final Path path;

    public ForkJoinDirSize(Path path) {
        this.path = path;
    }

    @Override
    protected Long compute() {
        long fileSize = 0;

        // 디렉터리일 경우 하위 작업으로 분리한다.
        if (Files.isDirectory(path)) {
            try {
                List<Path> fileList = Files.list(path).collect(Collectors.toList());
                List<ForkJoinDirSize> subTaskList = new ArrayList<>();

                // 하위 작업을 생성하고 포크 시킨다. (백그라운드로 실행시킨다)
                for (Path file : fileList) {
                    ForkJoinDirSize subTask = new ForkJoinDirSize(file);
                    // 백그라운드에서 멀티 스레드 형태로 실행
                    subTask.fork();
                    // 작업 목록을 관리하기 위해 List 객체에 추가한다.
                    // 실행 결과를 리턴 받기 위해
                    // 필요시 subTask 객체의 값들을 호출해서 스레드의 실행 상태를 확인
                    subTaskList.add(subTask);
                }
                Long subSize = 0L;
                // 하위 작업들이 종료될 때까지 대기한다.
                for (ForkJoinDirSize subTask : subTaskList) {
                   // 그 결과를 얻기 위해 조인 작업
                    subSize += subTask.join();
                }
                return subSize;
            } catch (IOException e) {
                System.out.println("Error: " + path);
            }
        }
        // 파일일 경우 크기 리턴
        else {
            try {
                fileSize = Files.size(path);
            } catch (IOException e) {
                System.out.println("Error: " + path);
            }
        }
        return fileSize;
    }

    public static void main(String[] args) {
        Path rootPath = Path.of("/Users/conny/workspace");
        // 포크 조인 스레드 풀 생성
        // (스레드 풀 크기를 직접 정의 하지 않은 경우 자바 가상 머신이 자동으로 선택)
        ForkJoinPool pool = new ForkJoinPool();
        System.out.printf("병렬 처리 크기 : %s\n", pool.getParallelism());
        System.out.printf("합계 : %s\n", pool.invoke(new ForkJoinDirSize(rootPath)));
    }
}
