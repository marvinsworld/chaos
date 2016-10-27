package com.memory;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/10/27 14:50
 */
public class SynchronizedTest {
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }


}
