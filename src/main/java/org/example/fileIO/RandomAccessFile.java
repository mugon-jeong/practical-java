package org.example.fileIO;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RandomAccessFile {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java RandomAccessFile filename");
            return;
        }

        Path file = Paths.get(args[0]);
        String s = "Java New Features\n";
        byte data[] = s.getBytes();
        ByteBuffer out = ByteBuffer.wrap(data);
        ByteBuffer copy = ByteBuffer.allocate(1024);

        // 데이터를 조회할 파일을 오픈하기 위해 FileChannel을 생성
        try (
                FileChannel fileChannel = FileChannel.open(file, StandardOpenOption.READ, StandardOpenOption.WRITE)
        ) {
            // 파일에서 1024 바이트를 읽어들인다.
            int index;
            do {
                // 파일에서 1024 바이트 만큼 읽었기에 포지션이 1024로 이동한다.
                index = fileChannel.read(copy);
            }
            while (index != -1 && copy.hasRemaining());
            // 1024번째 위치에서 0번째 위치로 이동한 후 데이터를 쓴다.
            fileChannel.position(0);
            while (out.hasRemaining()) {
                // 포지션 0에서 문자열 s를 파일에 쓰고 포지션이 17로 이동한다.
                fileChannel.write(out);
            }
            // ByteBuffer를 초기화
            out.rewind();

            // 파일의 제일 뒤로 이동한 후 다시 데이터를 쓴다.
            long length = fileChannel.size();
            fileChannel.position(length - 1);
            copy.flip();
            while (copy.hasRemaining()) {
                fileChannel.write(copy);
            }

            while (out.hasRemaining()) {
                fileChannel.write(out);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
