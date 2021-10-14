package com.gaoap.learning.java.designpattern.principle.srp;

import java.util.stream.IntStream;

/**
 * 单一职责原则(Single Responsibility Principle, SRP)
 * 一个类只负责一个功能领域中的相应职责，或者可以定义为：就一个类而言，应该只有一个引起它变化的原因。
 * 单一职责原则是实现高内聚、低耦合的指导方针，它是最简单但又最难运用的原则，
 * 需要设计人员发现类的不同职责并将其分离，而发现类的多重职责需要设计人员具有较强的分析设计能力和相关实践经验。
 * 单一职责的优点主要是：降低类的复杂度，提高类的可读性和可维护性。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName SingleResponsibilityPrinciple.java
 * @Description 单一职责原则，代码引用图书，[图灵程序设计丛书]《Java 8函数式编程》
 * @createTime 2021年10月13日 16:59:00
 */
public class SingleResponsibilityPrinciple {
    /**
     * 功能需求，计算质数个数
     */
    public static interface PrimeCounter {
        long countPrimes(int upTo);
    }

    /**
     * 违反单一职责原则。计数和判断质数两个功能在一起耦合了
     */
    public static class ImperativeSingleMethodPrimeCounter implements PrimeCounter {
        @Override
        public long countPrimes(int upTo) {
            long tally = 0;
            for (int i = 1; i < upTo; i++) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                    }
                }
                if (isPrime) {
                    tally++;
                }
            }
            return tally;
        }
    }

    /**
     * 符合单一职责原则。计数和判断质数两个功能分开了。各司其职。
     */
    public static class ImperativeRefactoredPrimeCounter implements PrimeCounter {
        @Override
        public long countPrimes(int upTo) {//计数功能
            long tally = 0;
            for (int i = 1; i < upTo; i++) {
                if (isPrime(i)) {
                    tally++;
                }
            }
            return tally;
        }

        private boolean isPrime(int number) {//判断素数功能
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 利用lamda 表达式，优化单一职责原则。
     */
    public static class FunctionalPrimeCounter implements PrimeCounter {

        @Override
        public long countPrimes(int upTo) {
            return IntStream.range(1, upTo)
                    .filter(this::isPrime)
                    .count();
        }

        private boolean isPrime(int number) {
            return IntStream.range(2, number)
                    .allMatch(x -> (number % x) != 0);
        }
    }

    /**
     * 利用lamda 表达式，优化单一职责原则。优雅的利用多CPU并行计算
     */
    public static class ParallelFunctionalPrimeCounter implements PrimeCounter {
        @Override
        public long countPrimes(int upTo) {
            return IntStream.range(1, upTo)
                    .parallel() //利用多CPU并行计算
                    .filter(this::isPrime)
                    .count();
        }

        private boolean isPrime(int number) {
            return IntStream.range(2, number)
                    .allMatch(x -> (number % x) != 0);
        }
    }

}
