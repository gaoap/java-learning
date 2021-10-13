package com.gaoap.learning.java.designpattern.observer.flow;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Watched.java
 * @Description 发布者（被观察者）Watched实现Flow.Publisher
 * @createTime 2021年10月13日 10:08:00
 */
public class Watched implements Flow.Publisher {
    private SubmissionPublisher<Object> publisher;
    private ExecutorService EXECUTOR;

    Watched() {
        int THREAD_POOL_SIZE = 5;
        EXECUTOR = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        //可以直接new 不用构造方法。2 是buffer数组的容量大小，最大32.
      //  SubmissionPublisher<String> sp  = new SubmissionPublisher(executorService,2,handler);
        publisher = new SubmissionPublisher<>(EXECUTOR, Flow.defaultBufferSize());
    }

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        getPublisher().subscribe(subscriber);
    }

    public SubmissionPublisher<Object> getPublisher() {
        return publisher;
    }
    public void stop() {
        this.publisher.close();
        this.EXECUTOR.shutdown();

    }

    /**
     * 由于是异步的，不能跟着main线程，需要跟着订阅者的异步线程，
     * BufferedSubscription默认使用的是FJ线程池，当我们提交完成后submit
     * 方法结束后，任务就给到了 FJ线程池 或者 自己的线程池 里执行。
     * 从BufferedSubscription 的 consume方法我们可以看到依次从 subscribeOnOpen（onSubscribe），
     * takeItems （onNext），closeOnComplete（onComplete） 逐步调用。
     * 在等待执行的数组里，看到了我们的消息， array就是存放item的地方。
     *
     * @param map
     */
    public void send(Map<String, Object> map) {
        System.out.println("publish send msg : " + map);
        getPublisher().submit(map);
    }
}
