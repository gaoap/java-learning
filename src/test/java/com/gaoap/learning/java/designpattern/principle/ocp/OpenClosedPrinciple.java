package com.gaoap.learning.java.designpattern.principle.ocp;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * 开闭原则(Open-Closed Principle, OCP)
 * 定义
 * 一个软件实体应当对扩展开放，对修改关闭。即软件实体应尽量在不修改原有代码的情况下进行扩展。
 * <p>
 * 软件实体可以指一个软件模块、一个由多个类组成的局部结构或一个独立的类。
 * <p>
 * 抽象化设计是开闭原则的关键：用抽象类构架框架，用实现扩展细节。
 *
 * @author gaoyd
 * @version 1.0.0
 * @ClassName OpenClosedPrinciple.java
 * @Description 开闭原则(Open - Closed Principle, OCP)
 * @createTime 2021年10月13日 17:49:00
 */
public class OpenClosedPrinciple {
    //定义图书接口
    public static interface IBook {
        //书籍名称
        public String getName();

        //书籍售价
        public int getPrice();

        //书籍作者
        public String getAuthor();

        //出版日期
        public int getPublicationdate();
    }

    //定义儿童图书
    public static class ChildrenBook implements IBook {
        private String name;
        private int price;
        private String author;
        private int publicationdate;

        public ChildrenBook(String name, int price, String author, int publicationdate) {
            this.name = name;
            this.price = price;
            this.author = author;
            this.publicationdate = publicationdate;
        }


        public String getAuthor() {
            return this.author;
        }

        public String getName() {
            return this.name;
        }

        public int getPrice() {
            return this.price;
        }

        public int getPublicationdate() {
            return this.publicationdate;
        }
    }

    //定义购买图书行为模拟
    public static class BookStore {
        private static final ArrayList<IBook> bookList = new ArrayList<>();

        static {
            bookList.add(new ChildrenBook("十万个为什么1", 5000, "你猜猜", 19970809));
            bookList.add(new ChildrenBook("十万个为什么2", 7600, "你猜猜2", 20150304));
        }

        public static void main(String[] args) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            formatter.setMaximumFractionDigits(2);
            System.out.println("-----------书店卖出去的书籍记录如下：-----------");
            for (IBook book : bookList) {
                System.out.println("书籍名称：" + book.getName() + "\t书籍作者：" +
                        book.getAuthor() + "\t书籍价格：" + formatter.format(book.getPrice() / 100.0) + "元");
            }
        }
    }

    //定义儿童图书，需求变更，2001年以前出版的图书，打折9折，否则原价。
    //对ChildrenBook不修改，而是通过继承扩展ChildrenBook。通过子类OffChildrenBook实现打折功能。
    public static class OffChildrenBook extends ChildrenBook {
        public OffChildrenBook(String name, int price, String author, int publicationdate) {
            super(name, price, author, publicationdate);
        }

        @Override
        //覆写销售价格
        public int getPrice() {
            //原价
            int selfPrice = super.getPrice();
            int offPrice = 0;
            //这段代码实际违反了单一职责原则，懒得改了。折扣的逻辑和价格要分开。
            if (this.getPublicationdate() <= 20010000) {  //2001年以前出版的，打折9折，否则原价
                offPrice = selfPrice * 90 / 100;
            } else {
                offPrice = selfPrice;
            }
            return offPrice;
        }
    }

    //定义打折活动开始后的购买图书行为模拟。业务变更，高层业务模块是必须要跟随修改的，不可能一点不修改。
    //把ChildrenBook替换为OffChildrenBook
    public static class OffBookStore {
        private static final ArrayList<IBook> bookList = new ArrayList<>();

        static {
            bookList.add(new OffChildrenBook("十万个为什么1", 5000, "你猜猜", 19970809));
            bookList.add(new OffChildrenBook("十万个为什么2", 7600, "你猜猜2", 20150304));
        }

        public static void main(String[] args) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            formatter.setMaximumFractionDigits(2);
            System.out.println("-----------书店卖出去的书籍记录如下：-----------");
            for (IBook book : bookList) {
                System.out.println("书籍名称：" + book.getName() + "\t书籍作者：" +
                        book.getAuthor() + "\t书籍价格：" + formatter.format(book.getPrice() / 100.0) + "元");
            }
        }
    }

}
