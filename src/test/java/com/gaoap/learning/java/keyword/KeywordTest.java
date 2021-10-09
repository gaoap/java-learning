package com.gaoap.learning.java.keyword;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * 英文：double colon，双冒号（::）运算符在Java 8中被用作方法引用（method reference），
 * 方法引用是与lambda表达式相关的一个重要特性。它提供了一种不执行方法的方法。
 * 为此，方法引用需要由兼容的函数接口组成的目标类型上下文。
 * <p>
 * 通过 `::` 关键字来访问类的构造方法，对象方法，静态方法。总结：我们可以把类Keyword中的方法static String
 * startsWith(String s){...}、String endWith(String s){...}、Something(String something){...}
 * 看作是接口IConvert的实现，因为它们都符合接口定义的那个“模版”，
 * 有传参类型F以及返回值类型T。比如构造方法endWith(String something)，它传参为String类型，返回值类型为Something。
 * 注解@FunctionalInterface保证了接口有且仅有一个抽象方法，所以JDK能准确地匹配到相应方法。
 *
 * 以下是Java 8中方法引用的一些语法：
 *
 * 静态方法引用（static method）语法：classname::methodname 例如：Person::getAge
 * 对象的实例方法引用语法：instancename::methodname 例如：System.out::println
 * 对象的超类方法引用语法： super::methodname
 * 类构造器引用语法： classname::new 例如：ArrayList::new
 * 数组构造器引用语法： typename[]::new 例如： String[]:new
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName KeywordTest.java
 * @Description ::关键字使用举例,验证代码请查看KeywordTest.java
 * @createTime 2021年10月09日 13:27:00
 */
public class KeywordTest extends FatherKeyWord {
    @Test
    public void startsWith() {
        //::静态方法引用
        IConvert<String, String> conver = Keyword::startsWith;
        String start = conver.conver("KeywordTest");
        assertEquals("K", start);
    }

    @Test
    public void endWith() {
        //::对象的实例方法引用语法
        IConvert<String, String> conver = new Keyword()::endWith;
        String start = conver.conver("KeywordTest");
        assertEquals("t", start);
    }

    @Test
    public void keyword() {
        //::类构造器引用语法
        IConvert<String, Keyword> conver = Keyword::new;
        Keyword keyword = conver.conver("访问构造方法");
        assertEquals("t", keyword.endWith("KeywordTest"));
    }

    @Test
    public void keywordArray() {
        //::数组构造器引用语法
        IConvert<Integer, Keyword[]> conver = Keyword[]::new;
        Keyword[] array = conver.conver(4);
        assertEquals(4, array.length);
    }

    @Test
    public void keywordSuper() {
        //:: 对象的超类方法引用语法
        IConvert<String, Integer> conver = super::countLength;
        int start = conver.conver("KeywordTest");
        assertEquals(11, start);

    }

    @Test
    public void keywordlambdas() {
        //:: lambdas中的应用
        Optional<String> word = Optional.of("KeywordTest");
        assertEquals("K", word.map(Keyword::startsWith).get());
        assertEquals("t", word.map(new Keyword()::endWith).get());
        Optional<Keyword> words = Optional.of(new Keyword());
        assertEquals("d", words.map(Keyword::endWith)
                .orElse(""));

    }


}
