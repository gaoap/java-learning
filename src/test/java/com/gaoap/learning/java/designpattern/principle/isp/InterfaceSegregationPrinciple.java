package com.gaoap.learning.java.designpattern.principle.isp;

/**
 * 接口隔离原则（Interface Segregation Principle，ISP）
 * 含义
 * ：客户端不应该依赖它不需要的接口；一个类对另一个类的依赖应该建立在最小的接口上。
 * 什么是接口隔离原则(Interface Segregation Principle, ISP)
 * 接口对于Java开发者来说都不陌生，它几乎存在于每一个Java程序中，是抽象的代名词。在讲接口隔离原则之前，先说说接口，接口分为以下两种：
 * 实例接口(Object Interface)： 在Java中声明一个类，然后用new关键字产生一个实例，是对一个类型的事物的描述，这就是一种接口。或许我们乍一看会有点懵，怎么和我们原来学习的接口不一样呢，其实我们这样想，我们都知道，在Java中有一个Class类，表示正在运行的类和接口，换句话说每一个正在运行时的类或接口都是Class类的对象，这是一种向上的抽象。接口是一种更为抽象的定义，类是一类相同事物的描述集合，那为什么不可以抽象为一个接口呢？
 * 类接口(Class Interface)： 这就是我们经常使用的用interface定义的接口
 * 接口隔离原则中所说的接口并不是狭意的在Java中用interface定义的接口，而是一种更为宽泛的概念，可以是接口，抽象类或者实体类。
 * <p>
 * 接口隔离原则定义如下：
 * <p>
 * 客户端不应该依赖它不需要的接口
 * 类间的依赖关系应该建立在最小的接口上
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName InterfaceSegregationPrinciple.java
 * @Description 接口隔离原则
 * @createTime 2021年10月13日 22:27:00
 */
public class InterfaceSegregationPrinciple {

    public class Door {
        //锁门
       void lock(){};
       //开门
       void unlock(){};
       //是否未锁门状态
       boolean isOpen(){ return false;};
    }
    class Timer{
        //注册TimerClient
        void register(int timeout,TimerClient clinet){}
    }
    public interface TimerClient{
        //超时
        void timeout();
    }
    //需求，实现定时关门的需求。错误示范，修改Door。违反了单一职责原则
    //如果DoorNew复用到其它模块，那timeout()方法可能根本用不到，却不得不依赖TimerClient接口
    public class DoorNew implements TimerClient {
        //锁门
        void lock(){};
        //开门
        void unlock(){};
        //是否未锁门状态
        boolean isOpen(){ return false;};

        @Override
        public void timeout() {//实现定时锁门
            this.lock();
        }
    }
    //根据单一职责原则，重构一下。
    //新定义接口
    public interface Idoor{
        //锁门
        void lock();
        //开门
        void unlock();
        //是否未锁门状态
        boolean isOpen();
    }
    //这样通过多重继承，实现Timer依赖TimerClient，不会看到Idoor接口的内容。
    //关注Idoor的业务模块，只看到Idoor的内容，不会看到TimerClient的内容。
    //实现了接口隔离
    public class TimerDoor implements TimerClient,Idoor {
        //锁门
        public void lock(){};
        //开门
        public void unlock(){};
        //是否未锁门状态
        public boolean isOpen(){ return false;};

        @Override
        public void timeout() {//实现定时锁门
            this.lock();
        }
    }



}
