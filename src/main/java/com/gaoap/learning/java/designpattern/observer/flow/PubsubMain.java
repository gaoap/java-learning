package com.gaoap.learning.java.designpattern.observer.flow;

import java.util.Map;

/**
 * Flow API 是 Java 9 引入的响应式编程的接口，其中包含4个接口：
 * <p>
 * Publisher：发布者，负责发布消息；
 * Subscriber：订阅者，负责订阅处理消息；
 * Subscription：订阅控制类，可用于发布者和订阅者之间通信；
 * Processor：处理者，同时充当Publisher和Subscriber的角色。
 * <p>
 * 基于Flow.Publisher/Flow.Subscriber的观察者模式
 * 此Demo代码由三部分组成，分别是发布者、观察者、执行函数
 * 发布者(被观察者)： Watched.java
 * 观察者： Watcher.java
 * 执行函数：PubsubMain.java
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName PubsubMain.java
 * @Description Main函数验证结果
 * @createTime 2021年10月13日 10:11:00
 */
public class PubsubMain {
    public static void main(String[] args) {
        Watched watched = new Watched();

        Watcher receiver1 = new Watcher(1);
        watched.subscribe(receiver1);

        Watcher receiver2 = new Watcher(2);
        watched.subscribe(receiver2);

        for (int i = 0; i < 10; i++) {
            watched.send(Map.of(i + "", "这是第" + i + "条消息"));
        }
//        watched.getPublisher().close();
        watched.stop();

    }
}

