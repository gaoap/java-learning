package com.gaoap.learning.java.command;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName AudioPlayer.java
 * @Description 接收者角色，由录音机类扮演
 * @createTime 2021年10月12日 21:16:00
 */
public class AudioPlayer {
    public void play(){
        System.out.println("播放...");
    }

    public void rewind(){
        System.out.println("倒带...");
    }

    public void stop(){
        System.out.println("停止...");
    }
}
