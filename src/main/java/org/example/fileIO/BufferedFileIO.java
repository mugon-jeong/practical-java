package org.example.fileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedFileIO {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: BufferedFileIO <input file> <output file>");
            return;
        }

        Path sourcePath = Paths.get(args[0]);
        Path targetPath = Paths.get(args[1]);
        Charset charset = Charset.forName("EUC-KR");
        // Files에서 BufferedReader와 BUfferedWriter 객체를 생성
        try (BufferedReader reader = Files.newBufferedReader(sourcePath, charset);
             BufferedWriter writer = Files.newBufferedWriter(targetPath, charset);
        ) {
            String line = null;

            // 파일에서 데이터를 한 줄씩 읽는다.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line, 0, line.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
