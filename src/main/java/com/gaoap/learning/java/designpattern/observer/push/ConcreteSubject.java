package com.gaoap.learning.java.designpattern.observer.push;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName ConcreteSubject.java
 * @Description 　具体主题角色类
 * @createTime 2021年10月13日 08:52:00
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState) {
        state = newState;
        System.out.println("主题状态为：" + state);
        //状态发生改变，通知各个观察者
        this.nodifyObservers(state);
    }
}
