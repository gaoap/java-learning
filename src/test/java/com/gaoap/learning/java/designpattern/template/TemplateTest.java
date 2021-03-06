package com.gaoap.learning.java.designpattern.template;

import org.junit.Test;

/**
 * 模板方法模式：
 * 模板方法模式是类的行为模式。准备一个抽象类，将部分逻辑以具体方法以及具体构造函数的形式实现，
 * 然后声明一些抽象方法来迫使子类实现剩余的逻辑。不同的子类可以以不同的方式实现这些抽象方法，
 * 从而对剩余的逻辑有不同的实现。这就是模板方法模式的用意。
 * <p>
 * 这里涉及到两个角色：
 * <p>
 * 　　抽象模板(Abstract Template)角色有如下责任：
 * <p>
 * 　　■　　定义了一个或多个抽象操作，以便让子类实现。这些抽象操作叫做基本操作，它们是一个顶级逻辑的组成步骤。
 * 　　■　　定义并实现了一个模板方法。这个模板方法一般是一个具体方法，它给出了一个顶级逻辑的骨架，
 * 而逻辑的组成步骤在相应的抽象操作中，推迟到子类实现。顶级逻辑也有可能调用一些具体方法。如：Account.java。
 * <p>
 * <p>
 * 　　具体模板(Concrete Template)角色又如下责任：
 * <p>
 * 　　■　　实现父类所定义的一个或多个抽象方法，它们是一个顶级逻辑的组成步骤。
 * 　　■　　每一个抽象模板角色都可以有任意多个具体模板角色与之对应，
 * 而每一个具体模板角色都可以给出这些抽象方法（也就是顶级逻辑的组成步骤）的不同实现，
 * 从而使得顶级逻辑的实现各不相同。如：MoneyMarketAccount.java 和 CDAccount.java。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName TemplateTest.java
 * @Description 模板方法模式调用客户端
 * @createTime 2021年10月13日 13:38:00
 */
public class TemplateTest {
    @Test
    public void client() {
        Account account = new MoneyMarketAccount(new MoneyMarket());
        System.out.println("货币市场的利息数：" + account.calculateInterest());
        account = new CDAccount(new CD());
        System.out.println("定期存款的利息数：" + account.calculateInterest());
    }
}
