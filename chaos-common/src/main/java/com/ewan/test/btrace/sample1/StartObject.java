package com.ewan.test.btrace.sample1;

import java.util.Random;

public class StartObject {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        ActionObject actionObject = new ActionObject();
        while (true) {
            int sleepTime = random.nextInt(1000);
            actionObject.work(sleepTime);
            Thread.sleep(1000);
        }
    }
}