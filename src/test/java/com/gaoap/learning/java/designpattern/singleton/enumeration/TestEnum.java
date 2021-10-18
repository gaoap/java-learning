package com.gaoap.learning.java.designpattern.singleton.enumeration;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author gaoyd
 * @version 1.0.0
 * @ClassName TestEnum.java
 * @Description TODO
 * @createTime 2021年10月18日 09:04:00
 */
public class TestEnum {

    @Test
    public void enumOut() {
        Assert.assertNotEquals("RED", Color.RED);
        Assert.assertEquals(0, Color.RED.ordinal());
        Assert.assertEquals("RED", Color.RED.name());
//        //ColorEnum未覆盖方法toString
//        Assert.assertNotEquals(ColorEnum.BLANK, ColorEnum.RED);
//        Assert.assertEquals(0, ColorEnum.RED.ordinal());
//        Assert.assertEquals("RED", ColorEnum.RED.name());
        //ColorEnum覆盖方法toString
        Assert.assertNotEquals("1_红色", ColorEnum.RED);
        Assert.assertEquals(0, ColorEnum.RED.ordinal());
        Assert.assertEquals("RED", ColorEnum.RED.name());
        System.out.println(ColorEnum.RED);
        System.out.println(ColorEnum.RED.ordinal());
        System.out.println(ColorEnum.RED.name());
        System.out.println(ColorEnum.RED.toString());
    }
}
