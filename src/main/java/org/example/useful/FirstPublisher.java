package org.example.useful;

import java.util.concurrent.Flow;

public class FirstPublisher<T> implements Flow.Publisher<String> {
    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        subscriber.onSubscribe(new MySubscription(subscriber));
    }

    public static void main(String[] args) {
        FirstPublisher<Object> publisher = new FirstPublisher<>();
        publisher.subscribe(new FirstScriber<>("Subscriber 1", 10));
        publisher.subscribe(new FirstScriber<>("Subscriber 2", 10));
    }
}

class MySubscription implements Flow.Subscription {

    private Flow.Subscriber<? super String> subscriber;

    public MySubscription(Flow.Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {
        publishItmes(n);
    }

    @Override
    public void cancel() {
        System.out.println("Cancelled");
    }

    private void publishItmes(long n) {
        // 메시지 전송
        for (int i = 0; i < n; i++) {
            subscriber.onNext("Hello: " + n);
        }
    }
}