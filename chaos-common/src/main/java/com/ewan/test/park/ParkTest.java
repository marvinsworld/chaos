package com.ewan.test.park;

import java.util.concurrent.locks.LockSupport;

/**
 * Description:.
 *
 * @author gezhiqiang
 * @version V1.0
 * @since 2017/03/19 14:39
 */
public class ParkTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("周末了我在打游戏");
                LockSupport.park();
                System.out.println("陪女朋友逛逛街");
            }
        });
        thread.start();
        Thread.sleep(3000);
        System.out.println("女朋友准备要喊男朋友逛街");
        LockSupport.unpark(thread);
    }
}
