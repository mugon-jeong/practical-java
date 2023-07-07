package org.example.useful;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FirstProcessor<T, R> extends SubmissionPublisher<R> implements Flow.Processor<T, R> {
    private Function<T, R> function;
    private Flow.Subscription subscription;

    public FirstProcessor(Function<T, R> function) {
        this.function = function;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        submit(function.apply(item));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        close();
    }

    public static void main(String[] args) throws InterruptedException {
        ConcurrentPublisher<String> publisher = new ConcurrentPublisher<>();
        FirstProcessor<Object, String> processor = new FirstProcessor<>(name -> name + "값을 변환");
        FirstScriber<Object> subscriber1 = new FirstScriber<>("Subscriber 1", 10);
        FirstScriber<Object> subscriber2 = new FirstScriber<>("Subscriber 2", 10);

        // publisher에 processor 등록
        publisher.subscribe(processor);

        // processor에 subscriber1 등록
        processor.subscribe(subscriber1);

        // processor에 subscriber2 등록
        processor.subscribe(subscriber2);

        TimeUnit.SECONDS.sleep(10);
    }
}
