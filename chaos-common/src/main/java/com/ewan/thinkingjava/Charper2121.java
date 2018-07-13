package com.ewan.thinkingjava;

/**
 * Description:.
 *
 * @author zhiqiang.ge
 * @version V1.0
 * @since 2017/03/02 08:50
 */
public class Charper2121 {

    public class A implements Runnable {

        @Override
        public void run() {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
