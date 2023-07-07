package org.example.data_time;

import java.time.Duration;
import java.time.Instant;

public class ElapsedTime {
    public static void main(String[] args) {
        // 현재 시점
        Instant startInstant = Instant.now();
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        Instant endInstant = Instant.now();

        // 두 시점의 차이
        Duration elapsedTime = Duration.between(startInstant, endInstant);
        System.out.println(elapsedTime.getSeconds());

    }
}
