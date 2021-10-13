package com.gaoap.learning.java.designpattern.observer.pull;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName ConcreteObserver.java
 * @Description 　拉模型的具体观察者类
 * @createTime 2021年10月13日 09:06:00
 */
public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerState;

    @Override
    public void update(Subject subject) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = ((ConcreteSubject) subject).getState();
        System.out.println("观察者状态为：" + observerState);
    }

}
