package org.example.useful;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpAsyncExample {
    public static void main(String[] args) {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://google.com"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(httpResponse->{
                    System.out.println(httpResponse.statusCode());
                    return httpResponse;
                })
                .thenAccept(httpResponse->{
                    System.out.println("Response Header : "+httpResponse.headers());
                    System.out.println("Response Body : "+httpResponse.body());
                })
                .join(); // 결과가 올때까지 대기 메서드
    }
}
