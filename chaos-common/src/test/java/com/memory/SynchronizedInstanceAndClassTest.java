package com.memory;

/**
 * Description:测试Synchronized的对象锁和类锁.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/11/02 17:30
 */
public class SynchronizedInstanceAndClassTest {

    private static int count = 0;

    public static synchronized void staticMethod() {
        for (int i = 0; i < 3; i++) {
            System.out.println("static begins" + ", time = " + System.currentTimeMillis() + "ms:" + count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("static ends");

        }
    }

    public static synchronized void staticMethodB() {
        for (int i = 0; i < 3; i++) {
            System.out.println("staticB begins" + ", time = " + System.currentTimeMillis() + "ms:" + count++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("staticB ends");

        }
    }


    public synchronized void method() {
        for (int i = 0; i < 3; i++) {
            System.out.println("common begins" + ", time = " + System.currentTimeMillis() + "ms:" + count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("common ends");
        }
    }

    public static void main(String[] args) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        SynchronizedInstanceAndClassTest.staticMethod();
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        SynchronizedInstanceAndClassTest.staticMethodB();
                    }
                }
        ).start();


        //new Thread(
        //        new Runnable() {
        //            @Override
        //            public void run() {
        //                new SynchronizedInstanceAndClassTest().method();
        //            }
        //        }
        //).start();
    }
}
