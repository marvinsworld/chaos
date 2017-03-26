package com.ewan.test.park;

public class WaitAndNotifyTest {

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait() ThreadName=" + Thread.currentThread().getName());
                Thread.sleep(5000);
                lock.wait();

                System.out.println("  end wait() ThreadName=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synNotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin notify() ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
                lock.notify();
                Thread.sleep(2000);
                System.out.println("end notify() ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class ThreadA extends Thread {
        private Object lock;

        public ThreadA(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            WaitAndNotifyTest service = new WaitAndNotifyTest();
            service.testMethod(lock);
        }
    }

    public static class synNotifyMethodThread extends Thread {
        private Object lock;

        public synNotifyMethodThread(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            WaitAndNotifyTest service = new WaitAndNotifyTest();
            service.synNotifyMethod(lock);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        Object lock1 = new Object();

        ThreadA a = new ThreadA(lock);
        a.start();

        //NotifyThread notifyThread = new NotifyThread(lock);
        //notifyThread.start();

        synNotifyMethodThread c = new synNotifyMethodThread(lock);
        c.start();
    }
}

