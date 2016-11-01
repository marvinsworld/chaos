package com.memory;


/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/10/31 22:11
 */
public class Foo implements Runnable {
    public static synchronized void methodA() {
        //TODO
    }
    public static synchronized void methodB() {
        //TODO
    }
    public void methodC() {
        //TODO
    }

    public static void main(String[] args) {
        Foo fooA = new Foo();
        Foo fooB = new Foo();

        Thread t1 = new Thread(fooA, "t1");
        Thread t2 = new Thread(fooB, "t2");
        t1.start();
        t2.start();

        Thread t3 = new Thread(new Foo(), "t3");
        t3.start();
    }


    private static int count = 0;

    public synchronized void method() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " ：" + count++);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            methodA();
        } else if (Thread.currentThread().getName().equals("t2")) {
            methodB();
        } else {
            methodC();
        }


    }
}
