package org.example.fileIO;

import java.io.IOException;
import java.nio.file.*;

public class DeleteFileAndDirectory {

    // 디렉터리에 포함되어 있는 모든 파일을 삭제
    // 하위에 디렉터리가 포함되어 있을 경우 재귀호출
    public static void deleteNotEmptyDirectory(Path path) throws IOException {
        if(Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)){
            try(DirectoryStream<Path> entires = Files.newDirectoryStream(path)){
                for(Path entry : entires){
                    deleteNotEmptyDirectory(entry);
                }
            }
            Files.delete(path);
        }
    }
    public static void main(String[] args) {
        if(args.length <1){
            System.out.println("Usage: java DeleteFileAndDirectory <path>");
            return;
        }
        Path path = Paths.get(args[0]);
        try {
            Files.delete(path);
        }
        catch (DirectoryNotEmptyException e){
            System.out.println(path + " is not empty");
            try{
                // 심볼릭 링크가 아닐 경우만 삭제
                if(!Files.isSymbolicLink(path)){
                    deleteNotEmptyDirectory(path);
                }
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
