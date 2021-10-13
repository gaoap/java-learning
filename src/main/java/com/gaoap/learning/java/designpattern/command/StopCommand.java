package com.gaoap.learning.java.designpattern.command;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName StopCommand.java
 * @Description 具体命令角色类
 * @createTime 2021年10月12日 21:19:00
 */
public class StopCommand implements Command {
    private AudioPlayer myAudio;

    public StopCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    @Override
    public void execute() {
        myAudio.stop();
    }

}
