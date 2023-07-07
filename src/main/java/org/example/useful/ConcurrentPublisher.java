package org.example.useful;

import java.util.concurrent.*;

public class ConcurrentPublisher<T> implements Flow.Publisher<String> {
    private final ExecutorService executor = ForkJoinPool.commonPool();

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        MyAsyncSubscription subscription = new MyAsyncSubscription(subscriber, executor);
        subscriber.onSubscribe(subscription);
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentPublisher<String> publisher = new ConcurrentPublisher<>();
        publisher.subscribe(new FirstScriber<>("Subscriber 1", 10));
        publisher.subscribe(new FirstScriber<>("Subscriber 2", 10));
        TimeUnit.SECONDS.sleep(20);
    }
}

class MyAsyncSubscription implements Flow.Subscription {
    private ExecutorService executor;
    private Flow.Subscriber<? super String> subscriber;
    private Future<?> future;

    public MyAsyncSubscription(Flow.Subscriber<? super String> subscriber, ExecutorService executor) {
        this.executor = executor;
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {
        // 비동기 호출
        future = executor.submit(() -> publishItems(n));
    }

    private void publishItems(long n) {
        for (long i = 0; i < n; i++) {
            subscriber.onNext("Hello " + n);
        }
    }

    @Override
    public void cancel() {
        System.out.println("Cancelled");
    }
}