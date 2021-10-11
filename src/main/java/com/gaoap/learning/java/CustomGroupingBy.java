package com.gaoap.learning.java;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 一个Collector是由四部分组成的：
 * Supplier<A> supplier(): 创建新的结果结
 * BiConsumer<A, T> accumulator(): 将元素添加到结果容器
 * BinaryOperator<A> combiner(): 将两个结果容器合并为一个结果容器
 * Function<A, R> finisher(): 对结果容器作相应的变换
 * 本代码并未对Collecotor设置特征。参考：Characteristics为枚举类型，如下描述：
 *
 * CONCURRENT
 * 表示此收集器是 并发的 ，这意味着结果容器可以支持与来自多个线程的相同结果容器同时调用的累加器函数。
 * IDENTITY_FINISH
 * 表示整理器功能是标识功能，可以省略。
 * UNORDERED
 * 指示集合操作不承诺保留输入元素的遭遇顺序。
 *
 *
 * Collector明确参数类型：
 * 待收集元素的类型：T
 * 累加器的类型：Map<K, List<T>>
 * 最终结果的类型：Map<K, List<T>>>
 * 具体使用见测试代码：CustomGroupingByTest.java
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName CustomGroupingBy.java
 * @Description 自定义收集器
 * @createTime 2021年10月11日 12:02:00
 */
public class CustomGroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {


    private final Function<? super T, ? extends K> classifier;

    public CustomGroupingBy(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, element) -> {
            K key = classifier.apply(element);
            List<T> elements = map.computeIfAbsent(key, k -> new ArrayList<>());
            elements.add(element);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (left, right) -> {
            right.forEach((key, value) -> {
                left.merge(key, value, (leftValue, rightValue) -> {
                    leftValue.addAll(rightValue);
                    return leftValue;
                });
            });
            return left;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return map -> map;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }

}

