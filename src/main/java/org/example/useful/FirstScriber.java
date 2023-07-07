package org.example.useful;

import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FirstScriber<T> implements Flow.Subscriber<String> {
    private AtomicInteger maxNumber;
    private String subscriberName;
    private Flow.Subscription subscription;

    public FirstScriber(String subscriberName,int maxRequest) {
        this.maxNumber = new AtomicInteger(maxRequest);
        this.subscriberName = subscriberName;
    }

    // 최초 Publisher에 등록되었을때 호출되는 메서드
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        // Publisher에게 메시지를 요청한다.
        subscription.request(1);

    }

    // Publisher로부터 메시지를 수신했을 때 호출되는 메서드
    @Override
    public void onNext(String item) {
        System.out.println(subscriberName + ", 수신 항목: " + item);

        // 최대 호출값을 하나 줄인다.
        maxNumber.decrementAndGet();

        // -1이 되기 전까지 반복해서 Publisher에 데이터를 요청한다.
        if (maxNumber.get() > -1) {
            // 1초 대기 후 요청
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            subscription.request(1);
        }

    }

    // 에러가 발생했을 때 호출되는 메서드
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();

    }

    // 종료되었을 때 호출되는 메서드
    @Override
    public void onComplete() {
        System.out.println(subscriberName + ", 완료");
        subscription.cancel();
    }
}
