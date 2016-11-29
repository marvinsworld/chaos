package com.ewan.oom;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/11/17 17:59
 */
public class Crash {

    public static void main(String[] args) {

        //Object[] o = {“abc”};初始值赋值，不会有影响。
        Object[] o = null;

        while (true) {
            o = new Object[] { o };
            //输出的话，jvm就不会崩溃。
            //System.out.println(o);
        }
    }
}
