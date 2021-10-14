package com.gaoap.learning.java.designpattern.principle.lsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 里氏替换原则（Liskov Substitution Principle，LSP）
 * 含义
 * 继承必须确保超类所拥有的性质在子类中仍然成立。
 * 里氏替换原则主要阐述了有关继承的一些原则，也就是什么时候应该使用继承，
 * 什么时候不应该使用继承，以及其中蕴含的原理。里氏替换原是继承复用的基础，
 * 它反映了基类与子类之间的关系，是对开闭原则的补充，是对实现抽象化的具体步骤的规范。
 * <p>
 * 里氏替换原则：子类可以扩展父类的功能，但不能改变父类原有的功能。它包含以下4层含义：
 * <p>
 * 子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
 * 子类中可以增加自己特有的方法。
 * 当子类的方法重载父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松。【注意区分重载和重写】
 * 当子类的方法实现父类的抽象方法时，方法的后置条件（即方法的返回值）要比父类更严格。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName LiskovSubstitutionPrinciple.java
 * @Description 里氏替换原则
 * @createTime 2021年10月13日 22:01:00
 */
public class LiskovSubstitutionPrinciple {

    /**
     * 1\ 子类必须完全实现父类的方法
     */
    public abstract class AbstractGun {
        abstract void shoot();
    }

    public class HandGun extends AbstractGun {
        @Override
        void shoot() {
            System.out.println("使用手枪射击");
        }
    }

    public class MarchineGun extends AbstractGun {
        @Override
        void shoot() {
            System.out.println("使用机枪射击");
        }
    }

    public class Solider {
        private AbstractGun gun;

        public void setGun(AbstractGun gun) {
            this.gun = gun;
        }

        public void killWithGun() {
            System.out.println("士兵杀人了");
            gun.shoot();
        }
    }

    @Test
    public void testShoot() {
        Solider solider = new Solider();
        solider.setGun(new HandGun());
        solider.killWithGun();
        solider.setGun(new MarchineGun());
        solider.killWithGun();
    }

    /**
     * 类B继承类A时，除添加新的方法完成新增功能外，尽量不要重写父类A的方法，也尽量不要重载父类A的方法。
     * 如果非要重写父类的方法，比较通用的做法是：原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉，采用依赖、聚合，组合等关系代替。
     * 2\ 子类可以有自己的个性
     * 3\覆盖或实现父类的方法时输入参数可以被放大
     * 当子类的方法重载父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松。【注意区分重载和重写】
     * 4\覆写或实现父类的方法时输出结果可以被缩小
     */
    public class Father {

        public void a(HashMap map) {
            System.out.println("a:father hashMap");
        }

        public void b(Map map) {
            System.out.println("b:father map ");
        }

        public List<String> c() {
            System.out.println("c:father list");
            return List.<String>of();
        }

    }

    public class Son extends Father {
        //子类可以有自己的个性
        public boolean isSon() {
            return true;
        }

        /**
         * 仔细看着两个类中的方法,并不是重写,而是重载,区别在于
         * <p>
         * a: 一个是父类的参数类型比子类小,
         * <p>
         * b: 一个是父类的参数类型比子类大
         */
        public void a(Map map) {
            System.out.println("a:son hashMap");
        }

        //这就违反了里氏替换原则;
        public void b(HashMap map) {
            System.out.println("b:son map ");
        }
        //覆写或实现父类的方法时输出结果可以被缩小
        public ArrayList<String> c() {
            System.out.println("c:son ArrayList");
            return new ArrayList<>();
        }

    }

    /**
     * 在a情况下, 由于父类的参数是子类参数的子类, 所以,在接受父类传递的参数时,只可能调用父类的方法,
     * 子类永远也不会执行; 如果你想让子类的方法运行，就必须覆写父类的方法,这是正确的
     * 而在b情况下, 执行结果却是调用了子类的方法, 这就违反了里氏替换原则;
     * 子类明明没有复写子类的方法,但是却被执行了, 这可能引起想不到的情况
     */
    @Test
    public void testFatherAndSon() {
        Father f = new Father();
        HashMap map = new HashMap();
        f.a(map);
        f.b(map);
        f.c();
        Son son = new Son();
        son.a(map);
        son.b(map);
        son.c();
    }
}
