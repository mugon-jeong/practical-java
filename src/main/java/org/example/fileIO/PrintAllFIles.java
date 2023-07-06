package org.example.fileIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintAllFIles {
    // 특정 디렉터리 하위의 전체 디렉터리와 파일 목록을 출력
    public static void main(String[] args) {
        Path path = Paths.get("Users/conny/workspace");
        try {
            Files.walkFileTree(path, new FileVisitor<Path>() {
                // 디렉터리 진입하기 전에 호출
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                // 파일에 접근하면서 호출
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (attrs.isSymbolicLink()) {
                        System.out.println("심볼릭 링크 : " + file);
                    } else if (attrs.isRegularFile()) {
                        System.out.println("일반 파일 : " + file);
                    } else {
                        System.out.println("기타 파일 : " + file);
                    }
                    System.out.println("(" + attrs.size() + "bytes)");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println(exc);
                    return FileVisitResult.CONTINUE;
                }

                // 디렉터리 진입 후 호출
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("디렉터리 : " + dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
