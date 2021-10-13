package com.gaoap.learning.java.designpattern.observer.flow;

import java.util.Map;
import java.util.concurrent.Flow;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Watcher.java
 * @Description 观察者Watcher实现Flow.Subscriber
 * @createTime 2021年10月13日 10:10:00
 */
public class Watcher implements Flow.Subscriber<Map<String,Object>> {
    private Flow.Subscription subscription;
    private int REQ;

    Watcher(int req){
        this.REQ=req;
    }

    /**
     * onSubscribe方法的描述 ， onSubscribe在订阅者执行任何方法之前执行。所以首先打印“订阅消息” 。
     * @param subscription
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription=subscription;
        System.out.println("订阅消息");
        this.subscription.request(REQ);
    }

    @Override
    public void onNext(Map<String,Object> item) {
        // 消费完成后再次请求
        subscription.request(REQ);
        System.out.println(REQ + " :接收信息: "+ item.toString());
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println(REQ + " ：结束");
    }
}

