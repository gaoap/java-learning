package com.gaoap.learning.java.designpattern.observer.pull;


/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName PullClient.java
 * @Description 拉模型
 * @createTime 2021年10月13日 09:10:00
 */
public class PullClient {
    public static void main(String[] args) {
        //创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        //创建观察者对象
        Observer observer = new ConcreteObserver();
        //将观察者对象登记到主题对象上
        subject.attach(observer);
        subject.attach(x -> System.out.println("状态为：" + ((ConcreteSubject) x).getState()));
        subject.attach(System.out::println);
        //subject.attach(observer::update);
        //改变主题对象的状态
        subject.change("new state");
    }
}
