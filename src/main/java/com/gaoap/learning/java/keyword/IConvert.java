package com.gaoap.learning.java.keyword;
/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName IConver.java
 * @Description :: 必须要用 functional interface 来接收，否则编译器报错
 * @createTime 2021年10月09日 12:54:00
 */
@FunctionalInterface
public interface IConvert<F,T> {
    T conver(F from);
}
