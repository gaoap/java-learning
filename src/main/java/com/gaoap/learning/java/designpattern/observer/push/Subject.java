package com.gaoap.learning.java.designpattern.observer.push;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Subject.java
 * @Description 抽象主题角色类
 * @createTime 2021年10月13日 08:47:00
 */
public abstract class Subject {
    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> list = new ArrayList<Observer>();

    /**
     * 注册观察者对象
     *
     * @param observer 观察者对象
     */
    public void attach(Observer observer) {

        list.add(observer);
        System.out.println("Attached an observer");
    }

    /**
     * 删除观察者对象
     *
     * @param observer 观察者对象
     */
    public void detach(Observer observer) {

        list.remove(observer);
    }

    /**
     * 通知所有注册的观察者对象
     */
    public void nodifyObservers(String newState) {

        for (Observer observer : list) {
            observer.update(newState);
        }
    }
}
