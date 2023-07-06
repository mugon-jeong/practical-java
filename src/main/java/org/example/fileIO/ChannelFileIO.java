package org.example.fileIO;

import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ChannelFileIO {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChannelFileIO <input file> <output file>");
            return;
        }
        Path sourcePath = Path.of(args[0]);
        Path targetPath = Path.of(args[1]);

        // SeekableByteChannel 사용
        try (
                SeekableByteChannel inputChannel = Files.newByteChannel(sourcePath, StandardOpenOption.READ);
                SeekableByteChannel outputChannel = Files.newByteChannel(targetPath, StandardOpenOption.CREATE_NEW);
        ) {
            ByteBuffer buf = ByteBuffer.allocate(1024);

            // 파일에서 데이터를 읽어 들인다. 버퍼의 크기만큼 읽어서 저장
            while (inputChannel.read(buf) != 0) {
                // 파일에 데이터를 저장
                outputChannel.write(buf);

                // ...

                // ByteBuffer 값을 초기화한다.
                buf.rewind();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
