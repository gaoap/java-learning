package com.gaoap.learning.java.designpattern.observer.pull;

/**
 * 　跟推模型相比，有一点变化，就是调用通知观察者的方法的时候，不需要传入参数了。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName ConcreteSubject.java
 * @Description 　拉模型的具体主题类
 * @createTime 2021年10月13日 09:08:00
 */
public class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void change(String newState) {
        this.setState(newState);
        System.out.println("主题状态为：" + newState);
        //状态发生改变，通知各个观察者
        this.nodifyObservers();
    }
}
