package com.gaoap.learning;

import com.gaoap.learning.java.DefaultInterface;
import com.gaoap.learning.java.FatherInterface;
import com.gaoap.learning.java.Son;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 默认方法(可以被子类覆盖)：
 * 默认方法是可以在接口中写执行体的。主要作用：
 * 1.接口升级，可以避免改变其他实现类。
 * 2.函数拼接
 * 格式：public default 返回值方法名(){}
 * <p>
 * 注意：接口的默认方法，可以直接使用实现类的对象进行调用
 * 也可以在实现类中对其进行覆盖重写。
 * <p>
 * 静态方法（不可以被重写）：
 * 因为静态方法不可以实例化，在接口中也是一样的
 * 所以在接口中定义静态方法的作用就是静态方法的作用：
 * 不需要实例化，直接使用，节省内存空间。
 * 格式：public static 返回值 方法名(){}
 * <p>
 * 注意：接口中静态方法和类中静态方法一样，只能通过接口.静态方法名的方式调用
 * 注意：static方法不可以被重写，在子类中，可以定义与父类同名的静态方法，不过并不存在“多态”，严格的说，
 * 方法间没有多态就不能称作“覆盖”。所以说，子类的静态方法，并没有覆盖父类的方法。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName DefaultInterfaceTest.java
 * @Description 接口默认方法和静态方法
 * @createTime 2021年10月09日 16:21:00
 */
public class DefaultInterfaceTest {

    @Test
    public void defaultMethod() {

        //assertEquals("父类默认方法执行",new DefaultInterface());
        FatherInterface father = new FatherInterface() {
            @Override
            public String abstract1() {
                return null;
            }
        };
        assertEquals("父类默认方法执行", father.defaultMethod());
        FatherInterface son = new Son();
        assertEquals("子类默认方法执行", son.defaultMethod());
        assertEquals("抽象方法执行", son.abstract1());
        //编译器报错
        //son.staticMethod();
        assertEquals("父类接口静态方法执行", FatherInterface.staticMethod());
        FatherInterface son1 = new Son();
        assertEquals("子类默认方法执行", son1.defaultMethod());
        assertEquals("抽象方法执行", son1.abstract1());
        //编译器报错
        //son1.staticMethod();
        assertEquals("子类接口静态方法执行", Son.staticMethod());

    }
}
