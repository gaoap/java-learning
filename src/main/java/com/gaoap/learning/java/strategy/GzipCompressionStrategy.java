package com.gaoap.learning.java.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName GzipCompressionStrategy.java
 * @Description 具体策略(ConcreteStrategy)角色
 * @createTime 2021年10月12日 21:44:00
 */
public class GzipCompressionStrategy implements CompressionStrategy {

    @Override
    public OutputStream compress(OutputStream data) throws IOException {
        return new GZIPOutputStream(data);
    }

}