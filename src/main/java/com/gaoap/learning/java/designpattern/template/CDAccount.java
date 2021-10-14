package com.gaoap.learning.java.designpattern.template;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName CDAccount.java
 * @Description 具体模板角色类，定期存款实现
 * @createTime 2021年10月13日 13:37:00
 */
public class CDAccount extends Account {


    public CDAccount(CD cd) {
        super(cd::doCalculateInterestRate, cd::doCalculateAccountType);
    }
}
