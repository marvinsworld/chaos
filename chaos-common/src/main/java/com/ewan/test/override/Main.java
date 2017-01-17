package com.ewan.test.override;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2017/01/13 15:09
 */
public class Main {

    public static void main(String[] args) {
        Son son = new Son(1,"son","5");

        SonMethod  sonMethod = new SonMethod();
        sonMethod.methodA(son);
    }
}
