package com.gaoap.learning.java.template;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName MoneyMarketAccount.java
 * @Description 具体模板角色类，货币市场实现
 * @createTime 2021年10月13日 13:37:00
 */
public class MoneyMarketAccount extends Account {


    public MoneyMarketAccount(MoneyMarket moneyMarket) {
        super(moneyMarket::doCalculateInterestRate, moneyMarket::doCalculateAccountType);
    }
}