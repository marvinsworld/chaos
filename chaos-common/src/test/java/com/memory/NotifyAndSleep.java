package com.memory;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2016/10/28 10:47
 */
public class NotifyAndSleep extends Thread {

    //打印内容
    private String content;

    public NotifyAndSleep(String content) {
        this.content = content;
    }

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(content);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //Runnable aa = new NotifyAndSleep()

        NotifyAndSleep aa = new NotifyAndSleep("aa");
        NotifyAndSleep bb = new NotifyAndSleep("bb");

        aa.start();
        bb.start();
    }
}
