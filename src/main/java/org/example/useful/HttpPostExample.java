package org.example.useful;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPostExample {
    public static void main(String[] args) {
        String json = "...";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://example.com"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response code: " + httpResponse.statusCode());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
