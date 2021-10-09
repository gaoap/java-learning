package com.gaoap.learning.java;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Son.java
 * @Description 实现FatherInterface的接口，并覆盖默认方法
 * @createTime 2021年10月09日 16:27:00
 */
public class Son implements FatherInterface {

    @Override
    public String abstract1() {
        return "抽象方法执行";
    }

    @Override
    public String defaultMethod() {
        return "子类默认方法执行";
    }

    public static String staticMethod() {
        return "子类接口静态方法执行";
    }
}
