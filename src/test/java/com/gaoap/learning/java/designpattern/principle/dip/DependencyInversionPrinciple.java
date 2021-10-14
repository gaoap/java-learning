package com.gaoap.learning.java.designpattern.principle.dip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 *
 * 依赖倒置原则(Dependency Inversion Principle, DIP)也叫控制反转
 * 定义：抽象不应该依赖于细节，细节应当依赖于抽象。换言之，要针对接口编程，而不是针对实现编程。
 * 依赖倒转原则要求我们在程序代码中传递参数时或在关联关系中，尽量引用层次高的抽象层类，
 * 即使用接口和抽象类进行变量类型声明、参数类型声明、方法返回类型声明，
 * 以及数据类型的转换等，而不要用具体类来做这些事情。为了确保该原则的应用，
 * 一个具体类应当只实现接口或抽象类中声明过的方法，而不要给出多余的方法，否则将无法调用到在子类中增加的新方法。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName DependencyInversionPrinciple.java
 * @Description 控制反转，代码引用图书，[图灵程序设计丛书]《Java 8函数式编程》
 * @createTime 2021年10月13日 19:25:00
 */
public class DependencyInversionPrinciple {

    public static interface HeadingFinder {
        public List<String> findHeadings(Reader reader);
    }

    public static class NoDIP implements HeadingFinder {

        /**
         * 没有使用控制反转原则的代码将提取标题和资源管理、 文件处理混在一起。 我们真正想要的是编写提
         * 取标题的代码， 而将操作文件相关的细节交给另一个方法。 可以使用 Stream<String> 作为
         * 抽象， 让代码依赖它， 而不是文件。
         */
        public List<String> findHeadings(Reader input) {
            try (BufferedReader reader = new BufferedReader(input)) {
                return reader.lines()
                        .filter(line -> line.endsWith(":"))
                        .map(line -> line.substring(0, line.length() - 1))
                        .collect(toList());
            } catch (IOException e) {
                throw new HeadingLookupException(e);
            }
        }
    }

    public static class ExtractedDIP implements HeadingFinder {
        //应用控制反转原则
        public List<String> findHeadings(Reader input) {
            return withLinesOf(input,
                    lines -> lines.filter(line -> line.endsWith(":"))
                            .map(line -> line.substring(0, line.length() - 1))
                            .collect(toList()),
                    HeadingLookupException::new);
        }

        /**
         * withLinesOf 方法接受一个 Reader 参数处理文件读写， 然后将其封装进一个 BufferedReader 对象，
         * 这样就可以逐行读取文件了。 handler 函数代表了我们想在该方法中执行的
         * 代码， 它以文件中的每一行组成的 Stream 作为参数。 另一个参数是 error， 输入输出有异
         * 常时会调用该方法， 它会构建出与问题域有关的异常， 出问题时就抛出该异常
         */
        private <T> T withLinesOf(Reader input,
                                  Function<Stream<String>, T> handler,
                                  Function<IOException, RuntimeException> error) {

            try (BufferedReader reader = new BufferedReader(input)) {
                return handler.apply(reader.lines());
            } catch (IOException e) {
                throw error.apply(e);
            }
        }
        // END with_lines_Of
    }

    public static class HeadingLookupException extends RuntimeException {
        public HeadingLookupException(IOException e) {
        }
    }

}