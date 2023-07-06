package org.example.fileIO.file_watch;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class WatchingDirectory {
    public static void main(String[] args) throws IOException {
        // 1. 모니터링 하는 WatchService 객체 생성
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // 2. 모니터링 대상 경로를 생성하고 WatchService에 등록
        Path logsDir = Paths.get("User/conny/workspace");
        logsDir.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        // 3. 모니터링 대상 경로를 생성하고 WatchService에 추가로 등록
        Path propertiesDir = Paths.get("User/conny/workspace/pratical-java");
        propertiesDir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        // 4. 변경 감지 프로그램 작성
        while (true) {
            try {
                // 5. 키 값 조회
                WatchKey changeKey = watchService.take();
                List<WatchEvent<?>> watchEvents = changeKey.pollEvents();

                // 6. 키에 해당하는 변경 목록 조회
                for (WatchEvent<?> watchEvent : watchEvents) {
                    Path path = (Path) watchEvent.context();
                    WatchEvent.Kind<?> kind = watchEvent.kind();
                    System.out.println(kind + " for path: " + path);
                }
                // 변경 키 초기화
                changeKey.reset();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
