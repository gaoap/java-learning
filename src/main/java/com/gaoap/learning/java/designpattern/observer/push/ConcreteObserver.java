package com.gaoap.learning.java.designpattern.observer.push;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName ConcreteObserver.java
 * @Description 具体观察者角色类
 * @createTime 2021年10月13日 08:52:00
 */
public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerState;

    @Override
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("状态为：" + observerState);
    }

}
