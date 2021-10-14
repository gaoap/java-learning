package com.gaoap.learning.java.designpattern.principle.lod;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特法则（Law of Demeter）
 * <p>
 * 一个对象应该对尽可能少的对象有接触，也就是只接触那些真正需要接触的对象。
 * <p>
 * 解读：迪米特法则也叫做最少知道原则，一个类应该只和它的成员变量，方法的输入，
 * 返回参数中的类作交流，而不应该引入其他的类（间接交流）。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName LawOfDemeterPrinciple.java
 * @Description 迪米特法则（Law of Demeter）
 * @createTime 2021年10月14日 09:13:00
 */
public class LawOfDemeterPrinciple {
    //玩具
    public class Toy {
    }

    //店长
    public class Storekeeper {

        public void checkNumberOfToy(List<Toy> toysList) {
            System.out.println("目前商店玩具存货：" + toysList.size());
        }

    }

    /**
     * 这是一个错误示范，boss知道的太多了
     * 一个对象应该对尽可能少的对象有接触，也就是只接触那些真正需要接触的对象。
     * <p>
     * 解读：迪米特法则也叫做最少知道原则，一个类应该只和它的成员变量，方法的输入，返回参数中的类作交流，而不应该引入其他的类（间接交流）。
     */
    public class Boss {

        public void commandCheckNumber(Storekeeper storekeeper) {
            //模拟Boss整理商品玩具，店长在做统计。按照迪米特法则，boss不需要知道Toy；
            List<Toy> toysList = new ArrayList<Toy>();
            for (int i = 0; i < 20; i++) {
                toysList.add(new Toy());
            }
            storekeeper.checkNumberOfToy(toysList);
        }

    }

    @Test
    public void countClient() {
        Boss boss = new Boss();
        Storekeeper storekeeper = new Storekeeper();
        boss.commandCheckNumber(storekeeper);
    }

    //重构：优秀店长
    public class ExcellentStorekeeper {
        public void checkNumberOfToy() {
            List<Toy> toysList = new ArrayList<Toy>();
            for (int i = 0; i < 20; i++) {
                toysList.add(new Toy());
            }
            System.out.println("目前商店玩具存货：" + toysList.size());
        }
    }

    //重构：优秀老板，他只需要知道店长的存在即可，不需要关心具体的玩具类
    public class ExcellentBoss {
        public void commandCheckNumber(ExcellentStorekeeper storekeeper) {
            storekeeper.checkNumberOfToy();
        }
    }

    @Test
    public void countClient2() {
        ExcellentBoss boss = new ExcellentBoss();
        ExcellentStorekeeper storekeeper = new ExcellentStorekeeper();
        boss.commandCheckNumber(storekeeper);
    }

}
