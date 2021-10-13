package com.gaoap.learning.java.designpattern.strategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * 策略模式:
 * 策略模式属于对象的行为模式。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，
 * 从而使得它们可以相互替换。策略模式使得算法可以在不影响到客户端的情况下发生变化。
 * <p>
 * 　这个模式涉及到三个角色：
 * <p>
 * 　　●　　环境(Context)角色：持有一个Strategy的引用。 例如：Compressor.java
 * <p>
 * 　　●　　抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。
 * 此角色给出所有的具体策略类所需的接口。例如： CompressionStrategy.java
 * <p>
 * 　　●　　具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。此类采用方法引用表达实现抽象策略
 * 例如：GZIPOutputStream.java 和 ZipOutputStream.java
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Client.java
 * @Description 客户端
 * @createTime 2021年10月12日 21:41:00
 */
public class Client {
    //客户端
    public static void main(String args[]) throws IOException {
        Path inFile = null;
        File outFile = null;
        //传统方式：
//        Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
//        gzipCompressor.compress(inFile, outFile);
//
//        Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
//        zipCompressor.compress(inFile, outFile);
        //方法引用：
        Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
        gzipCompressor.compress(inFile, outFile);

        Compressor zipCompressor = new Compressor(ZipOutputStream::new);
        zipCompressor.compress(inFile, outFile);
    }
}
