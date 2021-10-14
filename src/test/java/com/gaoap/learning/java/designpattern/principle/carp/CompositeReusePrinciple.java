package com.gaoap.learning.java.designpattern.principle.carp;

import org.junit.Test;

/**
 * 合成复用原则（Composite Reuse Principle）
 *
 * 1.基本介绍
 * 原则是尽量使用合成/聚合的方式，而不是使用继承
 * 合成复用原则又叫做合成/聚合原则。该原则是在一个新的对象里面使用一些已有的对象，
 * 使之成为新对象的一部分，新的对象通过向这些对象的委派达到复用已有功能的目的
 * 2. 合成与聚合的区别
 * 合成和聚合是关联的特殊情况。聚合用来表示"拥有"关系或者整体与部分的关系；
 * 而合成则用来表示一种强得多的“拥有”关系。在一个合成关系里面，部分和整体的生命周期是一样的。
 * 一个合成的新的对象完全拥有对其组成部分的支配权，包括它们的创建和销毁等。使用程序语言的术语来说。
 * 组合而成的新对象对组成部分的内存分配、内存释放有绝对的责任
 *
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName CompositeReusePrinciple.java
 * @Description 合成复用原则（Composite Reuse Principle）
 * @createTime 2021年10月14日 09:41:00
 */
public class CompositeReusePrinciple {
    //定义抽象类
    public abstract class DBConnection {
        public abstract String getConnection();
    }

    //MySQL实现
    public class MySQLConnection extends DBConnection {
        @Override
        public String getConnection() {
            return "MySQL数据库连接";
        }
    }

    //Oracle实现
    public class OracleConnection extends DBConnection {
        @Override
        public String getConnection() {
            return "Oracle数据库连接";
        }
    }

    //H2实现
    public class H2Connection extends DBConnection {
        @Override
        public String getConnection() {
            return "H2数据库连接";
        }
    }

    //制品操作
    public class ProductDao {
        private DBConnection dbConnection;

        public void setDbConnection(DBConnection dbConnection) {
            this.dbConnection = dbConnection;
        }

        public void addProduct() {
            String conn = dbConnection.getConnection();
            System.out.println("当前使用：" + conn + ",增加商品");
        }
    }

    @Test
    public void productTest() {
        ProductDao p = new ProductDao();
        p.setDbConnection(new H2Connection());
        p.addProduct();
    }
}
