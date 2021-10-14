package com.gaoap.learning.java.designpattern.template;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName CD.java
 * @Description TODO
 * @createTime 2021年10月13日 14:08:00
 */
public class CD {
    public String doCalculateAccountType() {
        return "定期存款账户";
    }

    public double doCalculateInterestRate() {
        return 0.06;
    }
}
