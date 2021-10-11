package com.gaoap.learning.java;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Collector明确参数类型：
 * 待收集元素的类型：T
 * 累加器的类型：Map<K, List<T>>
 * 最终结果的类型：Map<K, List<T>>>
 * 具体使用见测试代码：CustomGroupingByTest.java
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName CustomGroupingByTest.java
 * @Description TODO
 * @createTime 2021年10月11日 12:17:00
 */
public class CustomGroupingByTest {
    /**
     * Collector明确参数类型：
     * 待收集元素的类型：String
     * 累加器的类型：Map<Integer, List<String>>
     * 最终结果的类型：Map<Integer, List<String>>>
     */
    @Test
    public void stringsByLength() {
        CustomGroupingBy<String, Integer> stringIntegerGroupingBy = new CustomGroupingBy<>(String::length);
        Map<Integer, List<String>> results = Stream.of("heibei", "henan", "heilongjiang", "guangdong", "liaoning", "beijing", "tianjing")
                .collect(stringIntegerGroupingBy);

        System.out.println(results);

        assertEquals(6, results.size());
        assertEquals(asList("henan"), results.get(5));
        assertEquals(asList("liaoning", "tianjing"), results.get(8));
    }
}
