package com.dragonball.javatech;

public class SubMain extends Main{
    public static int submain=1;

    static {
        System.out.println("submain = " + submain);
        System.out.println("submain静态代码");
    }

    public SubMain() {
        System.out.println("submain构造函数");
    }
    public static void main(String[] args) {
        SubMain subMain = new SubMain();

    }
}
