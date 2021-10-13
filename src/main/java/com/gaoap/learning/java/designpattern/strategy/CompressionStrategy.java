package com.gaoap.learning.java.designpattern.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName CompressionStrategy.java
 * @Description 抽象策略(Strategy)角色
 * @createTime 2021年10月12日 20:14:00
 */
public interface CompressionStrategy {
    public OutputStream compress(OutputStream data) throws IOException;
}
