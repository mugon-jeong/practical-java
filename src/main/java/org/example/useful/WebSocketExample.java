package org.example.useful;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class WebSocketExample {
    private static ExecutorService executor =
            Executors.newFixedThreadPool(3, new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    System.out.println(
                            "신규 실행자 생성: " + (thread.isDaemon() ? "데몬" : "") +
                                    ", 스레드 그룹: " + thread.getThreadGroup()
                    );
                    return thread;
                }
            });

    // 웹소켓 리스너
    private static class WebSocketListener implements WebSocket.Listener {
        // 웹 소켓이 연결되었을때 실행
        @Override
        public void onOpen(WebSocket webSocket) {
            System.out.println("웹 소켓 연결");
            webSocket.sendText("안녕하세요", true);
            WebSocket.Listener.super.onOpen(webSocket);
        }

        // 서버로부터 메시지를 수신하였을때 생성
        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
            System.out.println("수신 받은 메시지 (from 서버): " + data);
            if (!webSocket.isOutputClosed()) {
                webSocket.sendText("안녕하세요 웹소켓 다시 테스트", true);
            }
            return WebSocket.Listener.super.onText(webSocket, data, last);
        }

        // 웹 소켓을 종료했을때 실행
        @Override
        public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
            System.out.println("종료 상태 코드: " + statusCode + ", 이유: " + reason);
            executor.shutdown();
            return WebSocket.Listener.super.onClose(webSocket, statusCode, reason);
        }

        // 웹 소켓에 에러가 발생했을때 실행
        @Override
        public void onError(WebSocket webSocket, Throwable error) {
            System.err.println("Error occurred: " + error);
            WebSocket.Listener.super.onError(webSocket, error);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String url = "wss://demo.piesocket.com/v3/channel_123?api_key=VCXCEuvhGcBDP7XhiJJUDvR1e1D3eiVjgZ9VRiaV&notify_self";
        // 멀티 스레드 기반의 HTTP 클라이언트 생성
        HttpClient httpClient = HttpClient.newBuilder().executor(executor).build();

        // 비동기로 호출한 웹소켓 객체 생성
        WebSocket webSocket = httpClient.newWebSocketBuilder()
                .buildAsync(URI.create(url), new WebSocketListener())
                .join();

        System.out.println("WebSocket 호출");
        Thread.sleep(1000);
        webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok")
                .thenRun(()-> System.out.println("호출 종료"));
    }
}
