package com.singleton;

/**
 * Description:单例
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/09/24 14:05
 */
public class Singleton {

    private volatile static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }

        }
        return instance;
    }
}
