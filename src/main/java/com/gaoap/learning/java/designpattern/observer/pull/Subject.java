package com.gaoap.learning.java.designpattern.observer.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * 拉模型的抽象主题类主要的改变是nodifyObservers()方法。
 * 在循环通知观察者的时候，也就是循环调用观察者的update()方法的时候，传入的参数不同了。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Subject.java
 * @Description 拉模型的抽象主题类
 * @createTime 2021年10月13日 09:07:00
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
    public void nodifyObservers() {

        for (Observer observer : list) {
            observer.update(this);
        }
    }

    /**
     * 事件变更
     *
     * @param newState
     */
    public abstract void change(String newState);
}
