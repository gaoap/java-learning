package com.gaoap.learning.java.command;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName RewindCommand.java
 * @Description 具体命令角色类
 * @createTime 2021年10月12日 21:19:00
 */
public class RewindCommand implements Command {

    private AudioPlayer myAudio;

    public RewindCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    @Override
    public void execute() {
        myAudio.rewind();
    }

}
