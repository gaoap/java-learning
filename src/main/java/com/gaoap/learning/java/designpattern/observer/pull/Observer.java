package com.gaoap.learning.java.designpattern.observer.pull;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Observer.java
 * @Description 拉模型通常都是把主题对象当做参数传递。
 * @createTime 2021年10月13日 09:06:00
 */
public interface Observer {
    /**
     * 更新接口
     *
     * @param subject 传入主题对象，方面获取相应的主题对象的状态
     */
    public void update(Subject subject);
}
