package com.gaoap.learning.java.designpattern.singleton.threadlocal;

/**
 * 实现线程内单例
 * @author gaoyd
 * @version 1.0.0
 * @ClassName ThreadLocalSingleton.java
 * @Description 保证线程内单例
 * @createTime 2021年10月18日 08:48:00
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }
}

