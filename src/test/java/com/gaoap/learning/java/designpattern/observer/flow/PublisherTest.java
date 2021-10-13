package com.gaoap.learning.java.designpattern.observer.flow;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.BiConsumer;

/**
 * java9反应式编程 SubmissionPublisher实现发布订阅：
 * 1- 新建一个SubmissionPublisher
 * 2- 新建订阅者 Subscriberss ，编写订阅者代码
 * 3- 提交任务
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Test.java
 * @Description java9反应式编程 SubmissionPublisher实现发布订阅
 * @createTime 2021年10月13日 10:59:00
 */
public class PublisherTest {
    @Test
    public void publish() {

        // 错误处理器，可以不写
        BiConsumer<Subscriberss, Exception> handler = (a, b) -> {
            System.out.println(b);
            a.onError(b);
        };

        //线程池也不用，默认自带FJ 的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //可以直接new 不用构造方法。2 是buffer数组的容量大小，最大32，此处抛出一个问题，如果32个item都占满了，会怎么样？
        SubmissionPublisher<String> sp = new SubmissionPublisher(executorService, 2, handler);

        //添加一个订阅者（消费者），这个方法里会初始化BufferedSubscription 也是实际上消费者消费的类
        sp.subscribe(new Subscriberss(10));
        sp.subscribe(new Subscriberss(1));
        //发送4笔数据
        sp.submit("1");
        sp.submit("2");
        sp.submit("3");
        sp.submit("4");
        sp.submit("5");
        sp.submit("6");
        sp.submit("7");
        sp.submit("8");
        sp.submit("9");
        sp.submit("10");

        //关闭stream
        sp.close();
        executorService.shutdownNow();

    }

    //实现一个消费者
    static class Subscriberss<String> implements Flow.Subscriber {

        //保存订阅者的引用
        private Flow.Subscription ss;
        private int SEQ = 0;

        public Subscriberss(int seq) {
            SEQ = seq;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            ss = subscription;
            System.out.println("订阅消息");
            //拉取2个元素（消息）
            subscription.request(SEQ);
        }

        @Override
        public void onNext(Object item) {
            System.out.println(item.toString());
            //再次拉取
            //   if (SEQ % 2 == 0) {
            ss.request(SEQ);
            //   }

        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("error");
        }

        @Override
        public void onComplete() {
            System.out.println("完成");
        }
    }

}
