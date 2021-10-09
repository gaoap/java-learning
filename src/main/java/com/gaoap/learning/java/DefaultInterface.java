package com.gaoap.learning.java;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName DefaultInterface.java
 * @Description TODO
 * @createTime 2021年10月09日 16:47:00
 */
public interface DefaultInterface {
    public default String defaultMethod() {
        return "父类DefaultInterface默认方法执行";
    }

}
