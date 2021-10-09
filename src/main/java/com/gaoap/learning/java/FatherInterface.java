package com.gaoap.learning.java;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName FatherInterface.java
 * @Description 接口默认方法和静态方法
 * @createTime 2021年10月09日 16:15:00
 */
public interface FatherInterface {
    public abstract String abstract1();

    public default String defaultMethod() {
        return "父类默认方法执行";
    }

    public static String staticMethod() {
        return "父类接口静态方法执行";
    }

}
