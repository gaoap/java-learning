package com.gaoap.learning.java;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName IntegerSumTest.java
 * @Description 自定义收集器，实现如下需求：求一段数字的和，如果是奇数，直接相加；如果是偶数，乘以2后在相加。
 * @createTime 2021年10月11日 12:36:00
 */
public class IntegerSumTest {
    /**
     * 明确参数类型
     * 待收集元素的类型：Integer
     * 累加器的类型：IntegerSum
     * 最终结果的类型：Integer
     * <p>
     * 实现如下需求：求一段数字的和，如果是奇数，直接相加；如果是偶数，乘以2后在相加。
     */

    @Test
    public void sum() {
        Integer integerSum = Stream.of(1, 2, 3, 4, 5, 6)
                .collect(new Collector<Integer, IntegerSum, Integer>() {
                    @Override
                    public Supplier<IntegerSum> supplier() {
                        return () -> new IntegerSum(x -> x % 2 == 0 ? x * 2 : x);
                    }

                    @Override
                    public BiConsumer<IntegerSum, Integer> accumulator() {
                        return IntegerSum::doSum;
                    }

                    @Override
                    public BinaryOperator<IntegerSum> combiner() {
                        return IntegerSum::doCombine;
                    }

                    @Override
                    public Function<IntegerSum, Integer> finisher() {
                        return IntegerSum::toValue;
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        Set<Collector.Characteristics> CH_NOID = Collections.emptySet();
                        return CH_NOID;
                    }
                });
        assertEquals(33, integerSum.intValue());

    }

    /**
     * 我们先定义一个类IntegerSum作为过渡容器。这里所说的容器并不一定是集合，
     * 只是对数据的临时存储，称之为过渡容器。在IntegerSum类内，定义了3个方法：
     * <p>
     * doSum:作为累加器，实现求和操作
     * doCombine:作为combine，将两个容器合并
     * toValue:作为finisher，将IntegerSum转为所需要的结果Integer
     */
    public class IntegerSum {
        Function<Integer, Integer> classifier;
        Integer sum = 0;

        public IntegerSum(Function<Integer, Integer> classifier) {
            this.classifier = classifier;
        }

        public IntegerSum doSum(Integer item) {
            this.sum += classifier.apply(item);
            return this;

        }

        public IntegerSum doCombine(IntegerSum it) {
            this.sum += it.sum;
            return this;
        }

        public Integer toValue() {
            return this.sum;

        }
    }
}
