package com.gaoap.learning.java.designpattern.observer.push;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Observer.java
 * @Description 抽象观察者角色类
 * @createTime 2021年10月13日 08:48:00
 */
public interface Observer {
    /**
     * 更新接口
     *
     * @param state 更新的状态
     */
    public void update(String state);
}
