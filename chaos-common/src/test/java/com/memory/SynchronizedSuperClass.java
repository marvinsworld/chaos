package com.memory;

/**
 * Description:验证synchronized对不同对象实例加锁时.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/10/30 21:23
 */
public class SynchronizedSuperClass extends SuperClass {
    public SynchronizedSuperClass(String content) {
        super(content);
    }


    public static void main(String[] args) {
        SynchronizedSuperClass aa = new SynchronizedSuperClass("aa");
        SynchronizedSuperClass2 bb = new SynchronizedSuperClass2("bb");

        aa.start();
        bb.start();
    }
}

class SynchronizedSuperClass2 extends SuperClass {
    public SynchronizedSuperClass2(String content) {
        super(content);
    }
}


class SuperClass extends Thread {
    //打印内容
    private String content;

    SuperClass(String content) {
        this.content = content;
    }

    public void run() {
        synchronized (Object.class) {
        //synchronized (SuperClass.class) {
        //synchronized (this.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + content);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}