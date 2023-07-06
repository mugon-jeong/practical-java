package org.example.fileIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertingPath {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ConvertingPath <path>");
            System.exit(-1);
        }

        // 입력받은 값을 기준으로 Path를 생성
        Path path = Paths.get(args[0]);
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
    }
}
