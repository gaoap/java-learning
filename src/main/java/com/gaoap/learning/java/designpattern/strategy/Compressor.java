package com.gaoap.learning.java.designpattern.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Compressor.java
 * @Description 环境(Context)角色
 * @createTime 2021年10月12日 20:15:00
 */
public class Compressor {
    private final CompressionStrategy strategy;

    public Compressor(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        try (OutputStream outStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, strategy.compress(outStream));
        }
    }


}
