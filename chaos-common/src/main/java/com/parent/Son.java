package com.parent;

/**
 * Created by gezhiqiang on 18/7/3.
 */
public class Son extends Parent {

    private int age;

    public Son(String name, int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Son son = new Son("a",9);
    }
}
