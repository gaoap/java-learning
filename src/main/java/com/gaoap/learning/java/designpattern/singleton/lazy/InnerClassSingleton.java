package com.gaoap.learning.java.designpattern.singleton.lazy;

/**
 * 懒汉式单例
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName InnerClassSingleton.java
 * @Description 懒汉式单例
 * @createTime 2021年10月18日 08:39:00
 */
public class InnerClassSingleton {// implements Serializable {

    private InnerClassSingleton() {
        if (LazyInit.LAZY != null) {//防止反射等方式实例化。但是不能避免反序列化带来的多实例问题
            throw new RuntimeException("不允许创建多个实例");
        }
    }


    //static 是为了使单例的空间共享，保证这个方法不会被重写，重载
    public static final InnerClassSingleton getInstance() {
        //在返回结果以前，一定会先加载内部类
        return LazyInit.LAZY;
    }

    //默认不加载
    private static class LazyInit {
        private static final InnerClassSingleton LAZY = new InnerClassSingleton();
    }

    //此方法可以避免反序列化时被多实例化。实例仍会被多次实例化，只是新创建的实例未被返回而已。
    private Object readResolve() {
        return LazyInit.LAZY;
    }

}
