package com.gaoap.learning.java.designpattern.command;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Keypad.java
 * @Description 请求者角色，由键盘类扮演
 * @createTime 2021年10月12日 21:20:00
 */
public class Keypad {
    private Command playCommand;
    private Command rewindCommand;
    private Command stopCommand;

    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }

    public void setRewindCommand(Command rewindCommand) {
        this.rewindCommand = rewindCommand;
    }

    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }

    /**
     * 执行播放方法
     */
    public void play() {
        playCommand.execute();
    }

    /**
     * 执行倒带方法
     */
    public void rewind() {
        rewindCommand.execute();
    }

    /**
     * 执行播放方法
     */
    public void stop() {
        stopCommand.execute();
    }
}