package org.example.fileIO;

import java.nio.file.Files;
import java.nio.file.Path;

public class TemporaryFile {
    public static void main(String[] args) {
        try {
            // 임시 디렉터리 생성
            Path tempDirectory = Files.createTempDirectory("java11");
            System.out.println("임시 디렉터리: " + tempDirectory);
            // 임시 파일 생성
            Path tempFile = Files.createTempFile(tempDirectory, null, ".tempdata");
            System.out.println("임시 파일: " + tempFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
