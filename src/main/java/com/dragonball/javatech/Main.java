package com.dragonball.javatech;

public class Main {

    public static int main=1;

    static {
        System.out.println("main = " + main);
        System.out.println("main静态代码");
    }
    private int m;

    public Main() {
        System.out.println("main构造函数");
    }

    public int inc(){
        return m+1;
    }
}

