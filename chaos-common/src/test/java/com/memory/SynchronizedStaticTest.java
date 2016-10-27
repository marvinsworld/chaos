package com.memory;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/10/27 16:16
 */
public class SynchronizedStaticTest {

    public synchronized static void method1() {
        System.out.println("method1 start...");

        try {
            System.out.println("method1 execute...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("method1 end...");
    }


    public synchronized static void method2() {
        System.out.println("method2 start...");

        try {
            System.out.println("method2 execute...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("method2 end...");
    }

    public static void main(String[] args) {
        final SynchronizedStaticTest test = new SynchronizedStaticTest();
        final SynchronizedStaticTest test2 = new SynchronizedStaticTest();

        new Thread(new Runnable() {

            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {

            public void run() {
                test2.method2();
            }
        }).start();
    }


}
