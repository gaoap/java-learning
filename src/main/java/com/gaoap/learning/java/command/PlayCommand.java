package com.gaoap.learning.java.command;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName PlayCommand.java
 * @Description 具体命令角色类
 * @createTime 2021年10月12日 21:18:00
 */
public class PlayCommand implements Command {

    private AudioPlayer myAudio;

    public PlayCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    /**
     * 执行方法
     */
    @Override
    public void execute() {
        myAudio.play();
    }

}