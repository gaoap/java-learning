package com.gaoap.learning.java.designpattern.singleton.hungry;

/**
 *
 * 饿汉式单例
 * 类加载的时候就立即初始化，并且创建单例对象
 * 优点：没有锁、执行效率比较高。线程安全
 * 缺点：类加载的时候就初始化，不管是否使用。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName HungrySingleton.java
 * @Description 饿汉式单例
 * @createTime 2021年10月18日 08:35:00
 */

public class HungrySingleton {
    //先静态、后动态
    //先属性、后方法
    //先上后下
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return  hungrySingleton;
    }
}

