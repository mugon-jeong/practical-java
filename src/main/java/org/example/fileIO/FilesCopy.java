package org.example.fileIO;

import java.io.IOException;
import java.nio.file.*;

public class FilesCopy {
    public static void copyFile(Path source, Path target, CopyOption[] options) {
        if (Files.isDirectory(source) || Files.notExists(source)) {
            System.out.println("소스 파일이 존재하지 않거나 디렉터리 입니다.");
            return;
        }
        try {
            if (Files.exists(target)) {
                System.out.println("대상 파일이 존재합니다.");
            }
            // 파일을 복사 copy -> move로 변경시 파일 이동
            Files.copy(source, target, options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FilesCopy <source> <target>");
            return;
        }
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);

        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
        };
        copyFile(source, target, options);
    }
}
