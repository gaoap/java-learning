package com.gaoap.learning.java.keyword;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName Keyword.java
 * @Description ::关键字使用举例,验证代码请查看KeywordTest.java
 * @createTime 2021年10月09日 12:54:00
 */
public class Keyword {
    public Keyword() {
    }

    public Keyword(String s) {
        System.out.println(s);
    }

    public static String startsWith(String s) {
        return String.valueOf(s.charAt(0));

    }

    public String endWith(String s) {
        return String.valueOf(s.charAt(s.length() - 1));

    }

    public String endWith() {
        String s = "abcd";
        return String.valueOf(s.charAt(s.length() - 1));

    }
}
