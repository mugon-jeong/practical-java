package org.example.useful;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Java9FileReader {
    private static final String FILENAME = "...";

    public static void main(String[] args) throws Exception {
        // 외부에서 생성
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        // 객체도 외부에서 생성
        try (br) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
