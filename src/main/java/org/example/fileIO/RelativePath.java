package org.example.fileIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePath {
    public static void main(String[] args) {
        Path path = Paths.get("../study");
        System.out.println(path.toString());
        System.out.println(path.getFileName());
    }
}
