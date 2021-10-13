package com.gaoap.learning.java.template;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Account.java
 * @Description 抽象模板角色类
 * @createTime 2021年10月13日 13:36:00
 */
public abstract class Account {
    private Criteria<Double> interestRate;
    private Criteria<String> accountType;

    public Account(Criteria interestRate,
                           Criteria accountType) {

        this.interestRate = interestRate;
        this.accountType = accountType;
    }
    /**
     * 模板方法，计算利息数额
     *
     * @return 返回利息数额
     */
    public final double calculateInterest() {
        double interestRate = this.interestRate.check();
        String accountType = this.accountType.check();
        double amount = calculateAmount(accountType);
        return amount * interestRate;
    }

//    /**
//     * 基本方法留给子类实现，账户分类
//     */
//    protected abstract String doCalculateAccountType();
//
//    /**
//     * 基本方法留给子类实现，核算利率。
//     */
//    protected abstract double doCalculateInterestRate();

    /**
     * 核算金额，获取当前账户金额，一个具体方法由抽象类声明并实现，而子类并不实现或置换。
     */
    private double calculateAmount(String accountType) {

        return 100000.00;
    }
}
