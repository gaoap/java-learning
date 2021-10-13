package com.gaoap.learning.java.designpattern.command;

/**
 * 命令模式：
 * 　命令模式属于对象的行为模式。命令模式又称为行动(Action)模式或交易(Transaction)模式。
 * 命令模式把一个请求或者操作封装到一个对象中。命令模式允许系统使用不同的请求把客户端参数化，
 * 对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。
 * <p>
 * 命令模式涉及到五个角色，它们分别是：
 * <p>
 * 　　●　　客户端(Client)角色：创建一个具体命令(ConcreteCommand)对象并确定其接收者。如：Person.java
 * <p>
 * 　　●　　命令(Command)角色：声明了一个给所有具体命令类的抽象接口。如：Command.java
 * <p>
 * 　　●　　具体命令(ConcreteCommand)角色：定义一个接收者和行为之间的弱耦合；实现execute()方法，
 * 负责调用接收者的相应操作。execute()方法通常叫做执行方法。   如：*Command.java
 * <p>
 * 　　●　　请求者(Invoker)角色：负责调用命令对象执行请求，相关的方法叫做行动方法。 如：Keypad.java
 * <p>
 * 　　●　　接收者(Receiver)角色：负责具体实施和执行一个请求。任何一个类都可以成为接收者，
 * 实施和执行请求的方法叫做行动方法。如：AudioPlayer.java
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Person.java
 * @Description 客户端
 * @createTime 2021年10月12日 21:21:00
 */
public class Person {
    public static void main(String[] args) {
        //创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();
        //创建请求者对象
        Keypad keypad = new Keypad();
//        //传统方式开始:
//        //创建命令对象
//        Command playCommand = new PlayCommand(audioPlayer);
//        Command rewindCommand = new RewindCommand(audioPlayer);
//        Command stopCommand = new StopCommand(audioPlayer);
//
//        keypad.setPlayCommand(playCommand);
//        keypad.setRewindCommand(rewindCommand);
//        keypad.setStopCommand(stopCommand);
//        //传统方式结束：
        //方法引用lamda
        keypad.setPlayCommand(audioPlayer::play);
        keypad.setRewindCommand(audioPlayer::rewind);
        keypad.setStopCommand(audioPlayer::stop);
        //测试
        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();
    }
}
