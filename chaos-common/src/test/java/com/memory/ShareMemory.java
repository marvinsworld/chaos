package com.memory;

/**
 * Description:共享内存
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/10/25 11:44
 */
public class ShareMemory {

    public static volatile int i = 0;

    public void increate(int i) {
        i++;
    }


    public static void main(String[] args) throws InterruptedException {
        new Thread() {

            @Override
            public void run() {
                for (int count = 0; count < 1000; count++) {
                    i++;
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {

            @Override
            public void run() {
                for (int count = 0; count < 1000; count++) {
                    i++;
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();

        Thread.sleep(20000);
        throw new NullPointerException();
        //System.out.println(i);

    }

}
