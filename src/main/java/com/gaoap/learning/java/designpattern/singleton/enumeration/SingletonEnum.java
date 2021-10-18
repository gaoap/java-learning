package com.gaoap.learning.java.designpattern.singleton.enumeration;

/**
 * 枚举类型，天生单例。并且避免反序列化及反射出现的多实例问题
 */
enum SingletonEnum {
    INSTANCE;
    int value;

    // 这里我们可以自定义构造函数.
    private SingletonEnum() {
        value = 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


